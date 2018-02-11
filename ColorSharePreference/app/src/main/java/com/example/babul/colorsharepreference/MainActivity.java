package com.example.babul.colorsharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayoutId);
        if (loadColor()!=Color.GRAY){
            layout.setBackgroundColor(loadColor());
        }
    }

    private int loadColor() {
        SharedPreferences sharedPreferences = getSharedPreferences("colorchooser", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("color")){
            return sharedPreferences.getInt("color", Color.GRAY);
        }
        return Color.GRAY;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.redMenuId){
            layout.setBackgroundColor(Color.RED);
            saveColor(Color.RED);
        }else if (item.getItemId()==R.id.greenMenuId){
            layout.setBackgroundColor(Color.GREEN);
            saveColor(Color.GREEN);
        }else if (item.getItemId()==R.id.yellowMenuId){
            layout.setBackgroundColor(Color.YELLOW);
            saveColor(Color.YELLOW);
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("colorchooser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color",color);
        editor.commit();
    }


}
