package com.example.ergasia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ergasia.ui.update.UpdateFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateTeamFragment extends Fragment {

    EditText name,id,stadium_name,city,country,birth,sport_code;
    Button update,back;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateTeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateTeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateTeamFragment newInstance(String param1, String param2) {
        UpdateTeamFragment fragment = new UpdateTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_team, container, false);

        id=view.findViewById(R.id.editTextCodeTeam);
        name=view.findViewById(R.id.editTextTeamName);
        stadium_name=view.findViewById(R.id.editTextStadiumName);
        birth=view.findViewById(R.id.editTextYearTeamBirth);
        city=view.findViewById(R.id.editTextStadiumCity);
        country=view.findViewById(R.id.editTextStadiumCountry);
        sport_code=view.findViewById(R.id.editTextTeamSportsCode);

        update = view.findViewById(R.id.button_team_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_teamid=0;
                try{
                    var_teamid = Integer.parseInt(id.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }

                int var_birth=0;
                try{
                    var_birth = Integer.parseInt(birth.getText().toString());
                }
                catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }
                int var_sportcode=0;
                try{
                    var_sportcode = Integer.parseInt(sport_code.getText().toString());
                }
                catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }

                String var_name=name.getText().toString();
                String var_stadium_name=stadium_name.getText().toString();
                String var_city=city.getText().toString();
                String var_country=country.getText().toString();
                TeamPin teamPin =new TeamPin();
                teamPin.setId(var_teamid);
                teamPin.setName(var_name);
                teamPin.setCity(var_city);
                teamPin.setCountry_team(var_country);
                teamPin.setSport_code(var_sportcode);
                teamPin.setStadium_name(var_stadium_name);
                teamPin.setYear_of_birth(var_birth);
                MainActivity.myDatabase.Daotemp().updateTeam(teamPin);
                id.setText("");
                name.setText("");
                stadium_name.setText("");
                birth.setText("");
                city.setText("");
                country.setText("");
                sport_code.setText("");

            }
        });

        back = view.findViewById(R.id.backUpTeam);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateFragment updateFragment = new UpdateFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateFragment,
                        updateFragment.getTag()).addToBackStack(null).commit();

            }
        });

        return view;
    }
}