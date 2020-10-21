package com.raymond;

import java.util.Deque;
import java.util.Objects;

public class Addition implements RpnOperator {
    String label = "+";

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


        Integer num1 = Integer.valueOf(str1);
        Integer num2 = Integer.valueOf(str2);

        Integer resultNum = num1 + num2;
        stack.push(resultNum.toString());
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Addition)) return false;
        Addition addition = (Addition) o;
        return label.equals(addition.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

}
