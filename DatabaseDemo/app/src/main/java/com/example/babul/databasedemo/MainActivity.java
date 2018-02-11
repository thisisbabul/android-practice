package com.example.babul.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText nameEditText, ageEditTex, genderEditText;
    private Button saveButton, loadDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditTex = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);

        saveButton = findViewById(R.id.saveButtonId);
        loadDataButton = findViewById(R.id.loadDataButtonId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String age = ageEditTex.getText().toString();
                String gender = genderEditText.getText().toString();

                long rowId = databaseHelper.insertInfo(name, age, gender);

                if (rowId==-1){
                    Toast.makeText(getApplicationContext(), "Data is not inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Data is inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseHelper.displayAll();
                if (cursor.getCount()==0){
                    showData("Error","No data found");
                }else {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        stringBuffer.append("Id "+cursor.getString(0)+"\n");
                        stringBuffer.append("Name "+cursor.getString(1)+"\n");
                        stringBuffer.append("Age "+cursor.getString(2)+"\n");
                        stringBuffer.append("Gender "+cursor.getString(3)+"\n\n\n");
                    }
                    showData("Result",stringBuffer.toString());
                }
            }
        });

    }

    private void showData(String result, String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(result);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();
    }
}
