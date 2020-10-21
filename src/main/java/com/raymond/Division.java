package com.raymond;

import java.util.Deque;
import java.util.Objects;

public class Division implements RpnOperator {
    String label = "/";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Division)) return false;
        Division division = (Division) o;
        return label.equals(division.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean isOperator(String operator) {
        return label.equalsIgnoreCase(operator);
    }

    @Override
    public boolean calculate(RpnCalculator calculator) {
        Deque<String> stack = calculator.getRpnStack();
        Deque<String> preStack = calculator.getPreOpsStack();

        String str2 = stack.peek();
        if(str2 == null ) {
            System.out.println("operator " + label + " (position:" + calculator.getCurPos() + "): insufficient parameters");
            return false;
        } else {
            str2 = stack.pop();
        }

        String str1 = stack.peek();
        if(str1==null ) {
            System.out.println("operator " + label + " (position:" + calculator.getCurPos() + "): insufficient parameters");
            stack.push(str2);
            return false;
        } else {
            str1 = stack.pop();
        }

        preStack.push(label);
        preStack.push(str2);
        preStack.push(str1);

        Double num1 = Double.valueOf(str1.trim());
        Double num2 = Double.valueOf(str2.trim());

        Double resultNum = num1 / num2;
        String result = String.valueOf(resultNum);
        result = formatResult(result);
        stack.push(result);
        return true;
    }
}
