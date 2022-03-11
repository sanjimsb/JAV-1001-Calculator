package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView expression;
    TextView results;
    String mainExpression = "";
    String operator = "";
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setResultsView();
    }

    public void setResultsView(){
        expression = (TextView)findViewById(R.id.expressionTextView);
        results =  (TextView)findViewById(R.id.resultsTextView);
    }

    public void updateExpression(String getExpressionString) {
        if (validation(getExpressionString)) {
            mainExpression = mainExpression + getExpressionString;
            expression.setText(mainExpression);
        }
    }

    public Boolean validation(String getExpressionString) {
        char getLastChar;
        if ( mainExpression == "" ) {
            switch (getExpressionString) {
                case "+":
                case "*":
                case "!":
                case "/":
                case "%":
                    return false;
            }
        } else {
            StringBuffer bufferValue = new StringBuffer(mainExpression);
            System.out.println(bufferValue.length());
            if (mainExpression.length() >= 1) {
                getLastChar = bufferValue.charAt(bufferValue.length() - 1);
                switch (getExpressionString) {
                    case "+":
                    case "*":
                    case "!":
                    case "/":
                    case "%":
                    case "-":
                        if (bufferValue.indexOf("+") != -1 ||
                                bufferValue.indexOf("*") != -1 ||
                                bufferValue.indexOf("!") != -1 ||
                                bufferValue.indexOf("/") != -1 ||
                                bufferValue.indexOf("%") != -1 ||
                                bufferValue.indexOf("-") != -1
                        ) {
                            System.out.println(getLastChar);
                            System.out.println(getExpressionString);
                            return false;
                        } else {
                            operator = getExpressionString;
                        }
                }

            }
        }
        return true;
    }

    public void clearAll(View view) {
        mainExpression = "";
        expression.setText("");
        results.setText("0.0");
    }

    public void onResultsClick(View view) {
        if(!operator.isEmpty()) {
            if(operator.equals("!")) {
                System.out.println(mainExpression);
                String[] splitExpression = mainExpression.split(operator);
                if(splitExpression.length > 1) {
                    getFactorial(Integer.parseInt(splitExpression[0]),Integer.parseInt(splitExpression[1]));
                } else {
                    getFactorial(Integer.parseInt(splitExpression[0]),1);
                }

            } else {
                String regexValue = operator.equals("+") ? "\\+" :
                        (operator.equals("*") ? "\\*" : operator);

                String[] splitExpression = mainExpression.split(regexValue);
                if (splitExpression.length > 1) {
                    operation(Double.parseDouble(splitExpression[0]), Double.parseDouble(splitExpression[1]), operator);
                } else {
                    if(operator.equals("%")) {
                        operation(Double.parseDouble(splitExpression[0]), Double.parseDouble("1"), operator);
                    }
                }
            }
        } else {
            results.setText(mainExpression);
        }
    }

    public void operation(double firstNum, double secondNum, String operator) {
        DecimalFormat df = new DecimalFormat("###.##");
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "%":
                result = (firstNum / 100) * secondNum;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        System.out.println(result);
        results.setText(df.format(result));
    }

    public void getFactorial(Integer firstNum, Integer secondNum) {
        Integer setFactorial = 1;
        for(Integer i=1; i<=firstNum; i++){
            setFactorial = setFactorial * i;
        }
        results.setText(Integer.toString(setFactorial * secondNum));
    }

    public void onDeleteClick(View view) {
        if(!mainExpression.isEmpty()) {
            StringBuffer bufferValue = new StringBuffer(mainExpression);
            bufferValue.deleteCharAt(bufferValue.length() - 1);
            mainExpression = bufferValue.toString();
            expression.setText(mainExpression);
            results.setText("0.0");
        }
    }

    public void setPercentage(View view) {
        updateExpression("%");
    }

    public void setDivide(View view) {
        updateExpression("/");
    }

    public void onFactorialClick(View view) {
//        updateExpression("!");
    }

    public void onSevenClick(View view) {
        updateExpression("7");
    }

    public void onEightClick(View view) {
        updateExpression("8");
    }

    public void onNineClick(View view) {
        updateExpression("9");
    }

    public void onFourClick(View view) {
        updateExpression("4");
    }

    public void onFiveClick(View view) {
        updateExpression("5");
    }

    public void onSixClick(View view) {
        updateExpression("6");
    }

    public void onOneClick(View view) {
        updateExpression("1");
    }

    public void onTwoClick(View view) {
        updateExpression("2");
    }

    public void onThreeClick(View view) {
        updateExpression("3");
    }

    public void onMultiplyClick(View view) {
        updateExpression("*");
    }

    public void onMinusClick(View view) {
        updateExpression("-");
    }

    public void onZeroClick(View view) {
        updateExpression("0");
    }

    public void onDecimalClick(View view) {
        updateExpression(".");
    }

    public void onAdditionClick(View view) {
        updateExpression("+");
    }


}