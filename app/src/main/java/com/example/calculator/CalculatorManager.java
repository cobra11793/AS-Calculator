package com.example.calculator;

import java.util.ArrayList;

public class CalculatorManager {
    private static final String INPUT_EQUATION_CALCULATION = "Enter Calculation...";
    private String inputEquation;
    private ArrayList<String> operands;
    private double finalResult;

    public CalculatorManager() {
        inputEquation = "";
        operands = new ArrayList<String>();
        finalResult = 0;
    }

    public void addToEquation(String equationAddOn) {
        if (inputEquation.equals(INPUT_EQUATION_CALCULATION)) {
            inputEquation = "";
        }
        boolean isOperatorAppearsTwice = false;
        String previous = "";
        if (inputEquation.length() > 1) {
            previous = inputEquation.substring(inputEquation.length() - 1);
        }
        boolean isCheckOperations = equationAddOn.equals(" + ") || equationAddOn.equals(" - ") || equationAddOn.equals(" % ") || equationAddOn.equals(" × ") || equationAddOn.equals(" ÷ ") || equationAddOn.equals(".");
        if ((previous.equals(" ") || previous.equals(".")) && isCheckOperations) {
            isOperatorAppearsTwice = true;
        }
        if (inputEquation.equals("") && isCheckOperations) {
            isOperatorAppearsTwice = true;
        }
        if (!isOperatorAppearsTwice) {
            inputEquation = inputEquation + equationAddOn;
        }


    }

    public void deleteToEquation() {
        if (inputEquation.isEmpty()) {
            inputEquation = INPUT_EQUATION_CALCULATION;
        }
        if (inputEquation.equals(INPUT_EQUATION_CALCULATION)) {
            return;
        }
        if (inputEquation.length() > 1) {
            Character lastChar = inputEquation.charAt(inputEquation.length() - 1);
            String newEquation;
            if (lastChar.equals(' ')) {
                newEquation = inputEquation.substring(0, inputEquation.length() - 3);
            } else {
                newEquation = inputEquation.substring(0, inputEquation.length() - 1);
            }
            inputEquation = newEquation;
        } else if (inputEquation.length() <= 1) {
            inputEquation = INPUT_EQUATION_CALCULATION;
        }
    }

    public void clearEquation() {
        inputEquation = INPUT_EQUATION_CALCULATION;
    }

    public void calculate() {
        if (inputEquation.equals(INPUT_EQUATION_CALCULATION)) {
            return;
        }
        operands.clear();
        String duplicate = inputEquation;
        duplicate = duplicate + " ";
        int len = duplicate.length();
        String value = "";
        Character ch;
        for (int i = 0; i < len; i++) {
            ch = duplicate.charAt(i);
            if (ch.equals(' ')) {
                value = value.trim();
                operands.add(value);
                value = "";
            }
            value = value + ch;
        }
        getAnswer("%");
        getAnswer("÷");
        getAnswer("×");
        getAnswer("+");
        getAnswer("-");

        if (operands.isEmpty() == false && operands.get(0).isEmpty() == false) {
            finalResult = Double.parseDouble(operands.get(0));
            inputEquation = finalResult + "";
        }
    }

    private void getAnswer(String operator) {
        int length = operands.size();
        for (int j = 0; j < length; j++) {
            int size = operands.size();
            for (int i = 0; i < size; i++) {
                if (operands.get(i).equals(operator)) {
                    if (operands.get(i).equals("÷")) {
                        //Division operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) / Double.parseDouble(operands.get(i + 1));
                    } else if (operands.get(i).equals("%")) {
                        //Multiplication operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) * .01;
                    } else if (operands.get(i).equals("×")) {
                        //Multiplication operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) * Double.parseDouble(operands.get(i + 1));
                    } else if (operands.get(i).equals("+")) {
                        //Addition operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) + Double.parseDouble(operands.get(i + 1));
                    } else if (operands.get(i).equals("-")) {
                        //Subtraction operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) - Double.parseDouble(operands.get(i + 1));
                    }
                    operands.remove(i - 1);
                    operands.add(i - 1, String.valueOf(finalResult));
                    operands.remove(i + 1);
                    operands.remove(i);
                    break;
                }
            }
        }
    }
    public String getInputEquation() {
        return inputEquation;
    }
}
