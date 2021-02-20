package com.sidi.clientmobile;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        webView = findViewById(R.id.activity_main_webview);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://sidi.dev/");
        webView.loadUrl("http://c8e6b6f65820.ngrok.io/");
        
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUserAgentString("Chrome:/56.0.0 Mobile");

    }


    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }
}
