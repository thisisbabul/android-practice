package com.example.babul.cityuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView cityWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityWeb = findViewById(R.id.cityUniversityId);

        WebSettings settings = cityWeb.getSettings();
        settings.setJavaScriptEnabled(true);

        cityWeb.setWebViewClient(new WebViewClient());

        cityWeb.loadUrl("http://su.edu.bd/");

    }

    @Override
    public void onBackPressed() {
        if (cityWeb.canGoBack()){
            cityWeb.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
