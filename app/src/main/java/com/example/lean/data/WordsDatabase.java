package com.example.lean.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Words.class,NewWords.class}, version = 2, exportSchema = false)
public abstract class WordsDatabase extends RoomDatabase {
    private static WordsDatabase INSTANCE;//创建单例
    private static RoomDatabase.Callback sOnOpenCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static WordsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordsDatabase.class, "word_database")
                            .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WordDao getWordDao();
    public abstract NewWordsDao getNewWordDao();

}

