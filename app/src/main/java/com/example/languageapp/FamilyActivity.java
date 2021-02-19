package com.example.languageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener moncompletion=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releasemediaplayer();
        }
    };
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
       final ArrayList<numberstrail>words=new ArrayList<numberstrail>();
       words.add(new numberstrail( "father", "әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new numberstrail( "mother", "әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new numberstrail(  "son", "angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new numberstrail( "daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new numberstrail( "older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new numberstrail( "younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new numberstrail( "older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new numberstrail( "younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new numberstrail( "grandmother ", "ama",R.drawable.family_grandmother,R.raw.family_grandfather));
        words.add(new numberstrail( "grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        numberstrailext itemsAdapter = new numberstrailext(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releasemediaplayer();
               int result= mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
               mMediaPlayer=MediaPlayer.create(FamilyActivity.this, words.get(position).getSongid());
               mMediaPlayer.start();
               mMediaPlayer.setOnCompletionListener( moncompletion);
            }}
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releasemediaplayer();
    }

    void releasemediaplayer()
    {
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }
}