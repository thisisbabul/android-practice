package com.firsttech.babul.trafficquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Vector;

public class LevelOneActivity extends AppCompatActivity {
    TextView aLoneQone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        aLoneQone= (TextView) findViewById(R.id.aLoneQone);
        aLoneQone.setEnabled(false);
    }

    public void selectLoneQone(View view){
        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rLoneQonePoshu:
                if(checked){
                    aLoneQone.setText("আপনি সঠিক উত্তর নির্বাচন করেছেন ।");
                    aLoneQone.setEnabled(true);
                }
                else {
                    aLoneQone.setEnabled(false);
                }
                break;

            case R.id.rLoneQonePothcari:
                if(checked){
                    aLoneQone.setText("আপনি ভুল উত্তর নির্বাচন করেছেন, সঠিক উত্তরটি হল (পশুবাহিত যান চলাচল নিষেধ)।");
                    aLoneQone.setEnabled(true);
                }
                else {
                    aLoneQone.setEnabled(false);
                }
                break;

            case R.id.rLoneQoneRicksha:
                if(checked){
                    aLoneQone.setText("আপনি ভুল উত্তর নির্বাচন করেছেন, সঠিক উত্তরটি হল (পশুবাহিত যান চলাচল নিষেধ)।");
                    aLoneQone.setEnabled(true);
                }
                else {
                    aLoneQone.setEnabled(false);
                }
                break;

            case R.id.rLoneQoneCycle:
                if(checked){
                    aLoneQone.setText("আপনি ভুল উত্তর নির্বাচন করেছেন, সঠিক উত্তরটি হল (পশুবাহিত যান চলাচল নিষেধ)।");
                    aLoneQone.setEnabled(true);
                }
                else {
                    aLoneQone.setEnabled(false);
                }
                break;
        }
    }
}
