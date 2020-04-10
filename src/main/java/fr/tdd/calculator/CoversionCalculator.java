package fr.tdd.calculator;

public class CoversionCalculator {

    public Double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public Double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public Double litresToGallon(double litres) {
        return litres / 3.78541;
    }

    public Double radiusToAreaOfCircle(double radius) {
        return radius * radius * Math.PI;
    }
}
