package com.pluralsight;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public boolean isFinance() { return finance; }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        double tax = price * 0.05;
        double recording = 100;
        double processing = price < 10000 ? 295 : 495;
        return price + tax + recording + processing;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0.0;

        double loanAmount = getTotalPrice();
        int months = getVehicleSold().getPrice() >= 10000 ? 48 : 24;
        double rate = getVehicleSold().getPrice() >= 10000 ? 0.0425 / 12 : 0.0525 / 12;

        return (loanAmount * rate) / (1 - Math.pow(1 + rate, -months));
    }
}
