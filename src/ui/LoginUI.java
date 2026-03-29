package ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    public LoginUI() {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JTextField usernameField = new JTextField(15);
        JButton loginBtn = new JButton("Login");

        frame.add(new JLabel("Enter Username:"));
        frame.add(usernameField);
        frame.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            new AuctionUI(username);
            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}