package com.truecodes;

public class OrderProcessor {
    private final IPaymentProcessor paymentProcessor;
    private final InvoiceGenerator invoiceGenerator;

    public OrderProcessor(IPaymentProcessor paymentProcessor, InvoiceGenerator invoiceGenerator) {
        this.paymentProcessor = paymentProcessor;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void processOrder(Order order) {
        // Process each product in the order
        for (Product product : order.getProducts()) {
            if (product.checkStock(1)) {
                product.updateStock(1);
            } else {
                System.out.println("Not enough stock for product: " + product.getName());
                return;
            }
        }

        // Process payment
        double totalAmount = order.calculateTotal();
        boolean paymentSuccess = paymentProcessor.processPayment(totalAmount);

        if (paymentSuccess) {
            System.out.println("Order processed successfully for " + order.getCustomer().get_contact_info());
            invoiceGenerator.generateInvoice(order);
        } else {
            System.out.println("Payment failed for the order.");
        }
    }
}