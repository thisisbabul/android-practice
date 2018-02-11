package com.example.babul.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int[] flags = {R.drawable.bangladesh0,R.drawable.bangladesh1,R.drawable.bangladesh2,R.drawable.bangladesh3,R.drawable.bangladesh4};

    private GridView gridView;
    private String countryNames[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridviewId);

        countryNames = getResources().getStringArray(R.array.countryNames);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];

                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
