package com.example.babul.countrynames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountryProfileActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_profile);

        textView = findViewById(R.id.textviewId);
        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String value = bundle.getString("name");

            if (value.equals("Bangladesh")){
                textView.setText("Inustry is the mother of good luck, Honesty is the best policy");
            }
        }

    }
}
