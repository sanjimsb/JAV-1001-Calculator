package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView expression;
    TextView results;
    String mainExpression = "";
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
        System.out.println(getExpressionString);
        mainExpression = mainExpression + getExpressionString;
        expression.setText(mainExpression);
    }

    public void clearAll(View view) {
        mainExpression = "";
    }

    public void setPercentage(View view) {
        updateExpression("%");
    }

    public void setDivide(View view) {
        updateExpression("/");
    }

    public void onFactorialClick(View view) {
        updateExpression("!");
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

    public void onDeleteClick(View view) {

    }

    public void onAdditionClick(View view) {
        updateExpression("+");
    }

    public void onResultsClick(View view) {

    }
}