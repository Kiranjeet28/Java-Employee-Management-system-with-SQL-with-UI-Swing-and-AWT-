package package1;

import com.mysql.cj.xdevapi.SchemaImpl;
import db.Myconnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;


public class UpdateEmployee extends JFrame implements ActionListener {
    JButton Add , Back;
    JTextField tfEdu,tfFatherName,tfSlaray,tfPhone,tfdescription,tfEmail,tfAdress,tfdestination;
    JLabel adEmployeeLabel ,labelName;

 String empid;
    UpdateEmployee(String empid){
        this.empid = empid;
        System.out.println(empid);



        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

        ImageIcon icon = new ImageIcon("details.jpg");

        Image image = icon.getImage();
        // Create a scaled instance of the image to fit the JLabel
        Image scaledImage = image.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a JLabel with the scaled ImageIcon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0,40, 1100, 750);
        add(label);
        label.setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setBounds(320,30,500,50);
        add(heading);

        // Name
         labelName = new JLabel("Name");
        labelName.setFont(new Font("serif",Font.BOLD,20));
        labelName.setBounds(50,150,150,30);
        add(labelName);

        JLabel LblName = new JLabel();
        LblName.setBounds(200,150,150,30);
        add(LblName);

        //Father name
        JLabel labelFatherName = new JLabel("Father's Name ");
        labelFatherName.setFont(new Font("serif",Font.BOLD,20));
        labelFatherName.setBounds(50,200,150,30);
        add(labelFatherName);

        tfFatherName= new JTextField();
        tfFatherName.setBounds(200,200,150,30);
        add(tfFatherName);

        //Salary
        JLabel Salary = new JLabel("Salary  ");
        Salary.setFont(new Font("serif",Font.BOLD,20));
        Salary.setBounds(400,150,150,30);
        add(Salary);

        tfSlaray= new JTextField();
        tfSlaray.setBounds(600,150,150,30);
        add(tfSlaray);

        //Address
        JLabel Adress = new JLabel("Address ");
        Adress.setFont(new Font("serif",Font.BOLD,20));
        Adress.setBounds(400,200,150,30);
        add(Adress);

        tfAdress= new JTextField();
        tfAdress.setBounds(600,200,150,30);
        add(tfAdress);

        //Phone
        JLabel Phone = new JLabel("Phone");
        Phone.setFont(new Font("serif",Font.BOLD,20));
        Phone.setBounds(50,250,150,30);
        add(Phone);

        tfPhone= new JTextField();
        tfPhone.setBounds(200,250,150,30);
        add(tfPhone);

        //Email
        JLabel Email = new JLabel("Email");
        Email.setFont(new Font("serif",Font.BOLD,20));
        Email.setBounds(400,250,150,30);
        add(Email);

        tfEmail= new JTextField();
        tfEmail.setBounds(600,250,150,30);
        add(tfEmail);

        //HIghest education levele
        JLabel Edu = new JLabel("Enter you highest Education");
        Edu.setFont(new Font("serif",Font.BOLD,20));
        Edu.setBounds(50,300,500,50);
        add(Edu);

        tfEdu= new JTextField();
        tfEdu.setBounds(50,350,800,30);
        add(tfEdu);


        //Addar No
        JLabel adharNo = new JLabel("Addar No");
        adharNo.setFont(new Font("serif",Font.BOLD,20));
        adharNo.setBounds(50,400,150,30);
        add(adharNo);

        JLabel lblAddhar = new JLabel();
        lblAddhar.setBounds(200,400,150,30);
        add(lblAddhar);

        //Destination
        JLabel destination = new JLabel("Destination");
        destination.setFont(new Font("serif",Font.BOLD,20));
        destination.setBounds(400,400,150,30);
        add(destination);

        tfdestination= new JTextField();
        tfdestination.setBounds(600,400,150,30);
        add(tfdestination);

        //Employee Id
        JLabel adEmployeeId = new JLabel("Employee Id");
        adEmployeeId.setFont(new Font("serif",Font.BOLD,20));
        adEmployeeId.setBounds(50,450,150,30);
        add(adEmployeeId);

        adEmployeeLabel = new JLabel();
        adEmployeeLabel.setFont(new Font("serif",Font.BOLD,20));
        adEmployeeLabel.setBounds(200,450,150,30);
        add(adEmployeeLabel);


        //Description
        JLabel description = new JLabel("Description");
        description.setFont(new Font("serif",Font.BOLD,20));
        description.setBounds(400,450,150,30);
        add(description);

        tfdescription= new JTextField();
        tfdescription.setBounds(600,450,150,30);
        add(tfdescription);


        //Button of add and Back
        Add = new JButton("Update");
        Add.setBounds(250,500,100,50);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);

        Back = new JButton("Back");
        Back.setBounds(500,500,100,50);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        try{
            Connection connection = Myconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from employee where Id = '"+empid+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LblName.setText(rs.getString("Name"));
                adEmployeeLabel.setText(rs.getString("Id"));
                tfFatherName.setText(rs.getString("FatherName"));
                tfdescription.setText(rs.getString("Description"));
                tfSlaray.setText(rs.getString("Slaray"));
                tfPhone.setText(rs.getString("Phone"));
                tfAdress.setText(rs.getString("Adress"));
                tfEmail.setText(rs.getString("Email"));
               lblAddhar.setText(rs.getString("adharNo"));
                tfEdu.setText(rs.getString("Edu"));
                tfdestination.setText(rs.getString("destination"));

            }
        }catch (Exception ex){
            System.out.println("Update Error"+ex);
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add){

            String FatherName = tfFatherName.getText();
            String Slaray = tfSlaray.getText();
            String destination = tfdestination.getText();
            String Description = tfdescription.getText();
            String Phone = tfPhone.getText();
            String Email = tfEmail.getText();

            String Adress = tfAdress.getText();
            String Edu = tfEdu.getText();
            String Id = (String) adEmployeeLabel.getText();
            try{
                Connection connection = Myconnection.getConnection();
                // Use a proper UPDATE statement with placeholders
                String query = "UPDATE employee SET FatherName=?, Slaray=?, Phone=?, Description=?, Email=?, Adress=?,Edu=?, destination=? WHERE Id=?";
                PreparedStatement ps = connection.prepareStatement(query);

                // Set values for the placeholders

                ps.setString(1, FatherName);
                ps.setString(2, Slaray);
                ps.setString(3, Phone);
                ps.setString(4, Description);
                ps.setString(5, Email);
                ps.setString(6, Adress);
                ps.setString(7,Edu);
                ps.setString(8, destination);
                ps.setString(9, Id);

                // Execute the update
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Details are Updated");
                setVisible(false);
                new Page();
            } catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating details: " + ex.getMessage());
            }
        } else {
            setVisible(false);
            new Page();
        }
    }

}

