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

        TextView jonathanHeaders = (TextView) findViewById(R.id.headerHome);
        jonathanHeaders.setText(R.string.header_home);

        // Go to Search screen
        TextView syncSearch = (TextView) findViewById(R.id.searchXml);
        syncSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent goToSearchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(goToSearchIntent);
            }
        });

        // Go to library screen
        TextView syncLibrary = (TextView) findViewById(R.id.libraryXml);
        syncLibrary.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToLibraryIntent = new Intent(HomeActivity.this, LibraryActivity.class);
                startActivity(goToLibraryIntent);
            }
        });

    }

}