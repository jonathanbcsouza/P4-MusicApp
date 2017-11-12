package com.udacity.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //Inflate header
        TextView headerLibrary = (TextView) findViewById(R.id.headerLibrary);
        headerLibrary.setText(R.string.header_library);

        //Go to Home
        TextView home = (TextView) findViewById(R.id.homeXmlFromLibrary);
        home.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToHome = new Intent(LibraryActivity.this, HomeActivity.class);
                startActivity(goToHome);
            }
        });

        //Go to Search
        TextView library = (TextView) findViewById(R.id.searchXmlFromLibrary);
        library.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToLibrary = new Intent(LibraryActivity.this, SearchActivity.class);
                startActivity(goToLibrary);
            }
        });

        //Go to Donate
        TextView syncDonate = (TextView) findViewById(R.id.paymentXmlFromLibrary);
        syncDonate.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {

                Intent goToDonations = new Intent(LibraryActivity.this, DonationsActivity.class);
                startActivity(goToDonations);
            }
        });

        //Go to Option 1 Artists
        TextView artist = (TextView) findViewById(R.id.artistXmlFromLibrary);
        artist.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                ArrayList<Word> artistList = new ArrayList<Word>();
                artistList.add(new Word(getString(R.string.artist1), R.drawable.artist_john_hindemith));
                artistList.add(new Word(getString(R.string.artist2), R.drawable.artist_felguk));
                artistList.add(new Word(getString(R.string.artist3), R.drawable.artist_audioslave));

                Intent goToArtist = new Intent(LibraryActivity.this, ArtistActivity.class);
                goToArtist.putParcelableArrayListExtra(Word.PARCELABLE_KEY, artistList);
                startActivity(goToArtist);
            }
        });

        //Go to Option 2 GenreActivity
        TextView genre = (TextView) findViewById(R.id.genreXmlFromLibrary);
        genre.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                final ArrayList<Word> genreList = new ArrayList<Word>();
                genreList.add(new Word(getString(R.string.genre_alternative), R.drawable.genre_alternative));
                genreList.add(new Word(getString(R.string.genre_electronic), R.drawable.genre_dance));
                genreList.add(new Word(getString(R.string.genre_rock), R.drawable.genre_rock));

                Intent goToGenre = new Intent(LibraryActivity.this, GenreActivity.class);
                goToGenre.putParcelableArrayListExtra(Word.PARCELABLE_KEY, genreList);
                startActivity(goToGenre);
            }
        });

        //Go to Option 3 AllSongs
        TextView allSongs = (TextView) findViewById(R.id.allSongXmlFromLibrary);
        allSongs.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {

                final ArrayList<Word> allSongsList = new ArrayList<Word>();
                //Artist1
                allSongsList.add(new Word(getString(R.string.artist1) + "\n" + getString(R.string.artist1music1), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_enlightening));
                allSongsList.add(new Word(getString(R.string.artist1) + "\n" + getString(R.string.artist1music2), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_darknessandlight));
                //Artist2
                allSongsList.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music1), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_dead_man_wag));
                allSongsList.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music2), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_white_horse));
                allSongsList.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music3), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_hands_up_for_detroit));
                //Artist3
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music1), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave1_cochise));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music2), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave2_show_me_how_to_live));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music3), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave3_gasoline));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music4), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave4_what_you_are));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music5), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave5_like_a_stone));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music6), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave6_set_it_off));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music7), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave7_shadow_on_the_sun));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music8), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave8_i_am_the_highway));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music9), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave9_exploder));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music10), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave10_hypnotize));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music11), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave11_bring_back));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music12), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave12_light_my_way));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music13), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave13_getaway_car));
                allSongsList.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music14), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave14_the_last_remaining_light));

                Intent goToAllSongs = new Intent(LibraryActivity.this, PlayingScreen.class);
                goToAllSongs.putParcelableArrayListExtra(Word.PARCELABLE_KEY, allSongsList);
                startActivity(goToAllSongs);

            }
        });
    }
}
