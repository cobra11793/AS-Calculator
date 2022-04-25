package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView equationTextView;
    private Button clearButton;
    private Button parenthesesButton;
    private Button percentButton;
    private Button divideButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button multiplyButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button minusButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button plusButton;
    private Button zeroButton;
    private Button decimalButton;
    private Button backspaceButton;
    private Button equalsButton;

    private CalculatorManager calculatorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationTextView = findViewById(R.id.equationTextView);
        clearButton = findViewById(R.id.clearButton);
        parenthesesButton = findViewById(R.id.parenthesesButton);
        percentButton = findViewById(R.id.percentButton);
        divideButton = findViewById(R.id.divideButton);
        sevenButton = findViewById(R.id.sevenButton);
        eightButton = findViewById(R.id.eightButton);
        nineButton = findViewById(R.id.nineButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        fourButton = findViewById(R.id.fourButton);
        fiveButton = findViewById(R.id.fiveButton);
        sixButton = findViewById(R.id.sixButton);
        minusButton = findViewById(R.id.minusButton);
        oneButton = findViewById(R.id.oneButton);
        twoButton = findViewById(R.id.twoButton);
        threeButton = findViewById(R.id.threeButton);
        plusButton = findViewById(R.id.plusButton);
        zeroButton = findViewById(R.id.zeroButton);
        decimalButton = findViewById(R.id.decimalButton);
        backspaceButton = findViewById(R.id.backspaceButton);
        equalsButton = findViewById(R.id.equalsButton);

        calculatorManager = new CalculatorManager();

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("0");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("1");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("2");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("3");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("4");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("5");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("6");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("7");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("8");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation("9");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        parenthesesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(" % ");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(" ÷ ");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(" × ");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(" - ");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(" + ");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.addToEquation(".");
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.calculate();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.clearEquation();
                equationTextView.setText("Enter Calculation...");
            }
        });

        backspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorManager.deleteToEquation();
                equationTextView.setText(calculatorManager.getInputEquation());
            }
        });

    }
}