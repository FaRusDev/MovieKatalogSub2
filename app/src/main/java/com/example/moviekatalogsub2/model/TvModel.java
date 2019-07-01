package com.example.moviekatalogsub2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvModel implements Parcelable {
    private String judulTv;
    private int posterTv;
    private String descTv;
    private String rateTv;

    public String getJudulTv() {
        return judulTv;
    }

    public void setJudulTv(String judulTv) {
        this.judulTv = judulTv;
    }

    public int getPosterTv() {
        return posterTv;
    }

    public void setPosterTv(int posterTv) {
        this.posterTv = posterTv;
    }

    public String getDescTv() {
        return descTv;
    }

    public void setDescTv(String descTv) {
        this.descTv = descTv;
    }

    public String getRateTv() {
        return rateTv;
    }

    public void setRateTv(String rateTv) {
        this.rateTv = rateTv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulTv);
        dest.writeInt(this.posterTv);
        dest.writeString(this.descTv);
        dest.writeString(this.rateTv);
    }

    public TvModel() {
    }

    protected TvModel(Parcel in) {
        this.judulTv = in.readString();
        this.posterTv = in.readInt();
        this.descTv = in.readString();
        this.rateTv = in.readString();
    }

    public static final Parcelable.Creator<TvModel> CREATOR = new Parcelable.Creator<TvModel>() {
        @Override
        public TvModel createFromParcel(Parcel source) {
            return new TvModel(source);
        }

        @Override
        public TvModel[] newArray(int size) {
            return new TvModel[size];
        }
    };
}
