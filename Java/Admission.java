package com.example.parth.restart;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Admission extends ActionBarActivity {
    private WebView webView;
    private ProgressBar progress;

    String url="http://m.gdgoenkauniversity.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.hide();

        setContentView(R.layout.activity_admission);
        webView = (WebView) findViewById(R.id.webView4);
        progress = (ProgressBar) findViewById(R.id.progressBar4);
        //progress.setVisibility(View.GONE);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());

        webView.loadUrl(url);

    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progress.setVisibility(View.GONE);
            Admission.this.progress.setProgress(100);
            webView.setWebViewClient(new WebViewClient());
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setVisibility(View.VISIBLE);
            Admission.this.progress.setProgress(0);
            super.onPageStarted(view, url, favicon);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}