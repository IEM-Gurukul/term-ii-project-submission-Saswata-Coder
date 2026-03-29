package model;

public class Bid {
    private Buyer buyer;
    private double amount;

    public Bid(Buyer buyer, double amount) {
        this.buyer = buyer;
        this.amount = amount;
    }
}