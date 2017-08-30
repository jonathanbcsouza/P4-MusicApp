package com.udacitymusicexample.udacitymusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words) {

        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.format_array_list_standard, parent, false);
        }

        Word currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.music_text_view);
        nameTextView.setText(currentWord.getMusicName());

        // Find the ImageView
        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        if (currentWord.hasImage()) {
            defaultImageView.setImageResource(currentWord.getImageResourceId());
            defaultImageView.setVisibility(View.VISIBLE);

        } else {
            // Esta linha oculta totalmente a imagem
            defaultImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
