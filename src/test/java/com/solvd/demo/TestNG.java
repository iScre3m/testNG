package com.solvd.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG {


    private final Logger LOGGER = LogManager.getLogger(TestNG.class);
    TestClass testClass;
    int[] numbers;
    int[] evenNumbers;
    int[] oddNumbers;

    @BeforeClass(alwaysRun = true)
    public void BeforeClassMethod() {
        LOGGER.info("Before class method");

        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        evenNumbers = new int[]{2, 4, 6, 8, 10};
        oddNumbers = new int[]{1, 3, 5, 7, 9};
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
    public void testDivision() {

        boolean divisible1 = testClass.isDivisible(10, 2);
        boolean divisible2 = testClass.isDivisible(7, 2);
        boolean divisible3 = testClass.isDivisible(9.15, 3.05);

        Assert.assertTrue(divisible1);
        Assert.assertTrue(divisible2);
        Assert.assertFalse(divisible3);
    }

    @Test(groups = {"text tests"})
    public void testHelloWorld() {
        String text = testClass.text();
        Assert.assertEquals(text, "testNG");
    }

    @BeforeSuite(alwaysRun = true)
    public void BeforeSuite() {
        LOGGER.info("Before suite");
    }

    @BeforeTest(alwaysRun = true)
    public void BeforeTest() {
        LOGGER.info("Before test");
        testClass = new TestClass();
    }

}
