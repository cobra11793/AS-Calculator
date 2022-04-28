package com.example.calculator;

import java.util.ArrayList;

public class CalculatorManager {
    private String inputEquation;
    ArrayList<String> operands = new ArrayList<String>();
    double finalResult = 0;

    public CalculatorManager() {
        inputEquation = "";
    }

    public void addToEquation(String equationAddOn) {
        boolean isOperatorAppearsTwice = false;
        String previous = "";
        if (inputEquation.length()>1){
            previous = inputEquation.substring(inputEquation.length() - 1);
        }
        if((previous.equals(" ") || previous.equals("."))&& (equationAddOn.equals(" + ") || equationAddOn.equals(" - ") || equationAddOn.equals(" % ") || equationAddOn.equals(" × ") || equationAddOn.equals(" ÷ ") || equationAddOn.equals(".") )){
            isOperatorAppearsTwice = true;
        }
        if(inputEquation.equals("") && (equationAddOn.equals(" + ") || equationAddOn.equals(" - ") || equationAddOn.equals(" % ") || equationAddOn.equals(" × ") || equationAddOn.equals(" ÷ ") || equationAddOn.equals(".") )){
            isOperatorAppearsTwice = true;
        }
        if (!isOperatorAppearsTwice) {
            inputEquation = inputEquation + equationAddOn;
        }


    }

    public void deleteToEquation() {
       if(inputEquation.length()>1) {
           Character lastChar = inputEquation.charAt(inputEquation.length()-1);
           String newEquation;
           if(lastChar.equals(' ')) {
               newEquation = inputEquation.substring(0, inputEquation.length() - 3);
           }
           else{
               newEquation = inputEquation.substring(0, inputEquation.length() - 1);
           }
           inputEquation = newEquation;
       }
       else if(inputEquation.length()<=1){
           inputEquation = "";
       }
    }

    public void clearEquation(){
        inputEquation = "";
    }

    public void calculate() {
        operands.clear();
        String duplicate = inputEquation;
        duplicate = duplicate + " ";
        int len = duplicate.length();
        String value ="";
        Character ch;
        for (int i = 0 ; i<len; i++){
            ch = duplicate.charAt(i);
            if (ch.equals(' ')){
                value = value.trim();
                operands.add(value);
                value ="";
            }
            value = value+ch;
        }
        getAns("%");
        getAns("÷");
        getAns("×");
        getAns("+");
        getAns("-");

        finalResult = Double.parseDouble(operands.get(0));
    }

    public void getAns(String operator) {
        int length = operands.size();
        for (int j = 0; j < length; j++) {
            int size = operands.size();
            for (int i = 0; i < size; i++) {
                if (operands.get(i).equals(operator)) {
                    if (operands.get(i).equals("÷")) {
                        //Division operation
                        finalResult = Double.parseDouble(operands.get(i - 1)) / Double.parseDouble(operands.get(i + 1));
                    }
                    else if (operands.get(i).equals("%")) {
                        finalResult = Double.parseDouble(operands.get(i - 1)) * .01;
                        //Multiplication operation
                    }
                    else if (operands.get(i).equals("×")) {
                        finalResult = Double.parseDouble(operands.get(i - 1)) * Double.parseDouble(operands.get(i + 1));
                        //Multiplication operation
                    }
                    else if (operands.get(i).equals("+")) {
                        finalResult = Double.parseDouble(operands.get(i - 1)) + Double.parseDouble(operands.get(i + 1));
                        //Addition operation
                    }
                    else if (operands.get(i).equals("-")) {
                        finalResult = Double.parseDouble(operands.get(i - 1)) - Double.parseDouble(operands.get(i + 1));
                        //Subtraction operation
                    }
                    operands.remove(i - 1);
                    operands.add(i-1,String.valueOf(finalResult));
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
