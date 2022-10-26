package com.solvd.demo;

import mock.TestClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG {


    private final Logger LOGGER = LogManager.getLogger(TestNG.class);
    private TestClass testClass;
    private int[] numbers;
    private int[] evenNumbers;
    private int[] oddNumbers;

    private int number1;
    private int number2;

    @BeforeMethod
    public void assignNumbers() {
        number1 = 5;
        number2 = 10;
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Before class");

        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        evenNumbers = new int[]{2, 4, 6, 8, 10};
        oddNumbers = new int[]{1, 3, 5, 7, 9};
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("After class");
    }

    @Test(groups = {"calculate"})
    public void testEvenNumbers() {

        int resultNumbers = testClass.countEvenNumbers(numbers);
        int resultEvenNumbers = testClass.countEvenNumbers(evenNumbers);
        int resultOddNumbers = testClass.countEvenNumbers(oddNumbers);

        // assertEquals(array, resultado de cuantos numeros son pares)
        Assert.assertEquals(resultNumbers, 5);
        Assert.assertEquals(resultEvenNumbers, 5);
        Assert.assertEquals(resultOddNumbers, 0);
    }

    @Test(groups = {"calculate"})
    public void testNumbers() {
        Assert.assertTrue(number1 + 5 == number2);
    }

    @Test(groups = {"calculate"})
    public void testDivision() {

        boolean divisible1 = testClass.isDivisible(10, 2);
        boolean divisible2 = testClass.isDivisible(7, 2);
        boolean divisible3 = testClass.isDivisible(9.15, 3.05);
        String message = "Expected the first number to be divided by the second number";

        Assert.assertTrue(divisible1, message);
        Assert.assertTrue(divisible2, message);
        Assert.assertFalse(divisible3, message);
    }

    @Test(groups = {"text tests"})
    public void testText() {
        String text = testClass.text();
        Assert.assertEquals(text, "testNG", "Expected the text to be equals to testNG");
    }

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Before suite");
    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.info("Before test");
        testClass = new TestClass();
    }

    @AfterTest
    public void afterTest() {
        LOGGER.info("After test");
    }

}
