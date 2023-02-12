package com.example.ergasia.ui.insert;
import android.annotation.SuppressLint;
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

import com.example.ergasia.InsertGameFragment;
import com.example.ergasia.R;
import com.example.ergasia.AthleteInsertFragment;
import com.example.ergasia.SportInsertFragment;
import com.example.ergasia.TeamInsertFragment;
import com.example.ergasia.databinding.FragmentHomeBinding;



public class InsertFragment extends Fragment {

    private Button athlete;
    Button sport,games;
    Button team;
    private InsertViewModel galleryViewModel;
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       galleryViewModel =
                new ViewModelProvider(this).get(InsertViewModel.class);

        View root = inflater.inflate(R.layout.fragment_insert, container, false);


        team = (Button) root.findViewById(R.id.buttonTeam);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamInsertFragment teamInsertFragment = new TeamInsertFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, teamInsertFragment,
                       teamInsertFragment.getTag()).addToBackStack(null).commit();

            }
        });

        sport = (Button) root.findViewById(R.id.buttonSport);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportInsertFragment sportInsertFragment = new SportInsertFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, sportInsertFragment,
                        sportInsertFragment.getTag()).addToBackStack(null).commit();
            }
        });


        athlete = (Button) root.findViewById(R.id.buttonAthlete);
        athlete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AthleteInsertFragment athleteInsertFragment = new AthleteInsertFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, athleteInsertFragment,
                        athleteInsertFragment.getTag()).addToBackStack(null).commit();
            }
        });



        final TextView textView = root.findViewById(R.id.text_insert);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });

        games = (Button) root.findViewById(R.id.buttonInsertGame);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertGameFragment insertGameFragment = new InsertGameFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, insertGameFragment,
                        insertGameFragment.getTag()).addToBackStack(null).commit();
            }
        });


        return root;


    }



}
