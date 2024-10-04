/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.eventreservationsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author siyab
 */

class EventReservationSystemTest {

    private EventReservationSystem system;

    @BeforeEach
    void setUp() {
        system = new EventReservationSystem();
    }

    @Test
    void testCheckBookingCode() {
        // Valid booking codes
        assertTrue(system.checkBookingCode("Event_123"));
        assertTrue(system.checkBookingCode("Concert_99"));

        // Invalid booking codes
        assertFalse(system.checkBookingCode("Event123")); // No underscore
        assertFalse(system.checkBookingCode("Very_Long_Event_Code")); // Exceeds 12 characters
        assertFalse(system.checkBookingCode("")); // Empty string
    }

    @Test
    void testCheckPasswordComplexity() {
        // Valid passwords
        assertTrue(system.checkPasswordComplexity("Password1@"));
        assertTrue(system.checkPasswordComplexity("C0mpl3x!"));

        // Invalid passwords
        assertFalse(system.checkPasswordComplexity("short")); // Too short
        assertFalse(system.checkPasswordComplexity("lowercase1!")); // No uppercase
        assertFalse(system.checkPasswordComplexity("UPPERCASE!")); // No number
        assertFalse(system.checkPasswordComplexity("NoSpecial1")); // No special character
    }

    @Test
    void testMakeReservation() {
        // Successful reservation
        assertEquals("Reservation successfully made!", 
                     system.makeReservation("Event_123", "Password1@"));

        // Invalid booking code
        assertEquals("Booking code is incorrectly formatted.", 
                     system.makeReservation("Event123", "Password1@"));

        // Invalid password
        assertEquals("Password does not meet the complexity requirements.", 
                     system.makeReservation("Event_123", "simple"));
    }
}