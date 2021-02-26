package com.sidi.clientmobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigureDomainActivity  extends AppCompatActivity {


    Button submitButton;
    EditText configureDomainUrlInput;
    public static final String MyPREFERENCES = "sharedPreference" ;
    private SharedPreferences sharedPref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configre_domain_activity);
        configureDomainUrlInput = (EditText) findViewById(R.id.domainInputUrl);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
                //save on context the input data
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("SIDI_URL", configureDomainUrlInput.getText().toString());
                editor.commit();
                //reload the main activity
                Intent myIntent = new Intent(ConfigureDomainActivity.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}