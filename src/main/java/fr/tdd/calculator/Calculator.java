package fr.tdd.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int leftArgument, int secondNumber) {
        return leftArgument + secondNumber;
    }

    public int sub(int leftArgument, int rightArgument) {
        return leftArgument - rightArgument;
    }

    public int multiply(int leftArgument, int rightArgument) {
        return leftArgument * rightArgument;
    }

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Argument 'denominator' is '0'");
        }
        return numerator / denominator;
    }

    public double add(double leftArgument, double rightArgument) {
        return leftArgument + rightArgument;
    }

    public double sub(double leftArgument, double rightArgument) {
        return leftArgument - rightArgument;
    }

    public double multiply(double leftArgument, double rightArgument) {
        return leftArgument * rightArgument;
    }

    public double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Argument 'denominator' is '0'");
        }
        return numerator / denominator;
    }

    public Set<Integer> digitsSet(int inputNumber) {
        Set<Integer> integers = new HashSet<>();
        String inputNumberString = String.valueOf(inputNumber);

        for (int i = 0; i < inputNumberString.length(); i++) {
            if (inputNumberString.charAt(i) != '-') {
                int digit = Integer.parseInt(String.valueOf(inputNumberString.charAt(i)));
                integers.add(digit);
            }
        }
        return integers;
    }

    public int factorial(int inputNumber) {
        if (inputNumber <= 1) {
            return inputNumber;
        }
        return inputNumber * factorial(inputNumber - 1);
    }

}
