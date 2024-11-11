package com.truecodes;

public class CreditCardProcessor implements IPaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of: $" + amount);
        // Assume payment is successful
        return true;
    }
}
