package com.example.lean.ui.read;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lean.R;
import com.example.lean.data.JournalDao;
import com.example.lean.data.Journals;
import com.example.lean.data.JournalsDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    JournalsDatabase journalsDatabase;
    JournalDao journalDao;
    List<Journals> alljournals = new ArrayList<>();

    public MyAdapter(List<Journals> journals) {
        this.alljournals = journals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.cardview_subject, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Journals journals = alljournals.get(position);
        holder.textViewId.setText(String.valueOf(journals.getId()));
        holder.textViewSubject.setText(journals.getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_readFragment_to_journalsFragment);
            }
        });


    }

    @Override
    public int getItemCount() {
        return alljournals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSubject, textViewId;
        ImageView imageViewSubjectImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewID);
            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            imageViewSubjectImage = itemView.findViewById(R.id.imageViewSubjectImage);
        }
    }
}
