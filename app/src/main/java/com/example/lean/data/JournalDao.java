package com.example.lean.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JournalDao {
    @Insert
    void insertNewJournals(Journals... journals);

    @Update
    void updateJournals(Journals... journals);

    @Delete
    void deleteJournals(Journals... journals);

    @Query("SELECT * FROM journals ORDER BY ID DESC")
    List<Journals> getAllJournals();
}
