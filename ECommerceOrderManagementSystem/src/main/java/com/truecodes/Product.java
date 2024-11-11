package com.truecodes;

public class Product implements IStockManager {
    private final String name;
    private final double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // IStockManager implementation
    @Override
    public boolean checkStock(int quantity) {
        return stock >= quantity;
    }

    @Override
    public void updateStock(int quantity) {
        stock -= quantity;
    }

    public String getDetails() {
        return "Product: " + name + ", Price: " + price + ", Stock: " + stock;
    }
}
