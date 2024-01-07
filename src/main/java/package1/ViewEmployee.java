package package1;

import db.Myconnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


public class ViewEmployee extends JFrame implements ActionListener {
    String name;
   String OptionPane(){
        frame = new JFrame();
        name = JOptionPane.showInputDialog(frame,"Enter Employee Id");
       if (name == null || name.trim().isEmpty()) {
           // User canceled or closed the dialog, return an indicator (null or empty string)
           return null;
       }

        return(name);
    }
    JButton Back, searchButton,AddEmployee,UpdateEmployee,RemoveEmployee;
    JTable table;
    DefaultTableModel model;
    JTextField searchField;
    JFrame frame;


    ViewEmployee() {
        setSize(1100, 800);
        setLocation(20, 20);
        setVisible(true);

        ImageIcon icon = new ImageIcon("view.jpg");
        // Get the image from the ImageIcon
        Image image = icon.getImage();
        // Create a scaled instance of the image to fit the JLabel
        Image scaledImage = image.getScaledInstance(1100, 750, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a JLabel with the scaled ImageIcon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0,40, 1100, 750);
        add(label);
        label.setVisible(true);

        JLabel heading = new JLabel("Here a Details of the Employee");
        add(heading);
        heading.setFont(new Font("serif",Font.BOLD,28));
        heading.setBounds(20,20,500,50);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Back = new JButton("Back");
        Back.setBounds(8, 100, 150, 20);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        searchField = new JTextField();
        searchField.setBounds(200, 100, 150, 20);
        add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(220, 100, 150, 20);
        searchButton.addActionListener(this);
        add(searchButton);

       AddEmployee = new JButton("Add");
        AddEmployee.setBounds(420, 100, 150, 20);
        AddEmployee.addActionListener(this);
        add(AddEmployee);

        UpdateEmployee = new JButton("Update");
        UpdateEmployee.setBounds(610, 100, 150, 20);
        UpdateEmployee.addActionListener(this);
        add(UpdateEmployee);

        RemoveEmployee = new JButton("Remove");
        RemoveEmployee.setBounds(780, 100, 150, 20);
        RemoveEmployee.addActionListener(this);
        add(RemoveEmployee);

        // Initialize the table model
        model = new DefaultTableModel();
        table = new JTable(model);

        // Add columns to the model (customize based on your table structure)
        model.addColumn("Name");
        model.addColumn("Father Name");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Description"); //
        model.addColumn("Email"); //
        model.addColumn("Address"); //
        model.addColumn("Addhar Card");
        model.addColumn("Distination");
        model.addColumn("Education");
        model.addColumn("Employee ID");

        try {
            Connection connection = Myconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();

            // Get metadata to determine the number of columns
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Iterate through the result set and add rows to the model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 200, 1000, 200);
        add(scrollPane);
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Page();

        } else if (e.getSource() == searchButton) {
            performSearch();
        }else if(e.getSource()==AddEmployee){
            setVisible(false);

            new AddEmployee();
        }else if (e.getSource() == UpdateEmployee){
            setVisible(false);
            ViewEmployee v1 = new ViewEmployee();
            v1.setVisible(false);
            String name = v1.OptionPane();

            if (name != null && !name.trim().isEmpty()) {
                // Name is not empty, create a new instance of UpdateEmployee with the obtained name
                v1.UpdateIdWrong(name);
            } else {
                // Name is empty, open the home page
                new Page();
            }
        }else{
            setVisible(false);
           setVisible(false);
            String name = OptionPane();

            if (name != null && !name.trim().isEmpty()) {

                RemoveIdWrong(name);
            } else {
                // Name is empty, open the  page
                new Page();
            }
        }
    }

    private void performSearch() {
        String searchTerm = searchField.getText().trim();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        try {
            // Specify the column index for "Employee ID" (assuming it is the last column)
            int columnIndex = model.findColumn("Employee ID");

            if (searchTerm.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                // Use RowFilter.regexFilter to filter based on the Employee ID column
                sorter.setRowFilter(RowFilter.regexFilter(searchTerm, columnIndex));

                // Check if any rows are filtered
                if (sorter.getViewRowCount() == 0) {
                    // No rows matched the filter criteria, show a dialog box
                    JOptionPane.showMessageDialog(this, "Employee ID not found or incorrect.", "Search Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException e) {
            // Handle the case where the column is not found
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Column 'Employee ID' not found in the table model.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void UpdateIdWrong(String name) {
        String searchTerm = name;
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        try {
            // Specify the column index for "Employee ID" (assuming it is the last column)
            int columnIndex = model.findColumn("Employee ID");

            if (searchTerm.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                // Use RowFilter.regexFilter to filter based on the Employee ID column
                sorter.setRowFilter(RowFilter.regexFilter(searchTerm, columnIndex));

                // Check if any rows are filtered
                if (sorter.getViewRowCount() == 0) {
                    // No rows matched the filter criteria, show a dialog box

                    JOptionPane.showMessageDialog(this, "Employee ID not found or incorrect.", "Search Error", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    new Page();
                }
                else{
                    new UpdateEmployee(name);
                }
            }
        } catch (IllegalArgumentException e) {
            // Handle the case where the column is not found
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Column 'Employee ID' not found in the table model.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void RemoveIdWrong(String name) {
        String searchTerm = name;
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        try {
            // Specify the column index for "Employee ID" (assuming it is the last column)
            int columnIndex = model.findColumn("Employee ID");

            if (searchTerm.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                // Use RowFilter.regexFilter to filter based on the Employee ID column
                sorter.setRowFilter(RowFilter.regexFilter(searchTerm, columnIndex));

                // Check if any rows are filtered
                if (sorter.getViewRowCount() == 0) {
                    // No rows matched the filter criteria, show a dialog box

                    JOptionPane.showMessageDialog(this, "Employee ID not found or incorrect.", "Search Error", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    new Page();
                }
                else{
                    new Remove_employee(name);
                }
            }
        } catch (IllegalArgumentException e) {
            // Handle the case where the column is not found
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Column 'Employee ID' not found in the table model.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
