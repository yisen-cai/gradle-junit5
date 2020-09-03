package com.glancebar.gradle;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTests {
    // Simple test with a name
    @Test
    @DisplayName("Name for a test")
    void testFirst() {
        assertEquals(1, 2);
    }

    // Multiple Test
    @Test
    void multipleTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertAll(() -> assertEquals(1, numbers.get(0)),
                () -> assertEquals(4, numbers.get(1)),
                () -> assertEquals(2, numbers.get(2)));
    }


    // Disabled Test
    @Test
    @Disabled("This is a disabled test")
    void disabledTest() {
        Assertions.fail("not implemented");
    }

    // Assumptions
    @Test
    void assumptionTest() {
        // Only fulfill the assumption can run next tests
        Assumptions.assumeTrue(1 > 10);
        assertEquals(1, 10);
    }


    // Value sources, use given value to run each of it test
    @ParameterizedTest(name = "{0}")
    @DisplayName("value sources test")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void valueSourcesTest(int expectedValue) {
        assertEquals(expectedValue, 1);
    }

    // Checking exceptions
    @ParameterizedTest
    @DisplayName("checking exceptions")
    @ValueSource(ints = {1, 2, 0, Integer.MAX_VALUE})
    void checkingExceptions(int expectedNumber) {
        assertThrows(InvalidParameterException.class,
                () -> new Shape(expectedNumber));
    }


    // Grouping test with Nested, similar to setUp, tearDown
    @Nested
    @DisplayName("grouping test")
    class GroupingTest {
        private final Shape shape = new Shape(4);

        @Nested
        @DisplayName("should allow")
        class ShouldAllow {

            @Test
            @DisplayName("seeingNumberOfShapeSide")
            void seeingNumberOfShapeSide() {
                assertEquals(4, shape.getValue());
            }
        }

        @Nested
        @DisplayName("should not")
        class ShouldNot{

            @Test
            @DisplayName("test method")
            void testMethod() {
                assertEquals(1, shape.getValue());
            }
        }
    }
}













