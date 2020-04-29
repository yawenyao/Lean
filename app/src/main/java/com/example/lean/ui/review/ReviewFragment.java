package com.example.lean.ui.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lean.R;

public class ReviewFragment extends Fragment {

    Button buttonnewwords, buttonwordsdatabase;
    private ReviewViewModel mViewModel;

    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_fragment, container, false);
        buttonnewwords = view.findViewById(R.id.buttonnewwords);
        buttonwordsdatabase = view.findViewById(R.id.buttoncreatewordsdatabase);
        buttonnewwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewWordsActivity.class);
                startActivity(intent);
            }
        });
        buttonwordsdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_reviewFragment_to_creatWordsDatebaseFragment);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
        // TODO: Use the ViewModel
    }

}
