package com.udacitymusicexample.udacitymusic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String testeString = "ola";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("John Hindemith", R.drawable.family_mother));
        words.add(new Word("Udaci Beatles", R.drawable.family_mother));
        words.add(new Word("Udaci Head", R.drawable.family_mother));


        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);


        // Inflate header view
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView textHeader = (TextView) headerView.findViewById(R.id.text_listview_header);
        textHeader.setText(getString(R.string.text_artist_header));

        listView.addHeaderView(headerView);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaylistActivity
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

