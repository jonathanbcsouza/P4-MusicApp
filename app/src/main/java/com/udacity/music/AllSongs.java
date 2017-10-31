package com.udacity.music;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllSongs extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer selectPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("John Hindemith", R.drawable.ic_play_arrow_white_24dp, R.raw.light_and_darkness));
        words.add(new Word("Dead Man Swag", R.drawable.ic_play_arrow_white_24dp, R.raw.dead_man_swag));
        words.add(new Word("I'm So Happy", R.drawable.ic_play_arrow_white_24dp, R.raw.im_so_happy));
        words.add(new Word("Electric way", R.drawable.ic_play_arrow_white_24dp, R.raw.martin_garrix));
        words.add(new Word("White Horse", R.drawable.ic_play_arrow_white_24dp, R.raw.white_horse));
        words.add(new Word("Miwok Song", R.drawable.ic_play_arrow_white_24dp, R.raw.color_black));
        words.add(new Word("Maria Clara Song", R.drawable.ic_play_arrow_white_24dp, R.raw.color_black));


        final WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                //Found the position that was clicked
                final Word word = words.get(position);

                //Config player to correct position choosed
                mMediaPlayer = MediaPlayer.create(AllSongs.this, word.getAudioResourceId());

                //Start the song
                mMediaPlayer.start();

                //Callback for action when the audio stopped WAITING STACK OVERFLOW ANSWER
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {

                        Word songPosition = words.get(position);

                        selectPosition = MediaPlayer.create(AllSongs.this, songPosition.getAudioResourceId());
                        selectPosition.setTextColor

                        String figureOutMusicName = songPosition.getMusicName().toUpperCase();
                        Toast.makeText(AllSongs.this, "The song " + figureOutMusicName + " is finished", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}