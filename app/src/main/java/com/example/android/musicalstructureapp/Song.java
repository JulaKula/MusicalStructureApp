package com.example.android.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jula-Kula on 23/03/2018
 */

public class Song implements Parcelable {

    private String mArtist;
    private String mTitle;

    public Song (String artist, String title) {
        mArtist = artist;
        mTitle = title;
    }

    protected Song(Parcel in) {
        mArtist = in.readString();
        mTitle = in.readString();
    }


    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTitle(){
        return mTitle;
    }

    public String getArtist(){
        return mArtist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtist);
        parcel.writeString(mTitle);
    }
}
