package com.example.babul.calculatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView randomNumberTextView, scoreTextView;
    private ImageButton changeButton;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberTextView = findViewById(R.id.randomNumberId);
        changeButton = findViewById(R.id.changeButtonId);
        scoreTextView = findViewById(R.id.scoreTextViewId);
        gridView = findViewById(R.id.gridViewId);
        int number = generateRandomNumber();

        String names[] = {"one","two","three","four","five","six"};

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.activity_simple,R.id.editTextId,names);
        gridView.setAdapter(adapter);

        randomNumberTextView.setText(number+"");

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumberTextView.setText(generateRandomNumber()+"");
            }
        });


//        countryNames = getResources().getStringArray(R.array.countryNames);
//
//        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), countryNames[position],Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
    public int generateRandomNumber(){
        Random random = new Random();
        int num = random.nextInt(100);
        return num;
    }

}
