package com.truecodes;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>(); // Initialize the list of products
    }

    // Method to add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Calculate the total cost of the order
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
