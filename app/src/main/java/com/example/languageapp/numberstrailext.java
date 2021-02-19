package com.example.languageapp;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.ArrayList;


public class numberstrailext extends ArrayAdapter<numberstrail> {

    private MediaPlayer mediaPlayer1;


    private int resid;
    //private static final String LOG_TAG =  WordAdapter.class.getSimpleName();
    public numberstrailext(Activity context, ArrayList<numberstrail> words,int resource) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context,0,words);
        resid=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.numberstrail, parent, false);
        }



        View textContainer = listItemView.findViewById(R.id.constraintforall);

        int color = ContextCompat.getColor(getContext(),resid);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Get the {@link AndroidFlavor} object located at this position in the list
        numberstrail currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_textview);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getMiwok());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAndroidFlavor.geteng());
        if(currentAndroidFlavor.getid()!=0) {


            ImageView imageTextview = (ImageView) listItemView.findViewById(R.id.image);
            imageTextview.setImageResource(currentAndroidFlavor.getid());
        }

        return listItemView;
    }


}
