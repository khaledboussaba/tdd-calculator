package fr.tdd.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> integers = new HashSet<>();
        String numberToString = String.valueOf(number);

        for (int i = 0; i < numberToString.length(); i++) {
            if (numberToString.charAt(i) != '-') {
                int digit = Integer.parseInt(String.valueOf(numberToString.charAt(i)));
                integers.add(digit);
            }
        }
        return integers;
    }
}
