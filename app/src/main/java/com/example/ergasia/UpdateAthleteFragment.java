package com.example.ergasia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ergasia.ui.insert.InsertFragment;
import com.example.ergasia.ui.update.UpdateFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateAthleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAthleteFragment extends Fragment {

    EditText name,id,last_name,city,country,birth,sport_code;
    Button update,back;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateAthleteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAthleteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAthleteFragment newInstance(String param1, String param2) {
        UpdateAthleteFragment fragment = new UpdateAthleteFragment();
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
        View view=  inflater.inflate(R.layout.fragment_update_athlete, container, false);

        id=view.findViewById(R.id.editTextCodeAthlete);
        name=view.findViewById(R.id.editTextFirstName);
        last_name=view.findViewById(R.id.editTextLastName);
        birth=view.findViewById(R.id.editTextYearAthleteBirth);
        city=view.findViewById(R.id.editTextCity);
        country=view.findViewById(R.id.editTextAthleteCountry);
        sport_code=view.findViewById(R.id.editTextAthleteSportsCode);

        update = view.findViewById(R.id.button_athlete_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_athleteid=0;
                try{
                    var_athleteid = Integer.parseInt(id.getText().toString());
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
                String var_last_name=last_name.getText().toString();
                String var_city=city.getText().toString();
                String var_country=country.getText().toString();

                try{
                AthletePin athletePin =new AthletePin();
                athletePin.setId(var_athleteid);
                athletePin.setName(var_name);
                athletePin.setCity(var_city);
                athletePin.setCountry_athlete(var_country);
                athletePin.setSport_code(var_sportcode);
                athletePin.setLast_name(var_last_name);
                athletePin.setYear_of_birth(var_birth);
                MainActivity.myDatabase.Daotemp().updateAthlete(athletePin);
                    Toast.makeText(getActivity(), "Athlete updated!", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                id.setText("");
                name.setText("");
                last_name.setText("");
                birth.setText("");
                city.setText("");
                country.setText("");
                sport_code.setText("");

            }
        });
        back = view.findViewById(R.id.backUpAthlete);
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