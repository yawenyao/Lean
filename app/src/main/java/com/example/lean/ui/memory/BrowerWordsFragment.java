package com.example.lean.ui.memory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.lean.R;
import com.example.lean.data.WordDao;
import com.example.lean.data.WordsDatabase;
import com.example.lean.databinding.FragmentBrowerWordsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrowerWordsFragment extends Fragment {
    FragmentBrowerWordsBinding fragmentBrowerWordsBinding;
    WordsDatabase wordsDatabase;
    WordDao wordDao;

    public BrowerWordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brower_words, container, false);
        String url = "https://cdn.pixabay.com/photo/2018/05/02/13/19/apple-tree-3368589_150.jpg";
        //RequestQueue queue = Volley.newRequestQueue(this);

        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .optionalFitCenter()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(fragmentBrowerWordsBinding.imageView4);

        return view;
    }
}