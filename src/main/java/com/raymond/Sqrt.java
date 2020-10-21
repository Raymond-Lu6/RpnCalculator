package com.raymond;

import java.util.Deque;
import java.util.Objects;

public class Sqrt implements RpnOperator {
    String label = "sqrt";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sqrt)) return false;
        Sqrt sqrt = (Sqrt) o;
        return label.equals(sqrt.label);
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

        String str1 = stack.peek();
        if(str1==null ) {
            System.out.println("operator " + label + " (position:" + calculator.getCurPos() + "): insufficient parameters");
            return false;
        } else {
            str1 = stack.pop();
        }

        preStack.push(label);
        preStack.push(str1);

        Double num1 = Double.valueOf(str1);
        Double resultNum = Math.sqrt(num1);

        String strResult = resultNum.toString();
        if(strResult.contains(".") && strResult.substring(strResult.indexOf(".")).equalsIgnoreCase(".0")) {
            strResult = strResult.substring(0, strResult.indexOf("."));
        }
        stack.push(strResult);
        return true;
    }


}
