package model;

public class Buyer extends User {

    public Buyer(String username) {
        super(username);
    }

    public void placeBid(Item item, double amount) {
        item.placeBid(this, amount);
    }
}