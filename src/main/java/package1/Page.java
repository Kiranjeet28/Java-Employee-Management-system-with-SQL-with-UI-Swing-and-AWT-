package package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Page extends JFrame implements ActionListener {
    JButton add, show, remove, update;

    Page() {
        setSize(1400, 750);
        setVisible(true);
        setLocation(0, 0);
        setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(0, 0, 1400, 750);
        add(label);

        try {
            URL imageUrl = new URL("https://shiftin.app/wp-content/uploads/2021/10/what-are-employee-management-systems.jpg");
            Image image = ImageIO.read(imageUrl);
            if (image != null) {
                Image scaledImage = image.getScaledInstance(1400, 750, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));
            } else {
                System.err.println("Failed to load image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("serif", Font.BOLD, 35));
        heading.setBounds(670, 20, 500, 40);
        label.add(heading);
        heading.setForeground(Color.WHITE);


        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        label.add(add);
        add.addActionListener(this);

        show = new JButton("Show Employee");
        show.setBounds(820, 80, 150, 40);
        label.add(show);
        show.addActionListener(this);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        label.add(update);
        update.addActionListener(this);

        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        label.add(remove);
        remove.addActionListener(this);
    }

    public static void main(String[] args) {
        new Page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (e.getSource() == show) {
            setVisible(false);
            new ViewEmployee();
        } else if (e.getSource() == update) {
            setVisible(false);
            ViewEmployee v1 = new ViewEmployee();
            v1.setVisible(true);
            String name = v1.OptionPane();
            if (name != null && !name.trim().isEmpty()) {
                v1.UpdateIdWrong(name);
            } else {
                setVisible(true);
            }
        } else if (e.getSource() == remove) {
            setVisible(false);
            ViewEmployee v1 = new ViewEmployee();
            v1.setVisible(true);
            String name = v1.OptionPane();
            if (name != null && !name.trim().isEmpty()) {
                v1.RemoveIdWrong(name);
            } else {
                setVisible(true);
            }
        }
    }
}
