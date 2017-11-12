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

public class GenreActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> genreList = getIntent().getExtras().getParcelableArrayList(Word.PARCELABLE_KEY);
        
        ListView listView = (ListView) findViewById(R.id.word_list);

        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView makeHeader = (TextView) headerView.findViewById(R.id.text_listView_header);
        makeHeader.setText(getString(R.string.header_genre));
        listView.addHeaderView(headerView);

        WordAdapter itemsAdapter = new WordAdapter(this, genreList);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Found the position that was clicked
                if (position == 1) {

                    final ArrayList<Word> artistSongs1 = new ArrayList<Word>();
                    artistSongs1.add(new Word(getString(R.string.artist1music1), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_enlightening));
                    artistSongs1.add(new Word(getString(R.string.artist1music2), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_darknessandlight));

                    Intent goToAllSongs = new Intent(GenreActivity.this, PlayingScreen.class);
                    goToAllSongs.putParcelableArrayListExtra(Word.PARCELABLE_KEY, artistSongs1);
                    startActivity(goToAllSongs);
                }

                if (position == 2) {

                    final ArrayList<Word> artistSongs2 = new ArrayList<Word>();
                    artistSongs2.add(new Word(getString(R.string.artist2music1), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_dead_man_wag));
                    artistSongs2.add(new Word(getString(R.string.artist2music2), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_white_horse));
                    artistSongs2.add(new Word(getString(R.string.artist2music3), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_hands_up_for_detroit));

                    Intent goToAllSongs = new Intent(GenreActivity.this, PlayingScreen.class);
                    goToAllSongs.putParcelableArrayListExtra(Word.PARCELABLE_KEY, artistSongs2);
                    startActivity(goToAllSongs);
                }

                if (position == 3) {

                    final ArrayList<Word> artistSongs3 = new ArrayList<Word>();
                    artistSongs3.add(new Word(getString(R.string.artist3music1), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave1_cochise));
                    artistSongs3.add(new Word(getString(R.string.artist3music2), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave2_show_me_how_to_live));
                    artistSongs3.add(new Word(getString(R.string.artist3music3), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave3_gasoline));
                    artistSongs3.add(new Word(getString(R.string.artist3music4), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave4_what_you_are));
                    artistSongs3.add(new Word(getString(R.string.artist3music5), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave5_like_a_stone));
                    artistSongs3.add(new Word(getString(R.string.artist3music6), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave6_set_it_off));
                    artistSongs3.add(new Word(getString(R.string.artist3music7), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave7_shadow_on_the_sun));
                    artistSongs3.add(new Word(getString(R.string.artist3music8), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave8_i_am_the_highway));
                    artistSongs3.add(new Word(getString(R.string.artist3music9), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave9_exploder));
                    artistSongs3.add(new Word(getString(R.string.artist3music10), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave10_hypnotize));
                    artistSongs3.add(new Word(getString(R.string.artist3music11), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave11_bring_back));
                    artistSongs3.add(new Word(getString(R.string.artist3music12), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave12_light_my_way));
                    artistSongs3.add(new Word(getString(R.string.artist3music13), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave13_getaway_car));
                    artistSongs3.add(new Word(getString(R.string.artist3music14), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave14_the_last_remaining_light));

                    Intent goToAllSongs = new Intent(GenreActivity.this, PlayingScreen.class);
                    goToAllSongs.putParcelableArrayListExtra(Word.PARCELABLE_KEY, artistSongs3);
                    startActivity(goToAllSongs);
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}