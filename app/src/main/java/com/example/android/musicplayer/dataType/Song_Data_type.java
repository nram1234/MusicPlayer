package com.example.android.musicplayer.dataType;

import android.os.Parcel;
import android.os.Parcelable;

public class Song_Data_type implements Parcelable {
    public String songName;
    public String artistName;
    public int songImage = NO_IMAG;
    //out of all valid resources id
    static final int NO_IMAG = -1;

    public Song_Data_type(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;

    }

    public Song_Data_type(String songName, String artistName, int songImage) {
        this.songName = songName;
        this.artistName = artistName;
        this.songImage = songImage;
    }

    protected Song_Data_type(Parcel in) {
        songName = in.readString();
        artistName = in.readString();
        songImage = in.readInt();
    }

    public static final Creator<Song_Data_type> CREATOR = new Creator<Song_Data_type>() {
        @Override
        public Song_Data_type createFromParcel(Parcel in) {
            return new Song_Data_type(in);
        }

        @Override
        public Song_Data_type[] newArray(int size) {
            return new Song_Data_type[size];
        }
    };

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getSongImage() {
        return songImage;
    }

    public boolean hasImage() {
        return songImage != NO_IMAG;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(songName);
        parcel.writeString(artistName);
        parcel.writeInt(songImage);
    }
}
