package com.example.babul.countryprofiledemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bangladesh, india, pakistan;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladesh = findViewById(R.id.bangladeshButtonId);
        india = findViewById(R.id.indiaButtonId);
        pakistan = findViewById(R.id.pakistanButtonId);

        bangladesh.setOnClickListener(this);
        india.setOnClickListener(this);
        pakistan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bangladeshButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name","bangladesh");
            startActivity(intent);
        }
        if (v.getId()==R.id.indiaButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name","india");
            startActivity(intent);
        }
        if (v.getId()==R.id.pakistanButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name","pakistan");
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Title");
        alertBuilder.setMessage("Do you want to exit");
        alertBuilder.setCancelable(false);
        alertBuilder.setIcon(R.drawable.info);
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }
}
