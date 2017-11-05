package com.udacity.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private Button b1, b2, b3, b4;
    private int backwardTime = 5000;
    private int forwardTime = 5000;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();

    private SeekBar seekbar;
    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Creating Media Player Interface
        //--------------------------------------------------------------------------//

        b1 = (Button) findViewById(R.id.buttonPlay);
        b2 = (Button) findViewById(R.id.buttonPause);
        b3 = (Button) findViewById(R.id.buttonRewind);
        b4 = (Button) findViewById(R.id.buttonForward);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setClickable(false);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toast_playing, Toast.LENGTH_SHORT).show();
                mMediaPlayer.start();

                finalTime = mMediaPlayer.getDuration();
                startTime = mMediaPlayer.getCurrentPosition();

                myHandler.postDelayed(UpdateSongTime, 100);
                b1.setEnabled(false);
                b2.setEnabled(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toast_pausing, Toast.LENGTH_SHORT).show();
                mMediaPlayer.pause();
                b1.setEnabled(true);
                b2.setEnabled(false);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    mMediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(), R.string.toast_backward,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NowPlaying.this, "Sound restarted",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mMediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),
                            R.string.toast_forward, Toast.LENGTH_SHORT).show();
                } else {
                    mMediaPlayer.seekTo((int) finalTime);
                    Toast.makeText(NowPlaying.this, "The song ended",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaPlayer.getCurrentPosition();
            //tx1.setText(String.format("%d min, %d sec",
            //        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
            //      TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
            //              TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
            //                      toMinutes((long) startTime)))
            //);
            //seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };
//-----------------------------------------------------------------------//
}
