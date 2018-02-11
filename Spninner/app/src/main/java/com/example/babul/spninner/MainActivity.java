package com.example.babul.spninner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView;
    private Button button;
    private String[] countryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerId);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        countryNames = getResources().getStringArray(R.array.countryNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_activity, R.id.textViewSpinnerId,countryNames);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                textView.setText(value);
            }
        });
    }
}
