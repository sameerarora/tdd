package com.xyz.training.calculator;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class StringCalculator {

    private static final String DELIMITER = ",|\n";

    private static final int LIMIT = 1000;

    public int calculate(String input) {
        return isNotEmpty(input) ? numbers(input).reduce(sum).orElse(0) : 0;
    }

    private final BinaryOperator<Integer> sum = (x, y) -> {
        if (y < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        return x + (y < LIMIT ? y : 0);
    };

    private boolean isNotEmpty(String input) {
        return input != null && input != "";
    }

    private Stream<Integer> numbers(String input) {
        return stream(input.split(DELIMITER)).map(Integer::valueOf);
    }
}
