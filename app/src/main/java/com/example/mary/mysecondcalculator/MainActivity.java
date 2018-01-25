package com.example.mary.mysecondcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnZero, btnOne , btnTwo , btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,
    btnPlus, btnMinus, btnEquals, btnMultiply, btnDivide, btnCancel;

    TextView displayCalc;

    private ArrayList<Float> mathResults = new ArrayList<>();
    private float leftTotal;
    private float rightTotal;

    private int currentOperation = 0;
    private int nextOperation;

    private final static int PLUS = 1;
    private final static int MINUS = 2;
    private final static int MULTIPLY = 3;
    private final static int DIVIDE = 4;
    private final static int EQUALS= 0;

    private final static int CLEAR = 1;
    private final static int DONT_CLEAR = 0;

    private int clearDisplay = 0;
    String formatParam = "%.3f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        displayCalc = (TextView) findViewById(R.id.display);

        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnCancel = (Button) findViewById(R.id.btnCancel);



        displayCalc.setKeyListener(DigitsKeyListener.getInstance(true, true));
        registerListeners();
    }

    private void registerListeners(){

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearDisplay == CLEAR){
                    displayCalc.setText("");
                }
                clearDisplay = DONT_CLEAR;
                displayCalc.append("9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine(PLUS);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine(MINUS);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine(MULTIPLY);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine(DIVIDE);
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkEmptyDisplay = displayCalc.getText().toString();
                if (! checkEmptyDisplay.isEmpty()) {
                    calculatorEngine(EQUALS);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCalc.setText("0");
                leftTotal = 0;
                rightTotal = 0;
                mathResults.clear();
                currentOperation = 0;
                nextOperation = 0;
            }
        });
    }


    private void calculatorEngine(int operator){
       mathResults.add(Float.parseFloat(displayCalc.getText().toString()));
       if(operator != EQUALS){
           nextOperation = operator;
       } else {
           nextOperation = 0;
       }

       switch (currentOperation){
           case PLUS:
               leftTotal = mathResults.get(0);
               rightTotal = mathResults.get(1);
               mathResults.clear();
               mathResults.add(leftTotal + rightTotal);

               displayCalc.setText(String.format(formatParam, mathResults.get(0)));
               break;

           case MINUS:
               leftTotal = mathResults.get(0);
               rightTotal = mathResults.get(1);
               mathResults.clear();
               mathResults.add(leftTotal - rightTotal);

               displayCalc.setText(String.format(formatParam, mathResults.get(0)));
               break;

           case MULTIPLY:
               leftTotal = mathResults.get(0);
               rightTotal = mathResults.get(1);
               mathResults.clear();
               mathResults.add(leftTotal * rightTotal);

               displayCalc.setText(String.format(formatParam, mathResults.get(0)));
               break;

           case DIVIDE:
               leftTotal = mathResults.get(0);
               rightTotal = mathResults.get(1);
               mathResults.clear();
               mathResults.add(leftTotal / rightTotal);

               displayCalc.setText(String.format(formatParam, mathResults.get(0)));
               break;
       }
       clearDisplay = CLEAR;
       currentOperation = nextOperation;
       if(operator == EQUALS){
           leftTotal = 0;
           rightTotal = 0;
           mathResults.clear();
       }
    }
}
