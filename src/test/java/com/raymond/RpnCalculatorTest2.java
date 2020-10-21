package com.raymond;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RpnCalculatorTest2 {

    RpnCalculator calculator;

    @Before
    public void testInit()  {
        calculator = new RpnCalculator();
        calculator.init();
    }



    @Test
    public void testAddition() {

        // case 1
        String strInput = "5 2 +";
        String expectedResult = "7";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSqrt() {

        // case 2
        String strInput = "2 sqrt";
        String expectedResult = "1.4142135623";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSqrt2() {

        // case 3
        String strInput = "clear 9 sqrt";
        String expectedResult = "3";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubstraction() {

        // case 4
        String strInput = "5 2 -";
        String expectedResult = "3";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubstraction2() {

        // case 5
        String strInput = "3 3 -";
        String expectedResult = "0";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testClear() {

        // case 6
        String strInput = "clear";
        String expectedResult = "";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDivision() {

        String strInput = "5 3 /";
        String expectedResult = "1.6666666666";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSqrt3() {

        String strInput = "2 sqrt";
        String expectedResult = "1.4142135623";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase1() {

        String strInput = "1 2 3 * 5 + * * 6 5";
        String expectedResult = "11";

        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();

        Assert.assertEquals(expectedResult, actualResult);
    }

}
