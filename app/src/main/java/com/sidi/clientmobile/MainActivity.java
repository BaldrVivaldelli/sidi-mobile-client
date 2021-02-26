package com.sidi.clientmobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Button buttonResetValues;
    private SharedPreferences sharedPref;
    public static final String MyPREFERENCES = "sharedPreference" ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        webView = findViewById(R.id.activity_main_webview);
        buttonResetValues = (Button) findViewById(R.id.button_reset_values);
        buttonResetValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear().commit();
                Intent myIntent = new Intent(MainActivity.this,MainActivity .class);
                startActivity(myIntent);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                Intent myIntent = new Intent(MainActivity.this,ConfigureDomainActivity.class);
                startActivity(myIntent);
            }
        });
        //webView.loadUrl("http://sidi.dev/");
        sharedPref = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        String sidiUrl = sharedPref.getString("SIDI_URL","http://8ec8af49c916.ngrok.io/");
        if(sidiUrl.contains("http")){

        }else{
            sidiUrl = "http://" + sidiUrl;
        }
        webView.loadUrl(sidiUrl);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUserAgentString("Chrome:/56.0.0 Mobile");

    }


    @Override
    public void onBackPressed() {

        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }


}
