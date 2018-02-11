package com.example.babul.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button loginButton, logoutButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButtonId);
        logoutButton = findViewById(R.id.logoutButtonId);

        textView = findViewById(R.id.textViewId);

        loginButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginButtonId){
            Toast.makeText(getApplicationContext(),"Login button is clicked",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Logout button is clicked",Toast.LENGTH_LONG).show();
        }
    }
}
