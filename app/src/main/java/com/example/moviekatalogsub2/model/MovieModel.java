package com.example.moviekatalogsub2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    private String judulMovie;
    private int posterMovie;
    private String jadwalMovie;
    private String rateMovie;
    private String descMovie;



    public String getJudulMovie() {
        return judulMovie;
    }

    public void setJudulMovie(String judulMovie) {
        this.judulMovie = judulMovie;
    }

    public int getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(int posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String getJadwalMovie() {
        return jadwalMovie;
    }

    public void setJadwalMovie(String jadwalMovie) {
        this.jadwalMovie = jadwalMovie;
    }

    public String getRateMovie() {
        return rateMovie;
    }

    public void setRateMovie(String rateMovie) {
        this.rateMovie = rateMovie;
    }

    public String getDescMovie() {
        return descMovie;
    }

    public void setDescMovie(String descMovie) {
        this.descMovie = descMovie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulMovie);
        dest.writeInt(this.posterMovie);
        dest.writeString(this.jadwalMovie);
        dest.writeString(this.rateMovie);
        dest.writeString(this.descMovie);
    }

    public MovieModel() {
    }

    protected MovieModel(Parcel in) {
        this.judulMovie = in.readString();
        this.posterMovie = in.readInt();
        this.jadwalMovie = in.readString();
        this.rateMovie = in.readString();
        this.descMovie = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
