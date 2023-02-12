package com.example.ergasia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ergasia.AthleteInsertFragment;
import com.example.ergasia.Athlete_PrintFragment;
import com.example.ergasia.AtomikoFragment;
import com.example.ergasia.GamesPrintFragment;
import com.example.ergasia.InsertGameFragment;
import com.example.ergasia.R;
import com.example.ergasia.ui.insert.InsertFragment;

public class HomeFragment extends Fragment {

    Button athlete;
    Button games;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        final TextView textView = root.findViewById(R.id.text_print);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        athlete = (Button) root.findViewById(R.id.button_Printathlete);
        athlete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Athlete_PrintFragment athlete_printFragment = new Athlete_PrintFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, athlete_printFragment,
                        athlete_printFragment.getTag()).addToBackStack(null).commit();
            }
        });

        games = (Button) root.findViewById(R.id.button_PrintGames);
        games.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GamesPrintFragment gamesPrintFragment = new GamesPrintFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, gamesPrintFragment,
                        gamesPrintFragment.getTag()).addToBackStack(null).commit();
            }
        });




        return root;
    }
}