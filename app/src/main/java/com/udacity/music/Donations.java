package com.udacity.music;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class Donations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations);

        //Header
        TextView headerDonations = (TextView) findViewById(R.id.headerDonations);
        headerDonations.setText(R.string.header_donate);

        //Go to Home
        TextView home = (TextView) findViewById(R.id.homeXmlFromDonations);
        home.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToHome = new Intent(Donations.this, HomeActivity.class);
                startActivity(goToHome);
            }
        });

        //Go to Search
        TextView search = (TextView) findViewById(R.id.searchXmlFromDonations);
        search.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToSearch = new Intent(Donations.this, SearchActivity.class);
                startActivity(goToSearch);
            }
        });

        //Go to library
        TextView library = (TextView) findViewById(R.id.libraryXmlFromDonations);
        library.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToLibrary = new Intent(Donations.this, LibraryActivity.class);
                startActivity(goToLibrary);
            }
        });

        //Go to WebView
        ImageView webView = (ImageView) findViewById(R.id.payPalLogo);
        webView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToWebView = new Intent(Donations.this, PayPal.class);
                startActivity(goToWebView);
            }
        });

    }
}
