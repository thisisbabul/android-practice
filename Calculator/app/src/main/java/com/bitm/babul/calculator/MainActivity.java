package com.bitm.babul.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1=(EditText)findViewById(R.id.etInput1);
        input2=(EditText)findViewById(R.id.etInput2);
        tvResult =(TextView)findViewById(R.id.tvOutput);

    }
    public void add(View view){
        String firstNum=input1.getText().toString();
        String secondNum=input2.getText().toString();
        if(!firstNum.equals("")&&!secondNum.equals("")) {
            double firstInput = Double.parseDouble(firstNum);
            double secondInput = Double.parseDouble(secondNum);
            double finalResult = firstInput + secondInput;
            tvResult.setText("Result= " + finalResult);
        }
        else {
            tvResult.setText("Please input both NUMBER");
        }

    }
    public void sub(View view){
        String firstNum=input1.getText().toString();
        String secondNum=input2.getText().toString();
        if(!firstNum.equals("")&&!secondNum.equals("")) {
            double firstInput = Double.parseDouble(firstNum);
            double secondInput = Double.parseDouble(secondNum);
            double finalResult = firstInput - secondInput;
            tvResult.setText("Result= " + finalResult);
        }
        else {
            tvResult.setText("Please input both NUMBER");
        }
    }
    public void mul(View view){
        String firstNum=input1.getText().toString();
        String secondNum=input2.getText().toString();
        if(!firstNum.equals(" ")&&!secondNum.equals("")) {
            double firstInput = Double.parseDouble(firstNum);
            double secondInput = Double.parseDouble(secondNum);
            double finalResult = firstInput * secondInput;
            tvResult.setText("Result= " + finalResult);
        }
        else {
            tvResult.setText("Please input both NUMBER");
        }
    }
    public void div(View view){
        String firstNum=input1.getText().toString();
        String secondNum=input2.getText().toString();
        if(!firstNum.equals("")&&!secondNum.equals("")) {
            double firstInput = Double.parseDouble(firstNum);
            double secondInput = Double.parseDouble(secondNum);
            double finalResult = firstInput / secondInput;
            tvResult.setText("Result= " + finalResult);
        }
        else {
            tvResult.setText("Please input both NUMBER");
        }
    }

}
