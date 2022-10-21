package com.solvd.demo;

public class TestClass {

    public String text() {
        return "testNG";
    }

    public int countEvenNumbers(int[] numbers) {
        int counter = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isDivisible(int dividend, int divisor) {
        return dividend % divisor == 0;
    }

    public boolean isDivisible(double dividend, double divisor) {
        return dividend % divisor == 0;
    }
}
