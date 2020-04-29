package com.example.lean.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Words {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_words")
    private String words;
    @ColumnInfo(name = "chinese_meaning")
    private String chineseMeaning;
//    @Ignore
//    private Bitmap picture;


    public Words(String words, String chineseMeaning) {
        this.words = words;
        this.chineseMeaning = chineseMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getChineseMeaning() {
        return chineseMeaning;
    }

    public void setChineseMeaning(String chineseMeaning) {
        this.chineseMeaning = chineseMeaning;
    }

}
