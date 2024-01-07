package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java1 extends JFrame implements ActionListener {

    //JFrame consist in the SWING
    Java1(){

//        Set the size and the location of the frame
        setSize(1300, 750);
        setVisible(true);
        setLocation(0,0);
//        set the color of the frame
        getContentPane().setBackground(Color.WHITE); // Color class in consist in the AWT

        //We use layout to place the item in specific location
        // not use the swing layout
        setLayout(null);

//        To write some thing we use JLabel
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        add(heading);
        //set the place of the heading or JLabel
        heading.setBounds(8,3, 1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.BLUE);


        // Create an ImageIcon from an image file
        ImageIcon icon = new ImageIcon("front.jpg");
        // Get the image from the ImageIcon
        Image image = icon.getImage();
        // Create a scaled instance of the image to fit the JLabel
        Image scaledImage = image.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a JLabel with the scaled ImageIcon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(100,80, 1100, 600);
        add(label);
        label.setVisible(true);
//
//      Adds of the button in the class
        JButton ClickHere = new JButton("Click Here to Continue");
        ClickHere.setBounds(400,400,300,70);
        ClickHere.setBackground(Color.BLACK);
        ClickHere.setForeground(Color.WHITE);
        //*/*/*/*/****/*/*/*//**/*//*/ Add of the event Listennor
        ClickHere.addActionListener(this);
        label.add(ClickHere);

        // show dipper effect in the heading
        while(true){
            heading.setVisible(false);

            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            heading.setVisible(true);

            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
//        We create a Construction to direct invoke
        new Java1();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Login L1 = new Login();
    }
}

