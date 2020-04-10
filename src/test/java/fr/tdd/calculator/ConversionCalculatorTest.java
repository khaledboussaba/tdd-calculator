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

@Tag("ConversionTests")
@DisplayName("successfully convert between different units")
public class ConversionCalculatorTest {

    private CoversionCalculator calculatorUnderTest = new CoversionCalculator();

    @Nested
    @Tag("TemperaturesTests")
    @DisplayName("successfully convert temperatures")
    class TemperatureTest {
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

        @Test
        @DisplayName("we have a temperature in fahrenheit equal to 0°F, when we convert it to celsius, we should get -17.77°C")
        public void fahrenheitToCelsius_returnsACelsiusTempurature_whenFahrenheitIsZero() {
            Double actualCelsius = calculatorUnderTest.fahrenheitToCelsius(0.0);
            assertThat(actualCelsius).isCloseTo(-17.77, withinPercentage(0.05));
        }

        @Test
        @DisplayName("we have a temperature in fahrenheit equal to 32°F, when we convert it to celsius, we should get 0.0°C")
        public void fahrenheitToCelsius_returnsACelsiusTempurature_whenFahrenheitIsThirtyTwo() {
            Double actualCelsius = calculatorUnderTest.fahrenheitToCelsius(32.0);
            assertThat(actualCelsius).isCloseTo(0.0, withinPercentage(0.01));
        }

    }

    @Test
    @DisplayName("Either a volume of 3.78541 liters, in gallons, wes should get 1 gallon.")
    public void litresToGallons_returnsOneGallon_whenConvertingTheEquivalentLitres() {
        Double actualGallon = calculatorUnderTest.litresToGallon(3.78541);
        assertThat(actualGallon).isCloseTo(1.0, withinPercentage(0.01));
    }

    @Test
    @DisplayName("The area of a disk of radius 1 must be equal PI")
    public void radiusToAreaOfCircle_returnsPI_whenWeHaveARadiusOfOne() {
        Double actualArea = calculatorUnderTest.radiusToAreaOfCircle(1.0);
        assertThat(actualArea).isCloseTo(Math.PI, withinPercentage(0.01));
    }

}
