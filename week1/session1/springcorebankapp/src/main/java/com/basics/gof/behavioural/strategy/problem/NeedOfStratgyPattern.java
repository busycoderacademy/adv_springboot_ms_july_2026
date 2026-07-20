package com.basics.gof.behavioural.strategy.problem;

// Or do we have one shopping cart with different ways of paying
class ShoppingCartCreditCard {
    public void checkout(int amount) {
        System.out.println("Paid using Credit Card: " + amount);
    }
}
class ShoppingCartPayPal {
    public void checkout(int amount) {
        System.out.println("Paid using PayPal: " + amount);
    }
}
//Client asks for UPI
//Developer creates yet another class.
class ShoppingCartUPI {
    public void checkout(int amount) {
        System.out.println("Paid using UPI: " + amount);
    }
}

public class NeedOfStratgyPattern {
    public static void main(String[] args) {

        ShoppingCartCreditCard cart1 = new ShoppingCartCreditCard();
        cart1.checkout(5000);

        ShoppingCartPayPal cart2 = new ShoppingCartPayPal();
        cart2.checkout(3000);
    }
}
