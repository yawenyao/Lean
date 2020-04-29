package com.example.lean.ui.memory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.lean.R;
import com.example.lean.data.NewWords;
import com.example.lean.data.NewWordsDao;
import com.example.lean.data.WordDao;
import com.example.lean.data.Words;
import com.example.lean.data.WordsDatabase;
import com.example.lean.databinding.ActivityDetailBinding;
import com.example.lean.volley.GetPhotoUrl;
import com.example.lean.volley.MyApplication;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding activityDetailBinding;
    WordsDatabase wordsDatabase;
    WordDao wordDao;
    NewWordsDao newwordDao;
    MyApplication myApplication;
    private String currentWords_chineseMeaning;


    public static String getWebUrl() {
        return webUrl;
    }

    private static String webUrl;

    private com.example.lean.databinding.ActivityDetailBinding activityDetailBinding1;
    public static RequestQueue queues;
    private String currentWords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        myApplication = new MyApplication();
        GetPhotoUrl getPhotoUrl = new GetPhotoUrl();
        String []motn ={"strive","study","morning","happy","sky","star","book","dog","cat","ocean"};
        int number = new Random().nextInt(10);
        String pic =motn[number];
        getPhotoUrl.volleyStringRequestGet();
        currentWords = getIntent().getStringExtra("Words");
        currentWords_chineseMeaning = getIntent().getStringExtra("ChineseMeaning");
        webUrl = "https://pixabay.com/api/?key=16248605-bb24e126ba329545755b3f3a6&q="+currentWords+"&image_type=photo&pretty=true";
        String url = getPhotoUrl.getPhotoUrl();
        System.out.println(currentWords+url+"5555555555555555555555555555555555555555555555555555555555555555555555555");


        activityDetailBinding1 = activityDetailBinding;
        activityDetailBinding1 = DataBindingUtil.setContentView(this, R.layout.activity_detail);


        activityDetailBinding1.textViewDetail.setText(currentWords);
        activityDetailBinding1.textViewChineseMeanningDetail.setText(currentWords_chineseMeaning);

        Glide.with(DetailActivity.this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .optionalFitCenter()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object
                            model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object
                            model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(activityDetailBinding1.imageView2);

        activityDetailBinding1.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        activityDetailBinding1.buttonAddToNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将单词添加至生词本
                wordsDatabase = Room.databaseBuilder(DetailActivity.this, WordsDatabase.class, "words_database")
                        .allowMainThreadQueries()
                        .build();
                newwordDao = wordsDatabase.getNewWordDao();
                NewWords newWords = new NewWords(currentWords, currentWords_chineseMeaning);
                List<NewWords>newWords1 = newwordDao.wordsexist(currentWords);
                if(newWords1.isEmpty()) {
                    newwordDao.insertNewWords(new NewWords(currentWords, currentWords_chineseMeaning));
                    Toast toast = Toast.makeText(DetailActivity.this,"添加成功",Toast.LENGTH_SHORT);
                    toast.show();
                }else
                {
                    Toast toast = Toast.makeText(DetailActivity.this,"该词汇已存在",Toast.LENGTH_SHORT);
                    toast.show();
                }
                finish();
            }
        });
    }
}

