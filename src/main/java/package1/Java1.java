package package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Java1 extends JFrame implements ActionListener {

    Java1() {
        // Set the size and the location of the frame
        setSize(1300, 750);
        setLocation(0, 0);
        // Set the color of the frame
        // getContentPane().setBackground(Color.BLUE); // Color class in consist in the AWT

        // We use layout to place the item in a specific location
        // Not using the Swing layout
        setLayout(null);

        // To write something we use JLabel
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        add(heading);
        // Set the place of the heading or JLabel
        heading.setBounds(8, 3, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLUE);

        // Load the image
        try {
            // URL of the image online
            URL imageUrl = new URL("https://www.pngitem.com/pimgs/m/523-5233379_employee-management-system-logo-hd-png-download.png");

            // Read the image from the URL
            Image image = ImageIO.read(imageUrl);

            // Create a scaled instance of the image
            Image scaledImage = image.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);

            // Create a JLabel with the scaled ImageIcon
            JLabel label = new JLabel(new ImageIcon(scaledImage));

            // Set bounds for the label
            label.setBounds(100, 100, 1100, 600);

            // Add the label to the frame
            add(label);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error, e.g., display an error message
        }

        // Adds of the button in the class
        JButton ClickHere = new JButton("Click Here to Continue");
        ClickHere.setBounds(400, 400, 300, 70);
        ClickHere.setBackground(Color.BLACK);
        ClickHere.setForeground(Color.WHITE);
        // Add of the event Listener
        ClickHere.addActionListener(this);
        // Add the button to the frame, not the label
        add(ClickHere);

        // show dipper effect in the heading
        new Thread(() -> {
            while (true) {
                heading.setVisible(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                heading.setVisible(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Set the frame visible after adding components
        setVisible(true);
    }

    public static void main(String[] args) {
        // We create a Construction to directly invoke
        new Java1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        // Assuming Login is another class in your package
        Login L1 = new Login();
    }
}
