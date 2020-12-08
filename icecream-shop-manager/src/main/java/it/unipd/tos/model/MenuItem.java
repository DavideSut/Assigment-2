////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

public class MenuItem {

    private ItemType itemType;
    private String name;
    private double price;

    public enum ItemType {
        GELATO,BUDINO,BEVANDA;
    }

    public MenuItem(ItemType itemType, String name, double price) { 

        if(itemType == null) {
            throw new IllegalArgumentException("ItemType cannot be null");
        }
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name is invalid");
        }
        if(price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}