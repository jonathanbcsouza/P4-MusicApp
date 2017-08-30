package com.udacitymusicexample.udacitymusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView search = (TextView) findViewById(R.id.searchXml);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent goToSearchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(goToSearchIntent);
            }
        });

        TextView library = (TextView) findViewById(R.id.libraryXml);
        library.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToLibraryIntent = new Intent(HomeActivity.this, LibraryActivity.class);
                startActivity(goToLibraryIntent);
            }
        });

    }

}