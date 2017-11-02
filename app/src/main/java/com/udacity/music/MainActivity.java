package com.udacity.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView home = (TextView) findViewById(R.id.welcomeExit);
        home.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent goToHomeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(goToHomeIntent);
            }
        });

    }
}

