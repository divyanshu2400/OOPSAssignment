package com.truecodes;

public class InvoiceGenerator {
    public void generateInvoice(Order order) {
        // Generate and print invoice details
        System.out.println("Invoice generated for order of: " + order.getCustomer().get_contact_info());
        // Details would typically include the list of products, total amount, etc.
    }
}
