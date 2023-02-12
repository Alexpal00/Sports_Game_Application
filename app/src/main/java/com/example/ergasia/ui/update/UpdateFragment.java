package com.example.ergasia.ui.update;

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
import com.example.ergasia.R;
import com.example.ergasia.SportInsertFragment;
import com.example.ergasia.TeamInsertFragment;
import com.example.ergasia.UpdateAthleteFragment;
import com.example.ergasia.UpdateGamesFragment;
import com.example.ergasia.UpdateSportFragment;
import com.example.ergasia.UpdateTeamFragment;

public class UpdateFragment extends Fragment {

    private UpdateViewModel updateViewModel;

    Button team,athlete,sport,games;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        updateViewModel =
                new ViewModelProvider(this).get(UpdateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_update, container, false);
        final TextView textView = root.findViewById(R.id.text_update);
        updateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        team = (Button) root.findViewById(R.id.update_team);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateTeamFragment updateTeamFragment = new UpdateTeamFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateTeamFragment,
                        updateTeamFragment.getTag()).addToBackStack(null).commit();

            }
        });

        sport = (Button) root.findViewById(R.id.update_sport);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateSportFragment updateSportFragment = new UpdateSportFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateSportFragment,
                        updateSportFragment.getTag()).addToBackStack(null).commit();
            }
        });


        athlete = (Button) root.findViewById(R.id.update_athlete);
        athlete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateAthleteFragment updateAthleteFragment = new UpdateAthleteFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateAthleteFragment,
                        updateAthleteFragment.getTag()).addToBackStack(null).commit();
            }
        });

        games=root.findViewById(R.id.buttonUpdateGame);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateGamesFragment updateGamesFragment = new UpdateGamesFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateGamesFragment,
                        updateGamesFragment.getTag()).addToBackStack(null).commit();
            }
        });


        return root;
    }

}