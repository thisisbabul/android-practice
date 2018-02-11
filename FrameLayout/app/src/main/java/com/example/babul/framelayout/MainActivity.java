package com.example.babul.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView login, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        login = findViewById(R.id.imageviewLoginId);
        logout = findViewById(R.id.imageviewLogoutId);

        login.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.imageviewLoginId==v.getId()){
            login.setVisibility(View.GONE);
            logout.setVisibility(View.VISIBLE);
        }else if (R.id.imageviewLogoutId==v.getId()){
            logout.setVisibility(View.GONE);
            login.setVisibility(View.VISIBLE);
        }
    }
}
