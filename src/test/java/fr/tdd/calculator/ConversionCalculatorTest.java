package fr.tdd.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

public class ConversionCalculatorTest {

    private CoversionCalculator calculatorUnderTest = new CoversionCalculator();

    @Test
    @DisplayName("we have a temperature in celsius equal to 0°C, when we convert it to fahrenheit, we should get 32°F")
    public void celsiusToFahrenheit_returnsAFahrenheitTempurature_whenCelsiusIsZero() {
        Double actualFahrenheit = calculatorUnderTest.celsiusToFahrenheit(0.0);
        assertThat(actualFahrenheit).isCloseTo(32.0, withinPercentage(0.01));
    }

    @Test
    @DisplayName("we have a temperature in celsius equal to 32°C, when we convert it to fahrenheit, we should get 89.6°F")
    public void celsiusToFahrenheit_returnsAFahrenheitTempurature_whenCelsiusIsThirtyTwo() {
        Double actualFahrenheit = calculatorUnderTest.celsiusToFahrenheit(32.0);
        assertThat(actualFahrenheit).isCloseTo(89.6, withinPercentage(0.01));
    }

}
