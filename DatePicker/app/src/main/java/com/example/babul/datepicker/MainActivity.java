package com.example.babul.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        datePicker = findViewById(R.id.datapickerId);

        textView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(currentDate());
            }
        });
    }

    String currentDate(){
        StringBuilder sb = new StringBuilder();
        sb.append("Current Data: ");
        sb.append(datePicker.getDayOfMonth()+"/");
        sb.append(datePicker.getMonth()+"/");
        sb.append(datePicker.getYear());

        return sb.toString();
    }
}
