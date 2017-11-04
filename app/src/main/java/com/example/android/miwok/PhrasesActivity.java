package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer player;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.raw.phrase_where_are_you_going, "Where are you going?", "minto wuksus"));
        words.add(new Word(R.raw.phrase_what_is_your_name, "What is your name?", "tinnә oyaase'nә"));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrasesList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                player = MediaPlayer.create(PhrasesActivity.this, words.get(i).getAudioId());
                player.start();

                player.setOnCompletionListener(onCompletionListener);
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        if (player != null) {
            player.release();
        }
        player = null;
    }
}
