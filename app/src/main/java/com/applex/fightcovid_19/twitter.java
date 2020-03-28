package com.applex.fightcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class twitter extends AppCompatActivity {
    private WebView webView;
    ProgressBar progressBar;
    Button who;
    Button moh;
    Button goi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        progressBar = findViewById(R.id.progressbar);
        who = findViewById(R.id.whobtn);
        moh = findViewById(R.id.mohbtn);
        goi = findViewById(R.id.goibtn);
        webView = findViewById(R.id.web);
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
        webView.loadUrl("https://twitter.com/who?lang=en");
        who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://twitter.com/who?lang=en");
            }

        });

        moh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://twitter.com/mohfw_india?lang=en");
            }
        });

        goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://twitter.com/mygovindia");
            }
        });

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

