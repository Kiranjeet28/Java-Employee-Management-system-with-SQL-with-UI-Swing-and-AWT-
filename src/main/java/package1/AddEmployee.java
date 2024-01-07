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
import java.util.concurrent.ConcurrentNavigableMap;
import  java.util.random.*;

public class AddEmployee extends JFrame implements ActionListener {
    JButton Add , Back;
    JTextField tfName,tfFatherName,tfSlaray,tfPhone,tfdescription,tfEmail,tfAdress,tfadharNo,tfdestination;
    JComboBox tfEdu;
    JLabel adEmployeeLabel;

    //Rendom class OBJ
    Random random = new Random();
    int number = random.nextInt(999999);
    AddEmployee(){

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setBounds(320,30,500,50);
        add(heading);

        // Name
        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("serif",Font.BOLD,20));
        labelName.setBounds(50,150,150,30);
        add(labelName);

        tfName = new JTextField();
        tfName.setBounds(200,150,150,30);
        add(tfName);

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

        String cources[] = {"10th","12th","Diploma","BTech","Mtech"};
        tfEdu= new JComboBox(cources);
        tfEdu.setBounds(50,350,800,30);
        add(tfEdu);


        //Addar No
        JLabel adharNo = new JLabel("Addar No");
        adharNo.setFont(new Font("serif",Font.BOLD,20));
        adharNo.setBounds(50,400,150,30);
        add(adharNo);

        tfadharNo= new JTextField();
        tfadharNo.setBounds(200,400,150,30);
        add(tfadharNo);

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

        adEmployeeLabel = new JLabel("" + number);
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
         Add = new JButton("Add Details");
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

    }

    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add){
            String Name = tfName.getText(); //
            String FatherName = tfFatherName.getText(); //
            String Slaray = tfSlaray.getText(); //
            String destination = tfdestination.getText();
            String Description = tfdescription.getText();
            String Phone = tfPhone.getText(); //
            String Email = tfEmail.getText();
            String adharNo = tfadharNo.getText();
            String Adress = tfAdress.getText();
            String Edu = (String) tfEdu.getSelectedItem();
            String Id = (String) adEmployeeLabel.getText();
            try{
                Connection connection = Myconnection.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into employee values('"+Name+"','"+FatherName+"','"+Slaray+"','"+Phone+"','"+Description+"','"+Email+"','"+Adress+"','"+adharNo+"','"+destination+"','"+Edu+"','"+Id+"')");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Page();
            }catch (Exception ex){
                System.out.println(ex);

            }

        }else{
            setVisible(false);
            new Page();
        }
    }
}
