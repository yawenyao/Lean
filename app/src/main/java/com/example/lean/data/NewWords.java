package com.example.lean.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NewWords {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "words_nova")
    private  String words_nava;

    public NewWords(String words_nava, String chinese_nava) {
        this.words_nava = words_nava;
        this.chinese_nava = chinese_nava;
    }


    public String getWords_nava() {
        return words_nava;
    }

    public void setWords_nava(String words_nava) {
        this.words_nava = words_nava;
    }

    public String getChinese_nava() {
        return chinese_nava;
    }

    public void setChinese_nava(String chinese_nava) {
        this.chinese_nava = chinese_nava;
    }

    @ColumnInfo(name = "chinese_nava")
    private String chinese_nava;
}
