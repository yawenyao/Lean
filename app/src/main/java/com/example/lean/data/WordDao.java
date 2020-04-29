package com.example.lean.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertNewWords(Words... words);

    @Update
    void updateWords(Words... words);

    @Delete
    void deleteWords(Words... words);

    @Query("SELECT * FROM words ORDER BY ID DESC")
    List<Words> getAllWords();

    @Query("SELECT * FROM words ORDER BY ID DESC")
    LiveData<List<Words>> getAllWordsLive();
}
