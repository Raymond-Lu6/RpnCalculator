package com.raymond;

import java.util.Deque;
import java.util.Objects;

public class Clear implements RpnOperator{
    String label = "clear";

    @Override
    public boolean isOperator(String operator) {
        return label.equalsIgnoreCase(operator);
    }

    @Override
    public boolean calculate(RpnCalculator calculator) {
        Deque<String> stack = calculator.getRpnStack();
        stack.clear();
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
