package com.udacity.music;


public class Word {

    private String mMusicName;
    private int mAudioResourceId;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    public Word(String musicName, int imageResourceId) {
        mMusicName = musicName;
        mImageResourceId = imageResourceId;
    }


    public Word(String musicName, int imageResourceId, int audioResourceId) {
        mMusicName = musicName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getMusicName() {
        return mMusicName;
    }
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
