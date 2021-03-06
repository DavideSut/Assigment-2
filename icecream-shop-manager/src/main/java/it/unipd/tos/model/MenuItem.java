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
            throw new IllegalArgumentException("ItemType non può essere null");
        }
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name non è valido");
        }
        if(price <= 0) {
            throw new IllegalArgumentException("Price deve essere > 0");
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