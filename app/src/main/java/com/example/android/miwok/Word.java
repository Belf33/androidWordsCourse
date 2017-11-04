package com.example.android.miwok;

/**
 * Created by white on 25/10/2017.
 */

public class Word {

    private String english;
    private String translate;
    private int imageResId = NO_IMAGE_PROVIDED;
    private static int NO_IMAGE_PROVIDED = -1;
    private int audioId;

    public Word(int audioId, String english, String translate) {
        this.english = english;
        this.translate = translate;
        this.audioId = audioId;
    }

    public Word(String english, String translate, int imageResId) {
        this.english = english;
        this.translate = translate;
        this.imageResId = imageResId;
    }

    public Word(String english, String translate, int imageResId, int audioId) {
        this.english = english;
        this.translate = translate;
        this.imageResId = imageResId;
        this.audioId = audioId;
    }

    public String getEnglish() {
        return english;
    }

    public String getTranslate() {
        return translate;
    }

    public int getImageResId() {
        return imageResId;
    }

    public Boolean hasImage() {
        return imageResId != NO_IMAGE_PROVIDED;
    }

    public int getAudioId() {
        return audioId;
    }
}
