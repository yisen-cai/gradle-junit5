package com.glancebar.gradle;

import java.security.InvalidParameterException;

public class Shape {
    private final int value;

    public Shape(int value) {
        if (value < 3 || value == Integer.MAX_VALUE) {
            throw new InvalidParameterException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
