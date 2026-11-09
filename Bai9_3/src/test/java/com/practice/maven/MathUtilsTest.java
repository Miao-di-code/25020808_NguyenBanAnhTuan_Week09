package com.practice.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testAddSuccess() {
        assertEquals(100, MathUtils.add(2, 3));
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0));
    }
}