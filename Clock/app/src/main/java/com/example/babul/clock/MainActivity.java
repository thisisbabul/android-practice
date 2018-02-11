package com.example.babul.clock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextClock textClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = findViewById(R.id.textclockId);
        analogClock = findViewById(R.id.analogclockId);

        textClock.setOnClickListener(this);
        analogClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (textClock.getId()==R.id.textclockId){
            Toast.makeText(getApplicationContext(),"Text Clock",Toast.LENGTH_SHORT).show();
        }
        if (analogClock.getId()==R.id.analogclockId){
            Toast.makeText(getApplicationContext(),"Analog Clock",Toast.LENGTH_SHORT).show();
        }
    }
}
