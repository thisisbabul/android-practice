package com.example.babul.alergdialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private AlertDialog.Builder alertdialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonId);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        alertdialogBuilder = new AlertDialog.Builder(this);
        alertdialogBuilder.setCancelable(false);
        alertdialogBuilder.setIcon(R.drawable.info);
        alertdialogBuilder.setTitle("Alert dialog");
        alertdialogBuilder.setMessage("Do you want delete");

        alertdialogBuilder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have click on neutral button",Toast.LENGTH_SHORT).show();
            }
        });
        alertdialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have click on negative button",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertdialogBuilder.create();
        alertDialog.show();
    }
}
