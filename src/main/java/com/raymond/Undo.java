package com.raymond;

import java.util.Deque;
import java.util.Objects;

public class Undo implements RpnOperator {
    String label = "undo";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Undo)) return false;
        Undo undo = (Undo) o;
        return label.equals(undo.label);
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

        if(stack.peek() != null) {
            stack.pop();
        }

        String strNum = preStack.peek();
        while(strNum != null && !calculator.isOperator(strNum)) {
            strNum = preStack.pop();
            stack.push(strNum);
            strNum = preStack.peek();
        }
        if(calculator.isOperator(strNum)) {
            strNum = preStack.pop();
        }

        return true;
    }
}
