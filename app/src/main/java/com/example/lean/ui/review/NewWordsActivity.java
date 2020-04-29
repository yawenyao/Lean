package com.example.lean.ui.review;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.lean.R;
import com.example.lean.data.NewWords;
import com.example.lean.data.NewWordsDao;
import com.example.lean.data.WordDao;
import com.example.lean.data.Words;
import com.example.lean.data.WordsDatabase;

import java.util.List;

public class NewWordsActivity extends AppCompatActivity {
    WordsDatabase wordsDatabase;
    WordDao wordDao;
    NewWordsDao newwordDao;
    RecyclerView recyclerView;
    NewWordsAdapter newWordsAdapter, newWordsAdapter2;
    Switch aSwitch;
    boolean b;
    TextView textViewwordscount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_words);
        aSwitch = findViewById(R.id.switchShowOrHint);
        textViewwordscount = findViewById(R.id.textViewWordsCount);


        wordsDatabase = Room.databaseBuilder(NewWordsActivity.this, WordsDatabase.class, "words_database")
                .allowMainThreadQueries()
                .build();
        newwordDao = wordsDatabase.getNewWordDao();
        final List<NewWords> allNewWords = newwordDao.getAllNewWords();
        int wordsCount = allNewWords.size();

        textViewwordscount.setText("共计："+wordsCount+"个单词");
        recyclerView = findViewById(R.id.recycleviewNewwords);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        newWordsAdapter = new NewWordsAdapter(allNewWords, false);
        newWordsAdapter2 = new NewWordsAdapter(allNewWords, true);
        recyclerView.setAdapter(newWordsAdapter2);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    recyclerView.setAdapter(newWordsAdapter2);
                } else {
                    recyclerView.setAdapter(newWordsAdapter);

                }
            }
        });

        recyclerView.refreshDrawableState();
    }
}
