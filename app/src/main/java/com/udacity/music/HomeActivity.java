package com.udacity.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView headerHome = (TextView) findViewById(R.id.headerHome);
        headerHome.setText(R.string.header_home);

        TextView syncSearch = (TextView) findViewById(R.id.searchXmlFromHome);
        syncSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent goToSearchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(goToSearchIntent);
            }
        });

        TextView syncLibrary = (TextView) findViewById(R.id.libraryXmlFromHome);
        syncLibrary.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToLibraryIntent = new Intent(HomeActivity.this, LibraryActivity.class);
                startActivity(goToLibraryIntent);
            }
        });

        TextView syncDonate = (TextView) findViewById(R.id.paymentXmlFromHome);
        syncDonate.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToLibraryIntent = new Intent(HomeActivity.this, DonationsActivity.class);
                startActivity(goToLibraryIntent);
            }
        });
    }
}