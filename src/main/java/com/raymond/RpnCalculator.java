package com.raymond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RpnCalculator {
    private Set<RpnOperator> operators = new HashSet<>();
    private String inputLine;
    private String[] inputNums;
    private int curPos = 0;
    private Deque<String> rpnStack = new LinkedList<>();
    private Deque<String> preOpsStack = new LinkedList<>();

    public int getCurPos() {
        return curPos;
    }

    public Deque<String> getRpnStack() {
        return rpnStack;
    }

    public Deque<String> getPreOpsStack() {
        return preOpsStack;
    }

    public static void main(String[] args) {

        RpnCalculator calculator = new RpnCalculator();
        calculator.init();

        boolean isExit = false;
        while(!isExit) {
            if (calculator.processInputLine()) {
                calculator.executeOperations();
                String strResult = calculator.getResult();
                System.out.println("stack:" + strResult);
            } else {
                isExit = true;
            }
        }

    }

    public void init(){
        operators.clear();
        operators.add(new Addition());
        operators.add(new Subtraction());
        operators.add(new Multiplication());
        operators.add(new Division());
        operators.add(new Sqrt());
        operators.add(new Clear());
        operators.add(new Undo());

        inputLine = null;
        curPos = 0;
        rpnStack.clear();
        preOpsStack.clear();
    }

    public void setInputLine(String strLine) {
        inputLine = strLine;
    }

    public boolean processInputLine() {

        if(inputLine == null || inputLine.isEmpty()) {
            // read input line
            System.out.println("Please enter the calculation string:");
            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            try {
                inputLine = scanner.readLine();
            } catch (IOException ex) {
                System.out.println("Error: read line for input" + ex.getMessage());
            }
            if (inputLine.equalsIgnoreCase("exit")) {
                return false;
            }
        }

        inputNums = inputLine.split(" ");
        inputLine = null;
        return true;

    }

    public void executeOperations() {
        curPos = 0;

        for(int i = 0; i<inputNums.length; i++){
            String inputNum = inputNums[i];

            curPos ++;
            if(isOperator(inputNum)) {
                boolean isOperationGood = calculateResult(inputNum);
                if(!isOperationGood) {
                    break;
                }
            } else {
                rpnStack.push(inputNum);
            }
            curPos += inputNum.length();
        }

    }

    public boolean isOperator(String inputStr) {
        for (RpnOperator op : operators
             ) {
            if (op.isOperator(inputStr)) {
                return true;
            }

        }
        return false;
    }

    public RpnOperator getOperator(String inputStr) {
        for (RpnOperator op : operators
        ) {
            if (op.isOperator(inputStr)) {
                return op;
            }

        }
        return null;
    }

    public boolean calculateResult(String operation) {

        RpnOperator op = getOperator(operation);
        return op.calculate(this);

    }

    public String getResult(){

        StringBuilder sbResult = new StringBuilder();

        Deque<String> resultStack = new LinkedList<>(rpnStack);
        Iterator<String> it = resultStack.iterator();
        while(resultStack.peekLast()!=null) {
            String str = resultStack.pollLast();
            if(str.contains(".") && str.length()>10) {
                // display 10 decimal places
                int dotIndex = str.indexOf(".");
                str = str.substring(0, 10+1+dotIndex);
            }
            sbResult.append(str+ " ");
        }

        String result = sbResult.toString().trim();

        return result;
    }
}
