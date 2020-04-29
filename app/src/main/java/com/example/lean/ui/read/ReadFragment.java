package com.example.lean.ui.read;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.lean.R;
import com.example.lean.data.JournalDao;
import com.example.lean.data.Journals;
import com.example.lean.data.JournalsDatabase;

import java.util.List;

public class ReadFragment extends Fragment {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    JournalsDatabase journalsDatabase;
    JournalDao journalDao;
    private ReadViewModel readViewModel;

    public static ReadFragment newInstance() {
        return new ReadFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.read_fragment, container, false);
        journalsDatabase = Room.databaseBuilder(getContext(), JournalsDatabase.class, "journals_database")
                .allowMainThreadQueries()
                .build();
        journalDao = journalsDatabase.getJournalsDao();
        for (int i = 0; i < 20; i++) {
            Journals journals = new Journals("haonano" + i);
            journalDao.insertNewJournals(journals);
        }
        List<Journals> journals = journalDao.getAllJournals();
        myAdapter = new MyAdapter(journals);
        recyclerView = view.findViewById(R.id.recycleviewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //readViewModel = ViewModelProviders.of(this).get(ReadViewModel.class);
        readViewModel = new ViewModelProvider(this).get(ReadViewModel.class);
        // TODO: Use the ViewModel

    }

}
