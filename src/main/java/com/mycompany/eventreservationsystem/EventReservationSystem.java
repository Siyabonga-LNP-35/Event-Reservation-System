/*
*click https://github.com/Siyabonga-LNP-35/Event-Reservation-System.git to go to github
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventreservationsystem;

/**
 *
 * @author siyab
 */

public class EventReservationSystem {

    // Method to check booking code format
    public static boolean checkBookingCode(String code) {
        // Booking code must contain an underscore and not exceed 12 characters
        return code.contains("_") && code.length() <= 12;
    }

    // Method to check password complexity
    public static boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 characters long, have one capital letter, one number, and one special character
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#\\$%^&*].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }

    // Method to make a reservation
    public static String makeReservation(String bookingCode, String password) {
        // Validate the booking code
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        }
        
        // Validate the password complexity
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        
        // If both are valid, confirm the reservation
        return "Reservation successfully made!";
    }

    public static void main(String[] args) {
        // Example booking code and password for testing
        String bookingCode = "Event_123";
        String password = "Passw0rd!";
        
        // Make a reservation
        String result = makeReservation(bookingCode, password);
        System.out.println(result); // Output based on the validity of inputs
    }
}
