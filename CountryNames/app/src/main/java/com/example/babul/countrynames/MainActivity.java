package com.example.babul.countrynames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private int[] flag = {R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh};
    private String countryName[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        countryName = getResources().getStringArray(R.array.countryNames);

        CustomAdapter adapter = new CustomAdapter(this,flag,countryName);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CountryProfileActivity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
        });
    }
}
