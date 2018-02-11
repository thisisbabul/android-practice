package com.example.babul.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText usernameEditText, passwordEditText;
    private Button saveButton, loadButton;
    private TextView detailsTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextUsernameId);
        passwordEditText = findViewById(R.id.editTextPassordId);
        saveButton = findViewById(R.id.buttonSaveId);
        loadButton = findViewById(R.id.buttonLoadId);
        detailsTextView  = findViewById(R.id.textviewId);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonSaveId){
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("") && password.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter username or passrord", Toast.LENGTH_SHORT).show();
            }else {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey", username);
                editor.putString("passwordKey", password);
                editor.commit();
                usernameEditText.setText("");
                passwordEditText.setText("");
                Toast.makeText(getApplicationContext(), "username or passrord has been saved", Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId()==R.id.buttonLoadId){
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey")){
                String username = sharedPreferences.getString("usernameKey", "Username not found");
                String password = sharedPreferences.getString("passwordKey", "Password not found");

                detailsTextView.setText(username+ "\n"+ password);
            }
        }
    }
}
