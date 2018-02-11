package com.example.babul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        final String[] mobileArray = getResources().getStringArray(R.array.moble_name);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_listview, R.id.textviewId,mobileArray);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = mobileArray[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
