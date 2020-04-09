package fr.tdd.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

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
    public void addTwoPositiveNumbers() {
        assertEquals(42, calculatorUnderTest.add(40, 2));
    }

    @Test
    public void multiplyTwoPosistiveNumbers() {
        assertEquals(35, calculatorUnderTest.multiply(5, 7));
    }

}
