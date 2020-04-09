package fr.tdd.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

public class CalculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("call before all tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestsDuration() {
        System.out.println("call after all tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Tests duration is : {0} ms", duration));
    }

    @BeforeEach
    public void initCalculator() {
        System.out.println("call before each test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("call after each test");
        calculatorUnderTest = null;
    }

    @Test
    public void addition_addTwoPositiveNumbers() {
        assertEquals(42, calculatorUnderTest.add(40, 2));
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({"1,1,2", "4,5,9", "99,122,221"})
    public void addition_ShouldReturnTheSumOfMultipleIntegers(int arg1, int arg2, int expectResult) {
        int actualResult = calculatorUnderTest.add(arg1,arg2);
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void multiplication_multiplyTwoPosistiveNumbers() {
        assertEquals(35, calculatorUnderTest.multiply(5, 7));
    }

    @ParameterizedTest(name = "{0} x 0 should equal to 0")
    @ValueSource(ints = {1, 2, 42, 10011, 5988})
    public void multiplication_MultiplyOfZeroWithMultipleIntegersShouldReturnZero(int arg) {
        int actualResult = calculatorUnderTest.multiply(arg, 0);
        assertEquals(0, actualResult);
    }

}
