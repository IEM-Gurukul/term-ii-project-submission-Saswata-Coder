package ui;

import model.*;
import service.AuctionService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AuctionUI {
    private AuctionService service = new AuctionService();
    private JTextArea historyArea;
    private JLabel itemLabel;
    private JLabel timerLabel;

    private Buyer currentBuyer;
    private HashMap<String, Buyer> buyers = new HashMap<>();

    private JComboBox<String> userDropdown;

    private int timeLeft = 15;
    private Timer timer;

    public AuctionUI(String username) {

        JFrame frame = new JFrame("Online Auction System");
        frame.setSize(750, 500);
        frame.setLayout(new BorderLayout());

        // INITIAL USER
        currentBuyer = new Buyer(username);
        buyers.put(username, currentBuyer);

        // ITEM
        Item item1 = new Item("Laptop", 50000);
        service.addItem(item1);

        // TOP PANEL
        JPanel topPanel = new JPanel(new GridLayout(4, 1));

        itemLabel = new JLabel(item1.getDetails(), SwingConstants.CENTER);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 16));

        timerLabel = new JLabel("Time Left: 15s", SwingConstants.CENTER);
        timerLabel.setForeground(Color.RED);

        // USER INPUT FIELD
        JTextField userField = new JTextField(10);
        JButton addUserBtn = new JButton("Add / Switch User");

        // DROPDOWN
        userDropdown = new JComboBox<>();
        userDropdown.addItem(username);

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("Enter Username: "));
        userPanel.add(userField);
        userPanel.add(addUserBtn);
        userPanel.add(userDropdown);

        topPanel.add(itemLabel);
        topPanel.add(timerLabel);
        topPanel.add(userPanel);

        // CENTER (History)
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);

        // BOTTOM (Bid Panel)
        JPanel bottomPanel = new JPanel();

        JTextField bidField = new JTextField(10);
        JButton bidBtn = new JButton("Place Bid");

        bottomPanel.add(new JLabel("Enter Bid: "));
        bottomPanel.add(bidField);
        bottomPanel.add(bidBtn);

        // ADD / SWITCH USER
        addUserBtn.addActionListener(e -> {
            String name = userField.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter valid username!");
                return;
            }

            if (!buyers.containsKey(name)) {
                Buyer newBuyer = new Buyer(name);
                buyers.put(name, newBuyer);
                userDropdown.addItem(name);
            }

            currentBuyer = buyers.get(name);
            userDropdown.setSelectedItem(name);
        });

        // DROPDOWN SWITCH
        userDropdown.addActionListener(e -> {
            String selectedUser = (String) userDropdown.getSelectedItem();
            currentBuyer = buyers.get(selectedUser);
        });

        // TIMER
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft + "s");

                if (timeLeft <= 0) {
                    timer.stop();
                    item1.endAuction();

                    JOptionPane.showMessageDialog(frame,
                            "Auction Ended!\nWinner: " + item1.getWinner());
                }
            }
        });

        timer.start();

        // BID BUTTON
        bidBtn.addActionListener(e -> {

            if (item1.isAuctionEnded()) {
                JOptionPane.showMessageDialog(frame, "Auction already ended!");
                return;
            }

            try {
                double amount = Double.parseDouble(bidField.getText());

                boolean success = currentBuyer.placeBid(item1, amount);

                if (success) {
                    itemLabel.setText(item1.getDetails());
                    historyArea.setText(item1.getBidHistory());

                    // RESET TIMER AFTER EACH BID
                    timeLeft = 15;
                    timerLabel.setText("Time Left: " + timeLeft + "s");

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
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}