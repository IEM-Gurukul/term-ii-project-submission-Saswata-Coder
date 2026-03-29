package ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    public LoginUI() {

        JFrame frame = new JFrame("Login");
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // CENTER PANEL 
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        JLabel label = new JLabel("Enter Username", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField usernameField = new JTextField();
        JButton loginBtn = new JButton("Login");

        // Add components
        centerPanel.add(label);
        centerPanel.add(usernameField);
        centerPanel.add(loginBtn);

        // Add to center of frame
        frame.add(centerPanel, BorderLayout.CENTER);

        // Button action
        loginBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();

            if (!username.isEmpty()) {
                new AuctionUI(username);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Enter username!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window on screen
        frame.setVisible(true);
    }
}