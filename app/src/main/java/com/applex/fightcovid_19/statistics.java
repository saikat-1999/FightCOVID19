package com.applex.fightcovid_19;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class statistics extends AppCompatActivity {

    private WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        progressBar = findViewById(R.id.progress);
        webView = findViewById(R.id.webview);
        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
        if(getIntent().getStringExtra("choice").matches("stats"))
            webView.loadUrl("https://www.covidvisualizer.com/");
        else if(getIntent().getStringExtra("choice").matches("donate"))
            webView.loadUrl("https://www.pmindia.gov.in/en/?query#");
        else if(getIntent().getStringExtra("choice").matches("state"))
            webView.loadUrl("https://www.mohfw.gov.in/");

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
