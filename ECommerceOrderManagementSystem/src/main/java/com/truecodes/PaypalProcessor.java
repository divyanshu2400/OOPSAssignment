package com.truecodes;

public class PaypalProcessor implements IPaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of: $" + amount);
        // Assume payment is successful
        return true;
    }
}