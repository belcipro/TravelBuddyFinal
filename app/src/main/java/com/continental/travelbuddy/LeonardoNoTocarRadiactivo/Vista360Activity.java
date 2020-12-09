package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.continental.travelbuddy.R;

public class Vista360Activity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___lugar_turistico_detalles_vista360);

        //obtener la url
        String url = getIntent().getStringExtra("url");

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl(url);

    }
    private class MyWebViewClient extends WebViewClient {

        public boolean shouldOverrideloading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}