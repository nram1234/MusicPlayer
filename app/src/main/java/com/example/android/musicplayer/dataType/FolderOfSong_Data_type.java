package com.example.android.musicplayer.dataType;

import android.os.Parcel;
import android.os.Parcelable;

public class FolderOfSong_Data_type implements Parcelable {
    public String nameOfFolder;
    public int numberOfSong;
    public int imageArtist = NO_IMAG;
    //out of all valid resources id
    public static final int NO_IMAG = -1;

    public FolderOfSong_Data_type(String nameOfFolder, int numberOfSong) {
        this.nameOfFolder = nameOfFolder;
        this.numberOfSong = numberOfSong;
    }

    public FolderOfSong_Data_type(String nameOfFolder, int numberOfSong, int imageArtist) {
        this.nameOfFolder = nameOfFolder;
        this.numberOfSong = numberOfSong;
        this.imageArtist = imageArtist;
    }

    protected FolderOfSong_Data_type(Parcel in) {
        nameOfFolder = in.readString();
        numberOfSong = in.readInt();
        imageArtist = in.readInt();
    }

    public static final Creator<FolderOfSong_Data_type> CREATOR = new Creator<FolderOfSong_Data_type>() {
        @Override
        public FolderOfSong_Data_type createFromParcel(Parcel in) {
            return new FolderOfSong_Data_type(in);
        }

        @Override
        public FolderOfSong_Data_type[] newArray(int size) {
            return new FolderOfSong_Data_type[size];
        }
    };

    public String getNameOfFolder() {
        return nameOfFolder;
    }

    public int getNumberOfSong() {
        return numberOfSong;
    }

    public int getImageArtist() {
        return imageArtist;
    }

    public boolean hasImage() {
        return imageArtist != NO_IMAG;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameOfFolder);
        parcel.writeInt(numberOfSong);
        parcel.writeInt(imageArtist);
    }
}
