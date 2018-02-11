package com.example.babul.sharewithdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText name, message;
    private Button sendButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name = findViewById(R.id.nameEdittextId);
        message = findViewById(R.id.messageEdittextId);

        sendButton = findViewById(R.id.sentButtonId);
        clearButton = findViewById(R.id.clearButtonId);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String sub = name.getText().toString();
        String mess = message.getText().toString();

        if (v.getId()==R.id.sentButtonId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/email");
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"babul.cu.cse35@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,mess);
            startActivity(Intent.createChooser(intent, "Feedback with"));
        }else if (v.getId()==R.id.clearButtonId){
            name.setText("");
            message.setText("");
        }
    }
}
