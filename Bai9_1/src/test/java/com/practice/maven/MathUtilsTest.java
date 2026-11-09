package com.practice.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(30, mathUtils.add(10, 20));
    }

    @Test
    void testDivideByZero() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(IllegalArgumentException.class, () -> mathUtils.divide(10, 0));
    }
}