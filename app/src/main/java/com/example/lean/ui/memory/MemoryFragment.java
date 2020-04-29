package com.example.lean.ui.memory;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.lean.R;
import com.example.lean.data.WordsDatabase;
import com.example.lean.databinding.MemoryFragmentBinding;

public class MemoryFragment extends Fragment {

    MemoryFragmentBinding memoryFragmentBinding;
    WordsDatabase wordsDatabase;
    private MemoryViewModel memoryViewModel;
    private ImageButton imageButtonSearch;
    private EditText editTextSearch;
    private Button buttonStartMemory;
    private Context context;

    public static MemoryFragment newInstance() {
        return new MemoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.memory_fragment, container, false);
        imageButtonSearch = view.findViewById(R.id.imageButtonSearch);
        editTextSearch = view.findViewById(R.id.editTextSearch);
        buttonStartMemory = view.findViewById(R.id.buttonStartMemory);

        buttonStartMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DistinguishActivity.class);
                startActivity(intent);
            }
        });
        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StringBuffer string = new StringBuffer(editTextSearch.getText().toString().trim());
                System.out.println("shurude :" + string);
                if (string.length() == 0) {
                    Toast toast = Toast.makeText(getActivity(), "请输入要查询的单词!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Uri uri = Uri.parse("http://m.youdao.com/dict?le=eng&q=" + string);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    startActivity(intent);
                }
                editTextSearch.setText("");
            }

        });
        return view;
        //wordsDatabase = Room.databaseBuilder(,WordsDatabase.class,"words_database");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        memoryViewModel = ViewModelProviders.of(this).get(MemoryViewModel.class);
        // TODO: Use the ViewModel
    }

}
