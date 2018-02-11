package com.example.babul.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox milkCheckbox, sugarCheckbox, waterCheckbox;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milkCheckbox = findViewById(R.id.milkCheckboxId);
        sugarCheckbox = findViewById(R.id.sugarCheckboxId);
        waterCheckbox = findViewById(R.id.waterCheckboxId);

        button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.textviewId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                if (milkCheckbox.isChecked()){
                    sb.append(milkCheckbox.getText().toString()+" is ordered\n");
                }
                if (sugarCheckbox.isChecked()){
                    sb.append(sugarCheckbox.getText().toString()+" is ordered\n");
                }
                if (waterCheckbox.isChecked()){
                    sb.append(waterCheckbox.getText().toString()+" is ordered\n");
                }

                textView.setText(sb.toString());
            }
        });
    }
}
