package com.example.calculator;

public class CalculatorManager {
    private String inputEquation;

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
        String answer = "0";
        if (inputEquation == null){
            inputEquation = "";
        }

    }

    public String getInputEquation() {
        return inputEquation;
    }
}
