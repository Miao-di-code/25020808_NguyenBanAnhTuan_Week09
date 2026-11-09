package com.practice.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testAddSuccess() {
        assertEquals(5, MathUtils.add(2, 3), "Phép cộng 2 + 3 phải bằng 5");
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0));
    }
}