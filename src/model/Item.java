package model;

import java.util.ArrayList;

public class Item {
    private String name;
    private double highestBid;
    private Buyer highestBidder;
    private ArrayList<Bid> bidHistory;
    private boolean auctionEnded = false;

    public Item(String name, double startingPrice) {
        this.name = name;
        this.highestBid = startingPrice;
        this.bidHistory = new ArrayList<>();
    }

    public boolean placeBid(Buyer buyer, double amount) {
        if (auctionEnded) return false;

        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = buyer;
            bidHistory.add(new Bid(buyer, amount));
            return true;
        }
        return false;
    }

    public void endAuction() {
        auctionEnded = true;
    }

    public boolean isAuctionEnded() {
        return auctionEnded;
    }

    public String getWinner() {
        if (highestBidder == null) return "No bids";
        return highestBidder.getUsername() + " won with ₹" + highestBid;
    }

    public String getDetails() {
        return name + " | Highest Bid: ₹" + highestBid +
                " | Bidder: " + (highestBidder != null ? highestBidder.getUsername() : "None");
    }

    public String getBidHistory() {
        StringBuilder history = new StringBuilder();
        for (Bid bid : bidHistory) {
            history.append(bid.toString()).append("\n");
        }
        return history.toString();
    }
}