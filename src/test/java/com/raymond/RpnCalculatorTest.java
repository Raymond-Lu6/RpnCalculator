package com.raymond;

public class RpnCalculatorTest {

    RpnCalculator calculator = new RpnCalculator();

    public static void main(String[] args) {


        RpnCalculatorTest cal = new RpnCalculatorTest();
        cal.testCase1();
        cal.testCase2();
    }

    private void testCase1() {
        // case 1
        String strInput = "2 4 +";
        String expectedResult = "6";

        calculator.init();
        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();
        String printResult = expectedResult.equalsIgnoreCase(actualResult)? "pass" : "fail";

        System.out.println("case 1: " + printResult);
    }

    private void testCase2() {
        // case 1
        String strInput = "2 4 + 4 +";
        String expectedResult = "10";

        calculator.init();
        calculator.setInputLine(strInput);
        calculator.processInputLine();
        calculator.executeOperations();
        String actualResult = calculator.getResult();
        String printResult = expectedResult.equalsIgnoreCase(actualResult)? "pass" : "fail";

        System.out.println("case 2: " + printResult);
    }

}
