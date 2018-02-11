package com.example.babul.countryprofiledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageviewId);
        textView = findViewById(R.id.textviewId);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String value = bundle.getString("name");

            if (value.equals("bangladesh")){
                imageView.setImageResource(R.drawable.bangladesh);
                textView.setText(R.string.bangladesh);
            }

            if (value.equals("india")){
                imageView.setImageResource(R.drawable.india);
                textView.setText(R.string.india);
            }

            if (value.equals("pakistan")){
                imageView.setImageResource(R.drawable.pakistan);
                textView.setText(R.string.pakistan);
            }
        }
    }
}
