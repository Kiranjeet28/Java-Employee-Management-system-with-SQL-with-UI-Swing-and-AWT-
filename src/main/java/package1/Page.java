package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page extends JFrame implements ActionListener {
    JButton add, show , Remove, Update;
    Page(){
        setSize(1400,750);
        setVisible(true);
        setLocation(0,0);
        setLayout(null);


        // Create an ImageIcon from an image file
        ImageIcon icon = new ImageIcon("home.jpg");
        // Get the image from the ImageIcon
        Image image = icon.getImage();
        // Create a scaled instance of the image to fit the JLabel
        Image scaledImage = image.getScaledInstance(1400, 750, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a JLabel with the scaled ImageIcon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0,0, 1400, 750);
        add(label);
        label.setVisible(true);
        
        
        JLabel heading = new JLabel("Employee Management System");
        label.add(heading);
        heading.setFont(new Font("serif",Font.BOLD,35));
        heading.setBounds(670,20,500,40);

         add = new JButton("Add Empolyee");
        add.setBounds(650,80,150,40);
        label.add(add);
        add.addActionListener(this);
         show = new JButton("Show Employee");
        show.setBounds(820,80,150,40);
        label.add(show);
        show.addActionListener(this);

         Update = new JButton("Update Employee");
        Update.setBounds(650,140,150,40);
        label.add(Update);
        Update.addActionListener(this);

         Remove = new JButton("Remove Employee");
        Remove.setBounds(820,140,150,40);
        label.add(Remove);
        Remove.addActionListener(this);

    }

    public static void main(String[] args) {
        new Page();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
         setVisible(false);
           new AddEmployee();
        }else if(e.getSource() == show){
            setVisible(false);
            new ViewEmployee();

        } else if (e.getSource() == Update) {
            setVisible(false);
            ViewEmployee v1 = new ViewEmployee();
            v1.setVisible(false);
            String name = v1.OptionPane();

            if (name != null && !name.trim().isEmpty()) {
              
                v1.UpdateIdWrong(name);
            } else {
                // Name is empty, open the home page
              new Page();
            }

        }else {
            setVisible(false);
            ViewEmployee v1 = new ViewEmployee();
            v1.setVisible(false);
            String name = v1.OptionPane();

            if (name != null && !name.trim().isEmpty()) {

                v1.RemoveIdWrong(name);
            } else {
                // Name is empty, open the home page
                new Page();
            }

        }
    }
}
