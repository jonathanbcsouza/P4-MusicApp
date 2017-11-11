package com.udacity.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView searchHeader = (TextView) findViewById(R.id.headerSearch);
        searchHeader.setText(R.string.header_search);

        TextView search = (TextView) findViewById(R.id.homeXmlFromSearch);
        search.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToSearch = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(goToSearch);
            }
        });

        TextView library = (TextView) findViewById(R.id.libraryXmlFromSearch);
        library.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToLibrary = new Intent(SearchActivity.this, LibraryActivity.class);
                startActivity(goToLibrary);
            }
        });

        TextView syncDonate = (TextView) findViewById(R.id.paymentXmlFromSearch);
        syncDonate.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToLibraryIntent = new Intent(SearchActivity.this, Donations.class);
                startActivity(goToLibraryIntent);
            }
        });
    }
}