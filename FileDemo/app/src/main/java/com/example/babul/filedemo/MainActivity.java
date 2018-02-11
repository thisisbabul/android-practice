package com.example.babul.filedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText diaryEditTex;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diaryEditTex = findViewById(R.id.diaryEditTextId);
        saveButton = findViewById(R.id.saveButtonId);

        readFromFile();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = diaryEditTex.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput("diary.txt",Context.MODE_PRIVATE);
                    fileOutputStream.write(value.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "Data is saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void readFromFile(){
        try {
            FileInputStream fileInputStream = openFileInput("diary.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\n");
            }
            diaryEditTex.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
