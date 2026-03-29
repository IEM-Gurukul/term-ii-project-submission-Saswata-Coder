package service;

import model.*;
import java.util.ArrayList;

public class AuctionService {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}