package com.example.babul.gamescore;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView scoreTextView;
    private Button increaseButton, decreaseButton;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextViewId);
        increaseButton = findViewById(R.id.increaseButtonId);
        decreaseButton = findViewById(R.id.decreaseButtonId);

        if (loadScore()!=0){
            scoreTextView.setText("Score "+loadScore());
            score = loadScore();
        }

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);


    }

    private int loadScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("gamescore", Context.MODE_PRIVATE);
        int lastscore = sharedPreferences.getInt("lastscoreKey",0);
        return lastscore;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.increaseButtonId){
            score+=10;
            scoreTextView.setText("Score "+score);
            saveScore(score);
        }else if (v.getId()==R.id.decreaseButtonId){
            score-=10;
            scoreTextView.setText("Score "+score);
            saveScore(score);
        }
    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gamescore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastscoreKey", score);
        editor.commit();
    }


}
