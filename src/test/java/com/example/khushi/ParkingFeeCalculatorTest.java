
package com.example.khushi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParkingFeeCalculatorTest {

    @Test
    void testTwoWheelerFee() {
        assertEquals(10.0,
                ParkingFeeCalculator.calculateFee("two-wheeler", 1));
    }

    @Test
    void testFourWheelerFee() {
        assertEquals(20.0,
                ParkingFeeCalculator.calculateFee("four-wheeler", 1));
    }

    @Test
    void testMultiHourParking() {
        assertEquals(60.0,
                ParkingFeeCalculator.calculateFee("four-wheeler", 3));
    }

    @Test
    void testPartialHourRounding() {
        assertEquals(30.0,
                ParkingFeeCalculator.calculateFee("two-wheeler", 2.5));
    }

    @Test
    void testZeroDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> ParkingFeeCalculator.calculateFee("two-wheeler", 0));
    }

    @Test
    void testNegativeDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> ParkingFeeCalculator.calculateFee("two-wheeler", -2));
    }

    @Test
    void testUnsupportedVehicleType() {
        assertThrows(IllegalArgumentException.class,
                () -> ParkingFeeCalculator.calculateFee("bus", 2));
    }

    @Test
    void testCaseInsensitiveVehicleType() {
        assertEquals(20.0,
                ParkingFeeCalculator.calculateFee("FOUR-WHEELER", 1));
    }
}
