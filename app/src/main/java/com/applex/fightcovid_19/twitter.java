package com.applex.fightcovid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
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


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                webView.clearHistory();

                who.setBackgroundColor(getResources().getColor(R.color.blue));
                who.setTextColor(getResources().getColor(R.color.white));

                moh.setBackgroundColor(getResources().getColor(R.color.white));
                moh.setTextColor(getResources().getColor(R.color.blue));
                goi.setBackgroundColor(getResources().getColor(R.color.white));
                goi.setTextColor(getResources().getColor(R.color.blue));
            }

        });

        moh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://twitter.com/mohfw_india?lang=en");
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                webView.clearHistory();

                moh.setBackgroundColor(getResources().getColor(R.color.blue));
                moh.setTextColor(getResources().getColor(R.color.white));

                who.setBackgroundColor(getResources().getColor(R.color.white));
                who.setTextColor(getResources().getColor(R.color.blue));
                goi.setBackgroundColor(getResources().getColor(R.color.white));
                goi.setTextColor(getResources().getColor(R.color.blue));
            }
        });

        goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://twitter.com/mygovindia");
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                webView.clearHistory();

                goi.setBackgroundColor(getResources().getColor(R.color.blue));
                goi.setTextColor(getResources().getColor(R.color.white));

                moh.setBackgroundColor(getResources().getColor(R.color.white));
                moh.setTextColor(getResources().getColor(R.color.blue));
                who.setBackgroundColor(getResources().getColor(R.color.white));
                who.setTextColor(getResources().getColor(R.color.blue));
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

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}

