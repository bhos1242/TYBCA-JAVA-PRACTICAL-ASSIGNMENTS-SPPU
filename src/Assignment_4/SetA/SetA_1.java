package Assignment_4.SetA;

import javax.swing.*;
import java.awt.*;

public class SetA_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);
        frame.setLayout(new FlowLayout());

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        // Add components to the frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);

        // Set frame visibility
        frame.setVisible(true);
    }
}
