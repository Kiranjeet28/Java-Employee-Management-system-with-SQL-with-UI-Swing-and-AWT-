package package1;

import db.Myconnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Remove_employee {
    Remove_employee(String name) {
        try {
            Connection connection = Myconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM employee WHERE Id = ?");
            ps.setString(1, name);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee Removed Successfully");
                new Page();
            } else {
                JOptionPane.showMessageDialog(null, "No employee found with the given ID");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
