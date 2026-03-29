package ui;

import model.*;
import service.AuctionService;

import javax.swing.*;
import java.awt.*;

public class AuctionUI {
    private AuctionService service = new AuctionService();

    public AuctionUI(String username) {
        JFrame frame = new JFrame("Auction System");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        Buyer buyer = new Buyer(username);

        Item item1 = new Item("Laptop", 50000);
        service.addItem(item1);

        JLabel itemLabel = new JLabel(item1.getDetails());
        JTextField bidField = new JTextField(10);
        JButton bidBtn = new JButton("Place Bid");

        frame.add(itemLabel);
        frame.add(bidField);
        frame.add(bidBtn);

        bidBtn.addActionListener(e -> {
            double amount = Double.parseDouble(bidField.getText());
            buyer.placeBid(item1, amount);
            itemLabel.setText(item1.getDetails());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}