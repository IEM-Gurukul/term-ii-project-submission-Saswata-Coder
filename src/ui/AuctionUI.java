package ui;

import model.*;
import service.AuctionService;

import javax.swing.*;
import java.awt.*;

public class AuctionUI {
    private AuctionService service = new AuctionService();
    private JTextArea historyArea;
    private JLabel itemLabel;
    private JLabel currentUserLabel;
    private Buyer currentBuyer;

    public AuctionUI(String username) {

        JFrame frame = new JFrame("Online Auction System");
        frame.setSize(650, 450);
        frame.setLayout(new BorderLayout());

        // Initialize buyer
        currentBuyer = new Buyer(username);

        Item item1 = new Item("Laptop", 50000);
        service.addItem(item1);

        // TOP PANEL
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        itemLabel = new JLabel(item1.getDetails(), SwingConstants.CENTER);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 16));

        currentUserLabel = new JLabel("Current User: " + currentBuyer.getUsername(), SwingConstants.CENTER);
        currentUserLabel.setForeground(Color.BLUE);

        topPanel.add(itemLabel);
        topPanel.add(currentUserLabel);

        // CENTER PANEL (History)
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);

        // RIGHT PANEL (Switch User)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JTextField userField = new JTextField(10);
        JButton switchBtn = new JButton("Switch User");

        rightPanel.add(new JLabel("Change User:"));
        rightPanel.add(userField);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(switchBtn);

        // BOTTOM PANEL (Bid)
        JPanel bottomPanel = new JPanel();

        JTextField bidField = new JTextField(10);
        JButton bidBtn = new JButton("Place Bid");

        bottomPanel.add(new JLabel("Enter Bid: "));
        bottomPanel.add(bidField);
        bottomPanel.add(bidBtn);

        // SWITCH USER
        switchBtn.addActionListener(e -> {
            String newUser = userField.getText().trim();
            if (!newUser.isEmpty()) {
                currentBuyer = new Buyer(newUser);
                currentUserLabel.setText("Current User: " + newUser);
            } else {
                JOptionPane.showMessageDialog(frame, "Enter valid username!");
            }
        });

        // PLACE BID
        bidBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(bidField.getText());

                boolean success = currentBuyer.placeBid(item1, amount);

                if (success) {
                    itemLabel.setText(item1.getDetails());
                    historyArea.setText(item1.getBidHistory());
                } else {
                    JOptionPane.showMessageDialog(frame, "Bid too low!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        // ADD COMPONENTS
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}