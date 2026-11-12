
package com.example.khushi;

import java.util.Scanner;

public class ParkingFeeCalculator {

    public static double calculateFee(String vehicleType, double hours) {

        if (hours <= 0 || !Double.isFinite(hours)) {
            throw new IllegalArgumentException("Invalid parking duration");
        }

        double rate;

        if (vehicleType.equalsIgnoreCase("two-wheeler")) {
            rate = 10;
        }
        else if (vehicleType.equalsIgnoreCase("four-wheeler")) {
            rate = 20;
        }
        else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }

        int totalHours = (int) Math.ceil(hours);

        return totalHours * rate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== VEHICLE PARKING FEE CALCULATOR =====");

        System.out.print("Enter vehicle type (two-wheeler/four-wheeler): ");
        String vehicleType = sc.nextLine();

        System.out.print("Enter parking duration in hours: ");
        double hours = sc.nextDouble();

        try {
            double fee = calculateFee(vehicleType, hours);

            System.out.println("\n===== PARKING DETAILS =====");
            System.out.println("Vehicle Type       : " + vehicleType);
            System.out.println("Parking Duration   : " + hours + " hours");
            System.out.println("Hourly Rate        : Rs. " +
                    (vehicleType.equalsIgnoreCase("two-wheeler") ? 10 : 20));
            System.out.println("Total Parking Fee  : Rs. " + fee);

        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
