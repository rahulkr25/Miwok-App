package com.example.languageapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

   // private MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //mediaPlayer1 = MediaPlayer.create(this, R.raw.songs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void opennumbers(View view) throws IOException {


        Intent i=new Intent(this,NumbersActivity.class);
        startActivity(i);

    }

    public void openfamily(View view) {

        Intent i=new Intent(this,FamilyActivity.class);
        startActivity(i);

    }
    public void opencolors(View view) {

        Intent i=new Intent(this,ColorsActivity.class);
        startActivity(i);

    }
    public void openphrases(View view) {
        Intent i=new Intent(this,PhrasesActivity.class);
        startActivity(i);
    }
}