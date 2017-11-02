package com.udacity.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.artist1), R.drawable.artist_john_hindemith));
        words.add(new Word(getString(R.string.artist2), R.drawable.artist_felguk));
        words.add(new Word(getString(R.string.artist3), R.drawable.artist_audioslave));

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);

        // Getting Model of Header from XML
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView makeHeader = (TextView) headerView.findViewById(R.id.text_listview_header);
        // Setting text on Header
        makeHeader.setText(getString(R.string.header_artist));
        // Add header view to the ListView
        listView.addHeaderView(headerView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Found the position that was clicked
                if (position == 1) {

                    Intent goToAllArtist1Songs = new Intent(ArtistActivity.this, Artist1Songs.class);
                    startActivity(goToAllArtist1Songs);
                }

                if (position == 2) {

                    Intent goToAllSongs = new Intent(ArtistActivity.this, Artist2Songs.class);
                    startActivity(goToAllSongs);
                }

                if (position == 3) {

                    Intent goToAllSongs = new Intent(ArtistActivity.this, Artist3Songs.class);
                    startActivity(goToAllSongs);
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}