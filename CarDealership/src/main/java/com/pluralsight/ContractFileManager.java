package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contracts.csv", true))) {
            Vehicle v = contract.getVehicleSold();
            String base = String.join("|",
                    contract instanceof SalesContract ? "SALE" : "LEASE",
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    String.valueOf(v.getVin()),
                    String.valueOf(v.getYear()),
                    v.getMake(),
                    v.getModel(),
                    v.getVehicleType(),
                    v.getColor(),
                    String.valueOf(v.getOdometer()),
                    String.format("%.2f", v.getPrice())
            );

            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                double price = v.getPrice();
                double tax = price * 0.05;
                double recording = 100;
                double proc = price < 10000 ? 295 : 495;
                String finance = sc.isFinance() ? "YES" : "NO";
                double monthly = sc.getMonthlyPayment();
                double total = sc.getTotalPrice();

                writer.println(String.join("|", base,
                        String.format("%.2f", tax),
                        String.format("%.2f", recording),
                        String.format("%.2f", proc),
                        String.format("%.2f", total),
                        finance,
                        String.format("%.2f", monthly)
                ));
            } else {
                LeaseContract lc = (LeaseContract) contract;
                double price = v.getPrice();
                double expected = price * 0.5;
                double fee = price * 0.07;
                double total = lc.getTotalPrice();
                double monthly = lc.getMonthlyPayment();

                writer.println(String.join("|", base,
                        String.format("%.2f", expected),
                        String.format("%.2f", fee),
                        String.format("%.2f", total),
                        String.format("%.2f", monthly)
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
