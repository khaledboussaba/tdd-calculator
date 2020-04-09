package fr.tdd.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void addTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(42, calculator.add(40, 2));
    }

    @Test
    void multiplyTwoPosistiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(35, calculator.multiply(5, 7));
    }

}
