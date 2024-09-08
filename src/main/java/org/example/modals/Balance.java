package org.example.modals;

public class Balance {
    private double amount;

    public Balance(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return (double) Math.round(amount * 100) /100;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
