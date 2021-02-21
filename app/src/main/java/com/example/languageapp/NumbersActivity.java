package com.example.languageapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    /*
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
   private MediaPlayer.OnCompletionListener mCompletionlistener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            //Toast.makeText(NumbersActivity.this,words.get(i).getMiwok()+" Played",Toast.LENGTH_SHORT).show();
            releasemediaplayer();
        }
    };
   private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
       @Override
       public void onAudioFocusChange(int focusChange) {

           if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                   focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
               // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
               // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
               // our app is allowed to continue playing sound but at a lower volume. We'll treat
               // both cases the same way because our app is playing short sound files.

               // Pause playback and reset player to the start of the file. That way, we can
               // play the word from the beginning when we resume playback.
               mMediaPlayer.pause();
               mMediaPlayer.seekTo(0);
           } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
               // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
               mMediaPlayer.start();
           } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
               // The AUDIOFOCUS_LOSS case means we've lost audio focus and
               // Stop playback and clean up resources
               releasemediaplayer();
           }
       }
   };
*/
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NumbersFragment())
                .commit();
       /* mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<numberstrail> words = new ArrayList<numberstrail>();

        words.add(new numberstrail("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new numberstrail("Two", "Otikko", R.drawable.number_two, R.raw.number_two));
        words.add(new numberstrail("Three", "Tollokosu", R.drawable.number_three, R.raw.number_three));
        words.add(new numberstrail("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new numberstrail("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new numberstrail("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new numberstrail("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new numberstrail("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new numberstrail("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new numberstrail("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        numberstrailext itemsAdapter = new numberstrailext(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int song = words.get(i).songid;
                releasemediaplayer();
               int result= mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                       AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                   mMediaPlayer = MediaPlayer.create(NumbersActivity.this, song);
                   mMediaPlayer.start();
                   mMediaPlayer.setOnCompletionListener(mCompletionlistener);
               }};

        });
        */

    }

   /* @Override
    protected void onStop() {
        super.onStop();
        releasemediaplayer();
    }*/

   /* void releasemediaplayer()
    {
        if(mMediaPlayer!=null) {
            mMediaPlayer.release();
            mMediaPlayer=null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }*/
};