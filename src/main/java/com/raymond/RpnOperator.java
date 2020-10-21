package com.raymond;

import java.util.Deque;

public interface RpnOperator {

    public boolean isOperator(String operator);

    public boolean calculate(RpnCalculator calculator);

    public default String formatResult(String strResult) {
        if(strResult.contains(".") && strResult.substring(strResult.indexOf(".")).equalsIgnoreCase(".0")) {
            strResult = strResult.substring(0, strResult.indexOf("."));
        }
        return strResult;
    }
}
