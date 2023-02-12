package com.example.ergasia.ui.delete;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ergasia.DeleteGameFragment;
import com.example.ergasia.Delete_AthleteFragment;
import com.example.ergasia.Delete_SportFragment;
import com.example.ergasia.Delete_teamFragment;
import com.example.ergasia.R;
import com.example.ergasia.AthleteInsertFragment;

public class DeleteFragment extends Fragment {

    private DeleteViewModel slideshowViewModel;
private Button athlete,team,sport,games;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(DeleteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_delete, container, false);

        athlete = (Button) root.findViewById(R.id.delete_athlete);
        athlete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_AthleteFragment delete_athleteFragment = new Delete_AthleteFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, delete_athleteFragment,
                        delete_athleteFragment.getTag()).addToBackStack(null).commit();
            }
        });

        team = (Button) root.findViewById(R.id.delete_team);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_teamFragment delete_teamFragment = new Delete_teamFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, delete_teamFragment,
                        delete_teamFragment.getTag()).addToBackStack(null).commit();
            }
        });

        sport = (Button) root.findViewById(R.id.delete_sport);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_SportFragment delete_sportFragment = new Delete_SportFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, delete_sportFragment,
                        delete_sportFragment.getTag()).addToBackStack(null).commit();
            }
        });

        games=root.findViewById(R.id.buttonDeleteGame);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteGameFragment deleteGameFragment = new DeleteGameFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, deleteGameFragment,
                        deleteGameFragment.getTag()).addToBackStack(null).commit();
            }
        });



        final TextView textView = root.findViewById(R.id.text_delete);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}