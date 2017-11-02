package com.udacity.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        TextView jonathanHeaders = (TextView) findViewById(R.id.headerLibrary);
        jonathanHeaders.setText(R.string.header_library);

        TextView home = (TextView) findViewById(R.id.homeXmlFromLibrary);
        home.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToHome = new Intent(LibraryActivity.this, HomeActivity.class);
                startActivity(goToHome);
            }
        });

        TextView library = (TextView) findViewById(R.id.searchXmlFromLibrary);
        library.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToLibrary = new Intent(LibraryActivity.this, SearchActivity.class);
                startActivity(goToLibrary);
            }
        });

        TextView artist = (TextView) findViewById(R.id.artistXmlFromLibrary);
        artist.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToArtist = new Intent(LibraryActivity.this, ArtistActivity.class);
                startActivity(goToArtist);
            }
        });


        TextView genre = (TextView) findViewById(R.id.genreXmlFromLibrary);
        genre.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToGenre = new Intent(LibraryActivity.this, Genre.class);
                startActivity(goToGenre);
            }
        });

        TextView allSongs = (TextView) findViewById(R.id.allSongXmlFromLibrary);
        allSongs.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToAllSongs = new Intent(LibraryActivity.this, AllSongs.class);
                startActivity(goToAllSongs);

            }
        });

    }

}
