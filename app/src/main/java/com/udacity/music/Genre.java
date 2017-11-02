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

import static com.udacity.music.R.id.parent;

public class Genre extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> genre = new ArrayList<Word>();

        genre.add(new Word(getString(R.string.genre_alternative), R.drawable.genre_alternative));
        genre.add(new Word(getString(R.string.genre_electronic), R.drawable.genre_dance));
        genre.add(new Word(getString(R.string.genre_rock), R.drawable.genre_rock));

        ListView listView = (ListView) findViewById(R.id.word_list);

        // Getting Model of Header from XML
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView makeHeader = (TextView) headerView.findViewById(R.id.text_listview_header);
        // Setting text on Header
        makeHeader.setText(getString(R.string.header_genre));
        // Add header view to the ListView
        listView.addHeaderView(headerView);

        // Create PlayListAdapter object to display list view
        WordAdapter itemsAdapter = new WordAdapter(this, genre);
        listView.setAdapter(itemsAdapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaylistActivity
        listView.setOnItemClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Found the position that was clicked
                if (position == 1) {

                    Intent goToAllArtist1Songs = new Intent(Genre.this, Artist1Songs.class);
                    startActivity(goToAllArtist1Songs);
                }

                if (position == 2) {

                    Intent goToAllSongs = new Intent(Genre.this, Artist2Songs.class);
                    startActivity(goToAllSongs);
                }

                if (position == 3) {

                    Intent goToAllSongs = new Intent(Genre.this, Artist3Songs.class);
                    startActivity(goToAllSongs);
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}