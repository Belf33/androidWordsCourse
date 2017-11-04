package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int resIdColor;

    public WordAdapter(@NonNull Activity context, @NonNull ArrayList<Word> objects, int resIdColor) {
        super(context, 0, objects);
        this.resIdColor = resIdColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView translate = (TextView) listItemView.findViewById(R.id.translate_view);
        translate.setText(currentWord.getTranslate());

        TextView english = (TextView) listItemView.findViewById(R.id.english_text_view);
        english.setText(currentWord.getEnglish());

        ImageView image = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if( currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResId());
            image.setVisibility(View.VISIBLE);

        } else  image.setVisibility(View.GONE);

        View linearLayout =  listItemView.findViewById(R.id.colorLayout);
        int color = ContextCompat.getColor(getContext(),resIdColor );
        linearLayout.setBackgroundColor(color);

        return listItemView;
    }
}
