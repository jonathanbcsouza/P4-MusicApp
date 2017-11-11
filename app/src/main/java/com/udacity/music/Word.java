package com.udacity.music;


import android.os.Parcel;
import android.os.Parcelable;

public class Word extends Throwable implements Parcelable {

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

    /*
     * Parcelable particular
     */

    public static final String PARCELABLE_KEY = "word";

    public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    private Word(Parcel in) {
        mMusicName = in.readString();
        mAudioResourceId  = in.readInt();
        mImageResourceId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMusicName);
        dest.writeInt(mAudioResourceId);
        dest.writeInt(mImageResourceId);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
