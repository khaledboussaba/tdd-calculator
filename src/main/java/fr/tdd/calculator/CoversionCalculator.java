package fr.tdd.calculator;

public class CoversionCalculator {

    public Double celsiusToFahrenheit(double celsius) {
        Double fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }

    public Double fahrenheitToCelsius(double fahrenheit) {
        Double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}
