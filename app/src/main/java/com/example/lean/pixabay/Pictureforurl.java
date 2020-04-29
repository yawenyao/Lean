package com.example.lean.pixabay;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pictureforurl {
    public int total;
    public int totleHits;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotleHits() {
        return totleHits;
    }

    public void setTotleHits(int totleHits) {
        this.totleHits = totleHits;
    }

    public ArrayList<PhotoItem> getHits() {
        return hits;
    }

    public void setHits(ArrayList<PhotoItem> hits) {
        this.hits = hits;
    }

    ArrayList<PhotoItem> hits;

    public Pictureforurl() {
    }

}

