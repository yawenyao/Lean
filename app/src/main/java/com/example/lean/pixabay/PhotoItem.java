package com.example.lean.pixabay;

import com.google.gson.annotations.SerializedName;

public class PhotoItem {
    @SerializedName("webformatURL")
    String webformatURL;
    @SerializedName("id")
    int id;

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    @SerializedName("largeImageURL")
    String largeImageURL;
        public PhotoItem() {
        }
}
