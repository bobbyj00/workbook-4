package com.pluralsight;

public class TheApp {
    public static void main(String[] args) {
        // Test Room class
        Room room1 = new Room(2, 150.0, false, false);
        System.out.println("Room available: " + room1.isAvailable());
        room1.checkIn();
        System.out.println("Checked in. Room available: " + room1.isAvailable());
        room1.checkout();
        System.out.println("Checked out. Room available: " + room1.isAvailable());
        room1.cleanRoom();
        System.out.println("Cleaned. Room available: " + room1.isAvailable());

        // Test Reservation class
        Reservation res1 = new Reservation("king", 3, true);
        System.out.println("Reservation total: $" + res1.getReservationTotal());

        // Test Employee class
        Employee emp1 = new Employee("E001", "John Doe", "Front Desk", 20.0);
        emp1.punchTimeCard(9.0); // Punch in
        emp1.punchTimeCard(17.5); // Punch out
        System.out.println("Total Pay: $" + emp1.getTotalPay());
        System.out.println("Regular Hours: " + emp1.getRegularHours());
        System.out.println("Overtime Hours: " + emp1.getOvertimeHours());
    }
}
