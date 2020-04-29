package com.example.lean.ui.memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.example.lean.R;
import com.example.lean.data.WordDao;
import com.example.lean.data.Words;
import com.example.lean.data.WordsDatabase;
import com.example.lean.databinding.ActivityDistinguishBinding;

import java.util.List;

public class DistinguishActivity extends AppCompatActivity {
    static int i = 0;
    ActivityDistinguishBinding activityDistinguishBinding;
    WordsDatabase wordsDatabase;
    WordDao wordDao;
    TextView textView_left;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView_left = findViewById(R.id.textViewwords_left);
        wordsDatabase = Room.databaseBuilder(DistinguishActivity.this, WordsDatabase.class, "words_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordsDatabase.getWordDao();
        final List<Words> allWords = wordDao.getAllWords();
        activityDistinguishBinding = DataBindingUtil.setContentView(this, R.layout.activity_distinguish);


        if (!(allWords.isEmpty())) {
            activityDistinguishBinding.textViewWordsDistinguish.setText(allWords.get(i).getWords());
            activityDistinguishBinding.textViewhint.setText(allWords.get(i).getChineseMeaning());

            activityDistinguishBinding.buttonkonw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (allWords.isEmpty()) {
                        Toast toast = Toast.makeText(DistinguishActivity.this, "请添加词库", Toast.LENGTH_SHORT);
                        toast.show();
                        finishActivity(0);
                    } else if (i == allWords.size() - 1) {
                        Toast toast = Toast.makeText(DistinguishActivity.this, "该词库已背完", Toast.LENGTH_SHORT);
                        toast.show();
                        i = 0;
                    }

                    activityDistinguishBinding.textViewWordsDistinguish.setText(allWords.get(i + 1).getWords());
                    activityDistinguishBinding.textViewhint.setText(allWords.get(i + 1).getChineseMeaning());
                    i++;
                    activityDistinguishBinding.textViewwordsLeft.setText("已学：" + i + "/" + allWords.size());
                }
            });
            activityDistinguishBinding.buttonnotclear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DistinguishActivity.this, DetailActivity.class);
                    intent.putExtra("Words", activityDistinguishBinding.textViewWordsDistinguish.getText());
                    intent.putExtra("ChineseMeaning", activityDistinguishBinding.textViewhint.getText());
                    startActivity(intent);

                }
            });
            activityDistinguishBinding.buttondonotknow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DistinguishActivity.this, DetailActivity.class);
                    intent.putExtra("Words", activityDistinguishBinding.textViewWordsDistinguish.getText());
                    intent.putExtra("ChineseMeaning",activityDistinguishBinding.textViewhint.getText());
                    startActivity(intent);

                }
            });
            activityDistinguishBinding.imageButtonvoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        } else {
            Toast toast = Toast.makeText(DistinguishActivity.this, "请添加词库", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }

}
