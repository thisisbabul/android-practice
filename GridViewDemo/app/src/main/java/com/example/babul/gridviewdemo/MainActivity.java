package com.example.babul.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private String[] countryNames;
    private int[] flags = {R.drawable.afghanistan, R.drawable.albania, R.drawable.bangladesh,
            R.drawable.barbados, R.drawable.belarus, R.drawable.belgium, R.drawable.belize,
            R.drawable.benin, R.drawable.bhutan, R.drawable.bolivia, R.drawable.botswana,
            R.drawable.brazil, R.drawable.brunei, R.drawable.bulgaria, R.drawable.burkinafaso,
            R.drawable.burma, R.drawable.burundi, R.drawable.india, R.drawable.pakistan
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewId);

        countryNames = getResources().getStringArray(R.array.countryNames);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), countryNames[position],Toast.LENGTH_SHORT).show();

            }
        });


    }
}
