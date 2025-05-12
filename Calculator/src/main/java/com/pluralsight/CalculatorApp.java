package com.pluralsight;

public class CalculatorApp {

    //private constructor so we can't even make an instance
    private CalculatorApp(){

    }

    //static methods
    static int add(int number1, int number2){
        return number1 + number2;
    }

    static int subtract(int number1, int number2){
        return number1 - number2;
    }

    static int divide(int number1, int number2){
        return number1 / number2;
    }

    static int multiply(int number1, int number2){
        return number1 * number2;
    }

}
