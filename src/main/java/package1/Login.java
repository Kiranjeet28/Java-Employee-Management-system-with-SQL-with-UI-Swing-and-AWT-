package package1;
import db.Myconnection;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







public class Login extends JFrame implements ActionListener {
    JTextField tfUsername,tfPassword;
    Login(){
        // Create of the frame
        setSize(650,350);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);

        //to show a username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,20,100,30);
        add(lblUsername);

        //To get a Text Box for Username
        tfUsername = new JTextField();
        tfUsername.setBounds(150,20,150,30);
        add(tfUsername);

        //to show a Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40,70,100,30);
        add(lblPassword);

        //To get a Text Box for Password
        tfPassword = new JTextField();
        tfPassword.setBounds(150,70,150,30);
        add(tfPassword);

        // Adds of the button in the class
        JButton Login = new JButton("LOGIN");
        Login.setBounds(150,140,100,50);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        // Create an ImageIcon from an image file
        ImageIcon icon = new ImageIcon("second.jpg");
        // Get the image from the ImageIcon
        Image image = icon.getImage();
        // Create a scaled instance of the image to fit the JLabel
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a JLabel with the scaled ImageIcon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(350, 1, 145, 145);
        add(label);

    }

    public  void actionPerformed(ActionEvent ae){
        try{

            String username = tfUsername.getText();
            String password =tfPassword.getText();
            Connection connection = Myconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from login where usernames = '"+username+"'and passwords = '"+password+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                setVisible(false);
                new Page();
            }else {
                JOptionPane.showMessageDialog(null,"Invaild Username or PassWord");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Login l1 =new Login();
    }
}
