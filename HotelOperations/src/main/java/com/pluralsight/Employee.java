package com.pluralsight;

class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double currentPunchInTime = null;

    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
    }

    public void punchTimeCard(double time) {
        if (currentPunchInTime == null) {
            currentPunchInTime = time; // punch in
        } else {
            double worked = time - currentPunchInTime;
            if (worked > 0) {
                hoursWorked += worked;
            }
            currentPunchInTime = null; // punch out
        }
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }
}
