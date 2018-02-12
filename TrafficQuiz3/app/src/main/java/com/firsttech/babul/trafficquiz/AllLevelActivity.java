package com.firsttech.babul.trafficquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AllLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_level);
    }

    public void levelOne(View view) {
        startActivity(new Intent(this, LevelOneActivity.class));
    }
    public void levelTwo(View view) {
        startActivity(new Intent(this, LevelTwoActivity.class));
    }
    public void levelThree(View view) {
        startActivity(new Intent(this, LevelThreeActivity.class));
    }
}