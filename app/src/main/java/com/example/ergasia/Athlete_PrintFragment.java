package com.example.ergasia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Athlete_PrintFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Athlete_PrintFragment extends Fragment {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView queryText,queryResult;
    Button print;
    int test;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Athlete_PrintFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Athlete_PrintFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Athlete_PrintFragment newInstance(String param1, String param2) {
        Athlete_PrintFragment fragment = new Athlete_PrintFragment();
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
        View view = inflater.inflate(R.layout.fragment_athlete__print, container, false);

        final String[] queryArray = getResources().getStringArray(R.array.query_description_array);
        queryText = view.findViewById(R.id.textQuery);
        spinner = view.findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queryText.setText(queryArray[position]);
                test = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        queryResult = view.findViewById(R.id.textQueryResult);
        print= view.findViewById(R.id.button);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryResult.setText("test" + test);
                String result = " ";
                switch (test){
                    case 1:
                        List<AthletePin> athletePins = MainActivity.myDatabase.Daotemp().getAthlete();
                        for(AthletePin i : athletePins){
                            int code = i.getId();
                            String name = i.getName();
                            String last_name = i.getLast_name();
                            String city = i.getCity();
                            String country = i.getCountry_athlete();
                            int sport_code = i.getSport_code();
                            int year_birth = i.getYear_of_birth();
                            result = result + "\n ID: "+code+"\n Name: "+name+"\n Last Name: " +last_name+"\n City: "+city+"\n Country: "+country+
                                    "\n Sport's Code: "+sport_code+"\n Year of birth: "+year_birth+"\n";

                        }
                        queryResult.setText(result);
                        break;

                    case 2:

                        List<SportPin> sportPins = MainActivity.myDatabase.Daotemp().getSport();
                        for(SportPin i : sportPins){
                            int code = i.getId();
                            String name = i.getName();
                            String type = i.getKind_sport();
                            String ply = i.getPly_sport();

                            result = result + "\n ID: "+code+"\n Name: "+name+"\n Type: " +type+"\n Ply: "+ply+"\n";

                        }
                        queryResult.setText(result);
                        break;

                    case 3:

                        List<TeamPin> teamPins = MainActivity.myDatabase.Daotemp().getTeam();
                        for(TeamPin i : teamPins){
                            int code = i.getId();
                            String name = i.getName();
                            String stadium_name = i.getStadium_name();
                            String city = i.getCity();
                            String country = i.getCountry_team();
                            int sport_code = i.getSport_code();
                            int year_birth = i.getYear_of_birth();
                            result = result + "\n ID: "+code+"\n Name: "+name+"\n Last Name: " +stadium_name+"\n City: "+city+"\n Country: "+country+
                                    "\n Sport's Code: "+sport_code+"\n Year of birth: "+year_birth+"\n";

                        }
                        queryResult.setText(result);
                        break;
                }
            }
        });

        return view;
    }
}