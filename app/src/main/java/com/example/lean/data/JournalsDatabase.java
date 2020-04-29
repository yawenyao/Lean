package com.example.lean.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Journals.class}, version = 1, exportSchema = false)
public abstract class JournalsDatabase extends RoomDatabase {
    private static JournalsDatabase INSTANCE;//创建单例
    private static RoomDatabase.Callback sOnOpenCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static JournalsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (JournalsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            JournalsDatabase.class, "journals_database")
                            .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract JournalDao getJournalsDao();
}
