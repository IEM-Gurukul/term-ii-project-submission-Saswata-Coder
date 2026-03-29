package model;

import java.util.ArrayList;

public class Item {
    private String name;
    private double highestBid;
    private Buyer highestBidder;
    private ArrayList<Bid> bidHistory;

    public Item(String name, double startingPrice) {
        this.name = name;
        this.highestBid = startingPrice;
        this.bidHistory = new ArrayList<>();
    }

    public void placeBid(Buyer buyer, double amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = buyer;
            bidHistory.add(new Bid(buyer, amount));
        } else {
            System.out.println("Bid too low!");
        }
    }

    public String getDetails() {
        return name + " | Highest Bid: " + highestBid +
               " | Bidder: " + (highestBidder != null ? highestBidder.getUsername() : "None");
    }
}