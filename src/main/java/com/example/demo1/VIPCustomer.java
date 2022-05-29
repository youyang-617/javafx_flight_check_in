package com.example.demo1;

/**
 * special functions extends customer
 */
public class VIPCustomer extends Customer {
    private double discount = 0.85;
    public VIPCustomer(String bookingNum) {
        super(bookingNum);
    }

    public VIPCustomer(String lastName, String idNum) {
        super(lastName, idNum);
    }

    @Override
    public int getMoney() {
        money = (int) (discount * (extrafeeMeal+extrafeeSeat));
        return money;
    }
}
