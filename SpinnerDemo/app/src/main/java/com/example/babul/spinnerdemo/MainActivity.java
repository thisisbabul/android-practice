package com.example.babul.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private int[] flags = {R.drawable.afghanistan, R.drawable.albania, R.drawable.bangladesh, R.drawable.barbados,
        R.drawable.belarus, R.drawable.belgium, R.drawable.belize, R.drawable.benin, R.drawable.bhutan, R.drawable.bolivia,
            R.drawable.botswana, R.drawable.brazil, R.drawable.brunei, R.drawable.bulgaria, R.drawable.burkinafaso,
            R.drawable.burma, R.drawable.burundi, R.drawable.india, R.drawable.pakistan
    };

    private String[] countryNames;
    private String[] populations;
    private boolean isSeletedItem = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerId);
        countryNames = getResources().getStringArray(R.array.countryNames);
        populations = getResources().getStringArray(R.array.populations);

        CustomAdapter adapter = new CustomAdapter(this, flags, countryNames, populations);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSeletedItem){
                    isSeletedItem = false;
                }else {
                    Toast.makeText(getApplicationContext(), countryNames[position]+" is selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
