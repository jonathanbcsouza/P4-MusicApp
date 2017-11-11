package com.udacity.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.udacity.music.R.drawable.gif_nerd_dancing_storm;
import static com.udacity.music.R.drawable.gif_volumeblue;

public class PlayingScreen extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private Button buttonPlay, buttonPause, buttonRewind, buttonForward;
    private int backwardTime = 5000;
    private int forwardTime = 5000;
    private double startTime = 0;
    private double finalTime = 0;
    private SeekBar seekbar;
    private Handler myHandler = new Handler();
    public static int oneTimeOnly = 0;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Get Intent
        final ArrayList<Word> listOfSongsGenerated = getIntent().getExtras().getParcelableArrayList(Word.PARCELABLE_KEY);

        final WordAdapter itemsAdapter = new WordAdapter(this, listOfSongsGenerated);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);

        // Getting Model of Header from XML
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView makeHeader = (TextView) headerView.findViewById(R.id.text_listView_header);
        makeHeader.setText(getString(R.string.header_allSongs));
        listView.addHeaderView(headerView);


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                setContentView(R.layout.activity_playing_screen);
                TextView newHeader = (TextView) findViewById(R.id.text_listView_header_playing);
                newHeader.setText(R.string.header_mediaPlayer);

                // Setting and animating gif
                ImageView artistImage = (ImageView) findViewById(R.id.artistImagePlaying);
                artistImage.setImageResource(gif_nerd_dancing_storm);

                Glide.with(PlayingScreen.this)
                        .load(R.drawable.gif_nerd_dancing_storm)
                        .asGif()
                        .placeholder(R.drawable.gif_nerd_dancing_storm)
                        .crossFade()
                        .into(artistImage);

                // Creating Media Player Interface
                buttonPlay = (Button) findViewById(R.id.buttonPlay);
                buttonPause = (Button) findViewById(R.id.buttonPause);
                buttonRewind = (Button) findViewById(R.id.buttonRewind);
                buttonForward = (Button) findViewById(R.id.buttonForward);
                seekbar = (SeekBar) findViewById(R.id.seekBar);
                seekbar.setClickable(false);

                buttonPlay.setEnabled(false);
                buttonPause.setEnabled(true);

                //Found the position that was clicked
                final Word word = listOfSongsGenerated.get(position - 1);

                // Call method for stop actually song before then other audio start
                releaseMediaPlayer();

                //Config player to correct position chosen
                mMediaPlayer = MediaPlayer.create(PlayingScreen.this, word.getAudioResourceId());

                //Start the song clicked
                mMediaPlayer.start();

                //Get duration
                finalTime = mMediaPlayer.getDuration();
                startTime = mMediaPlayer.getCurrentPosition();

                // Setup method from >>> Cleaning up MediaPlayer resources
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

                //Callback for action when the audio stopped
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()

                {
                    public void onCompletion(MediaPlayer mp) {

                        Word songPosition = listOfSongsGenerated.get(position - 1);

                        // I wanted change the color when the audio selected has finish ??? ERROR HERE.
                        // selectPosition = MediaPlayer.create(AllSongs.this, songPosition.getAudioResourceId());
                        //selectPosition.setTextColor ????????

                        // Show a toast message when the audio selected has finish
                        String figureOutMusicName = songPosition.getMusicName().toUpperCase();
                        Toast.makeText(PlayingScreen.this, "The song " + figureOutMusicName + " is finished", Toast.LENGTH_SHORT).show();
                    }
                });

                //Seek bar config
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                myHandler.postDelayed(UpdateSongTime, 100);
                seekbar.setProgress((int) startTime);

                //Buttons config
                buttonPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), R.string.toast_playing, Toast.LENGTH_SHORT).show();
                        mMediaPlayer.start();
                        buttonPlay.setEnabled(false);
                        buttonPause.setEnabled(true);

                        ImageView artistImage = (ImageView) findViewById(R.id.artistImagePlaying);
                        artistImage.setImageResource(gif_nerd_dancing_storm);
                        Glide.with(PlayingScreen.this)
                                .load(R.drawable.gif_nerd_dancing_storm)
                                .asGif()
                                .placeholder(R.drawable.gif_nerd_dancing_storm)
                                .crossFade()
                                .into(artistImage);
                    }
                });

                buttonPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), R.string.toast_pausing, Toast.LENGTH_SHORT).show();
                        mMediaPlayer.pause();
                        buttonPlay.setEnabled(true);
                        buttonPause.setEnabled(false);

                        ImageView pauseImage = (ImageView) findViewById(R.id.artistImagePlaying);
                        pauseImage.setImageResource(gif_volumeblue);
                        Glide.with(PlayingScreen.this)
                                .load(R.drawable.gif_volumeblue)
                                .asGif()
                                .placeholder(R.drawable.gif_volumeblue)
                                .crossFade()
                                .into(pauseImage);
                    }
                });

                buttonRewind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int temp = (int) startTime;
                        if ((temp - backwardTime) > 0) {
                            startTime = startTime - backwardTime;
                            mMediaPlayer.seekTo((int) startTime);
                        } else {
                            Toast.makeText(PlayingScreen.this, R.string.rewindRestart,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                buttonForward.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int temp = (int) startTime;
                        if ((temp + forwardTime) <= finalTime) {
                            startTime = startTime + forwardTime;
                            mMediaPlayer.seekTo((int) startTime);
                        } else {
                            Toast.makeText(PlayingScreen.this, R.string.forwardFinish,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaPlayer.getCurrentPosition();
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {

            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMediaPlayer != null) {
            mMediaPlayer.pause();
        }
    }
}