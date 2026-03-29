package model;

public class Buyer extends User {

    public Buyer(String username) {
        super(username);
    }

    public boolean placeBid(Item item, double amount) {
        return item.placeBid(this, amount);
    }
}