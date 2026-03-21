package com.gla.defaultmethods;
interface PaymentProcessor {
    void pay(double amount);

    // Default method for refund
    default void refund(double amount) {
        System.out.println("Refunded amount: ₹" + amount);
    }
}

// PayPal implementation
class PayPal implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via PayPal");
    }
}

// CreditCard implementation
class CreditCard implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }
}

// Demo
public class PaymentGatewayIntegration {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPal();
        PaymentProcessor cc = new CreditCard();

        pp.pay(1000);
        pp.refund(200);

        cc.pay(500);
        cc.refund(100);
    }
}

