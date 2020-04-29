package com.example.lean.ui.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.lean.R;
import com.example.lean.data.WordDao;
import com.example.lean.data.Words;
import com.example.lean.data.WordsDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatWordsDatebaseFragment extends Fragment {
    RadioGroup radioGroup;
    WordsDatabase wordsDatabase;
    WordDao wordDao;

    public CreatWordsDatebaseFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creat_words_datebase, container, false);
        radioGroup = view.findViewById(R.id.radiogroup);
        wordsDatabase = Room.databaseBuilder(getContext(), WordsDatabase.class, "words_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordsDatabase.getWordDao();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    for (int i = 0; i < 10; i++) {
                        Words words = new Words("apple" + i, "苹果" + i);
                        wordDao.insertNewWords(words);
                    }
                } else if (checkedId == R.id.radioButton2) {
                    for (int i = 0; i < 10; i++) {
                        Words words = new Words("pear" + i, "梨" + i);
                        wordDao.insertNewWords(words);
                    }
                }
            }

        });
        return view;
    }
}