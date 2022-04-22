package com.example.calculator;

public class CalculatorManager {
    private String inputEquation;

    public CalculatorManager() {
        inputEquation = "";
    }

    public void addToEquation(String equationAddOn) {
        inputEquation = inputEquation + equationAddOn;
    }

    public void deleteToEquation() {

    }

    public void clearEquation(){
        inputEquation = "";
    }

    public void calculate() {
        String answer = "0";

    }

    public String getInputEquation() {
        return inputEquation;
    }
}
