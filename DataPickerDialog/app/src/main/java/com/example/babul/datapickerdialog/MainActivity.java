package com.example.babul.datapickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private DatePickerDialog datePickerDialog;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.textViewId);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DatePicker datePicker = new DatePicker(this);

        int currentYear = datePicker.getYear();
        int currentMonth = (datePicker.getMonth()+1);
        int currentDate = datePicker.getDayOfMonth();
        final StringBuilder sb = new StringBuilder();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                sb.append(dayOfMonth+"/"+(month+1)+"/"+year);
                textView.setText(sb.toString());
            }
        },currentYear, currentMonth, currentDate);
        datePickerDialog.show();
    }
}
