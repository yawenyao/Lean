package com.example.lean.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewWordsDao {


    @Insert
    void insertNewWords(NewWords... newwords);

    @Update
    void updateWords(NewWords... newwords);

    @Delete
    void deleteWords(NewWords... newwords);

    @Query("SELECT * FROM newwords ")
    List<NewWords>getAllNewWords();
    @Query( "SELECT * FROM newwords WHERE words_nova  =:words")
    List<NewWords>wordsexist(String words);
}
