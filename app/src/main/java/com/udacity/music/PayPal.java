package com.udacity.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class PayPal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);

        //Header
        TextView headerPayPal = (TextView) findViewById(R.id.header_webView);
        headerPayPal.setText(R.string.header_webView);

        WebView payPaySite = (WebView) findViewById(R.id.payPalWebView);
        // Enable Javascript
        WebSettings webSettings = payPaySite.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //InVoice
        payPaySite.loadUrl("https://www.paypal.com/invoice/p/#PPGVDPNKFH28X84Z");


        //Return to Donations
        TextView returnToDonations = (TextView) findViewById(R.id.paymentXmlFromPayPalXml);
        returnToDonations.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToLibrary = new Intent(PayPal.this, Donations.class);
                startActivity(goToLibrary);
            }
        });
    }
}
