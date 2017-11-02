package com.udacity.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Artist2Songs extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.artist2music1), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_dead_man_wag));
        words.add(new Word(getString(R.string.artist2music2), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_white_horse));
        words.add(new Word(getString(R.string.artist2music3), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_hands_up_for_detroit));

        final WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                //Found the position that was clicked
                final Word word = words.get(position);

                //Config player to correct position choosed
                mMediaPlayer = MediaPlayer.create(Artist2Songs.this, word.getAudioResourceId());

                //Start the song
                mMediaPlayer.start();

                //Callback for action when the audio stopped
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {

                        Word songPosition = words.get(position);

                        // Change the color when the audio selected has finish ??? ERROR HERE, function will be finish for next update.
                        // selectPosition = MediaPlayer.create(AllSongs.this, songPosition.getAudioResourceId());
                        //selectPosition.setTextColor ????????

                        // Show a toast messagem when the audio selected has finish
                        String figureOutMusicName = songPosition.getMusicName().toUpperCase();
                        Toast.makeText(Artist2Songs.this, "The song " + figureOutMusicName + " is finished", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}