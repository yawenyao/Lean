package com.example.lean.ui.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lean.R;
import com.example.lean.data.NewWords;
import com.example.lean.data.Words;

import java.util.ArrayList;
import java.util.List;

public class NewWordsAdapter extends RecyclerView.Adapter<NewWordsAdapter.MyViewHolder> {

    List<NewWords> allnewwords = new ArrayList<>();
    boolean a;

    public NewWordsAdapter(List<NewWords>allnewwords, boolean a) {
        this.allnewwords = allnewwords;
        this.a = a;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview1, itemview2;
        itemview1 = layoutInflater.inflate(R.layout.cardview_new_words, parent, false);
        itemview2 = layoutInflater.inflate(R.layout.cardviewnewwords2, parent, false);
        if (a) {
            return new MyViewHolder(itemview1);
        } else
            return new MyViewHolder(itemview2);
    }

    @Override
    //负责将每个子项holder绑定数据。
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewWords newwords = allnewwords.get(position);
        holder.textView_words.setText(newwords.getWords_nava());
        holder.textView_chinesemeaning.setText(newwords.getChinese_nava());
    }

    @Override
    public int getItemCount() {
        return allnewwords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_words, textView_chinesemeaning;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_words = itemView.findViewById(R.id.textView_words);
            textView_chinesemeaning = itemView.findViewById(R.id.textView_chinesemeaning);

        }
    }
}
