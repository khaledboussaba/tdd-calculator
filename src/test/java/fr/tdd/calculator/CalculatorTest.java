package fr.tdd.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(LoggingExtension.class)
public class CalculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    private Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

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
        logger.info("call before each test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void afterEachTest() {
        logger.info("call after each test");
        calculatorUnderTest = null;
    }

    @Test
    public void addition_addTwoPositiveIntegers() {
        assertThat(calculatorUnderTest.add(40, 2)).isEqualTo(42);
    }

    @Test
    public void addition_addTwoNegativeIntegers() {
        assertThat(calculatorUnderTest.add(-40, -2)).isEqualTo(-42);
    }

    @Test
    public void addition_addPositiveIntegerWithNegativeInteger() {
        assertThat(calculatorUnderTest.add(44, -2)).isEqualTo(42);
    }

    @Test
    public void addition_addTwoPositiveDoubles() {
        assertThat(calculatorUnderTest.add(40.0, 2.0)).isEqualTo(42.0);
    }

    @Test
    public void addition_addTwoNegativeDoubles() {
        assertThat(calculatorUnderTest.add(-40.0, -2.0)).isEqualTo(-42.0);
    }

    @Test
    public void addition_addPositiveDoubleWithNegativeDouble() {
        assertThat(calculatorUnderTest.add(44.0, -2.0)).isEqualTo(42.0);
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({"1,1,2", "4,5,9", "99,122,221"})
    public void addition_ShouldReturnTheSumOfMultipleIntegers(int arg1, int arg2, int expectResult) {
        int actualResult = calculatorUnderTest.add(arg1,arg2);
        assertThat(actualResult).isEqualTo(expectResult);
    }

    @ParameterizedTest(name = "{0} - {1} should equal to {2}")
    @CsvSource({"44,2,42", "-44,-2,-42", "40,-2,42"})
    public void subtraction_ShouldReturnTheSubtractionOfMultipleIntegers(int arg1, int arg2, int expectResult) {
        assertThat(calculatorUnderTest.sub(arg1, arg2)).isEqualTo(expectResult);
    }

    @ParameterizedTest(name = "{0} - {1} should equal to {2}")
    @CsvSource({"44.0,2.0,42.0", "-44.0,-2.0,-42.0", "40.0,-2.0,42.0"})
    public void subtraction_ShouldReturnTheSubtractionOfMultipleDoubles(double arg1, double arg2, double expectResult) {
        assertThat(calculatorUnderTest.sub(arg1, arg2)).isEqualTo(expectResult);
    }

    @Test
    public void multiplication_multiplyTwoPositiveNumbers() {
        assertThat(calculatorUnderTest.multiply(5, 7)).isEqualTo(35);
    }

    @ParameterizedTest(name = "{0} x 0 should equal to 0")
    @ValueSource(ints = {1, 2, 42, 10011, 5988})
    public void multiplication_MultiplyOfZeroWithMultipleIntegersShouldReturnZero(int arg) {
        int actualResult = calculatorUnderTest.multiply(arg, 0);
        assertThat(actualResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} x {1} should equal to {2}")
    @CsvSource({"21.0,2.0,42.0", "-21.0,-2.0,42.0", "21.0,-2.0,-42.0"})
    public void multiplication_ShouldReturnTheMultiplicationOfMultipleDoubles(double arg1, double arg2, double expectedResult) {
        assertThat(calculatorUnderTest.multiply(arg1, arg2)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{0} / {1} should equal to {2}")
    @CsvSource({"84,2,42", "-44,-2,22", "21,-2,-10"})
    public void divide_ShouldReturnTheDivisionOfMultipleIntegersWhenDenominatorNotEqualToZero(int arg1, int arg2, int expectedResult) {
        assertThat(calculatorUnderTest.divide(arg1, arg2)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{0} / {1} should equal to {2}")
    @CsvSource({"84.0,2.0,42.0", "-44.0,-2.0,22.0", "21.0,-2.0,-10.5"})
    public void divide_ShouldReturnTheDivisionOfMultipleDoublesWhenDenominatorNotEqualToZero(double arg1, double arg2, double expectedResult) {
        assertThat(calculatorUnderTest.divide(arg1, arg2)).isEqualTo(expectedResult);
    }

    @Test
    public void divide_ShouldThrowIllegalArgumentExceptionWhenDenomenatorEqualToZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorUnderTest.divide(5, 0));
        assertThat(exception.getMessage()).isEqualTo("Argument 'denominator' is '0'");
        assertThat(exception.getMessage()).contains("denominator");
    }

    @Test
    public void digitsSet_shouldReturnTheSetOfDigits_OfZero() {
        int number = 0;
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactlyInAnyOrder(0);
    }

    @Test
    public void digitsSet_shouldReturnTheSetOfDigits_OfPositiveInteger() {
        int number = 95897;
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
    }

    @Test
    public void digitsSet_shouldReturnTheSetOfDigits_OfNegativeInteger() {
        int number = -24908;
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactlyInAnyOrder(2, 0, 4, 8, 9);
    }

    @Test
    public void factorialOf5_ShouldReturnTheCorrectAnswer() {
        final int number = 5;
        final int factorialOfTwelve = calculatorUnderTest.factorial(number);
        assertThat(factorialOfTwelve).isEqualTo(5 * 4 * 3 * 2);
    }

    @Test
    public void digitsSet_shouldReturnTheSetOfDigits_OfFactorialOf5() {
        int number = calculatorUnderTest.factorial(5);
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactlyInAnyOrder(0, 1, 2);
    }

}
