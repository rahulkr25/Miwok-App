package com.example.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    /*
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
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PhrasesFragment()).commit();
        /*
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
      final   ArrayList<numberstrail>words=new ArrayList<numberstrail>();
        words.add(new numberstrail("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new numberstrail("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new numberstrail("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        words.add(new numberstrail( "How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new numberstrail( "I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new numberstrail( "Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new numberstrail( "Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new numberstrail( "I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        words.add(new numberstrail( "Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new numberstrail(  "Come here.", "әnni'nem",R.raw.phrase_come_here));

        numberstrailext itemsAdapter = new numberstrailext(this,words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releasemediaplayer();
                int result=mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mMediaPlayer=MediaPlayer.create(PhrasesActivity.this,words.get(position).getSongid());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener( moncompletion);
            }}
        });*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        //releasemediaplayer();
    }

   /* void releasemediaplayer()
    {
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }*/
}