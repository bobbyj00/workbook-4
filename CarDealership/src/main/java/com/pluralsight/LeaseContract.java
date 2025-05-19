package com.pluralsight;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        return price * 0.5 + price * 0.07;
    }

    @Override
    public double getMonthlyPayment() {
        double leaseAmount = getTotalPrice();
        double rate = 0.04 / 12;
        int months = 36;
        return (leaseAmount * rate) / (1 - Math.pow(1 + rate, -months));
    }
}
