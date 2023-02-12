package com.example.ergasia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ergasia.ui.insert.InsertFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OmadikoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OmadikoFragment extends Fragment {

    TextView textViewDate,city,country,id;

    Button insert,back;
    EditText team1,scoreteam1,team2,scoreteam2;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OmadikoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OmadikoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OmadikoFragment newInstance(String param1, String param2) {
        OmadikoFragment fragment = new OmadikoFragment();
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
        View view =  inflater.inflate(R.layout.fragment_omadiko, container, false);

        textViewDate=view.findViewById(R.id.textViewDate);
        city = view.findViewById(R.id.textViewCity);
        country = view.findViewById(R.id.textViewCountry);
        id=view.findViewById(R.id.textView2);

        Bundle bundle = this.getArguments();
        String date = bundle.getString("date");

        textViewDate.setText(date);
        String Strcity;
        Strcity=bundle.getString("city");
        city.setText(Strcity);
        String StrCountry;
        StrCountry=bundle.getString("country");
        country.setText(StrCountry + ",");
        String sport;
        sport = bundle.getString("sport");
        String code;
        code = bundle.getString("id");
        id.setText("Κωδικος αγωνα: " +code);


        team1=view.findViewById(R.id.editTextTextPersonName9);
        scoreteam1=view.findViewById(R.id.editTextNumber);
        team2=view.findViewById(R.id.editTextTextPersonName10);
        scoreteam2 = view.findViewById(R.id.editTextNumber2);

        insert = view.findViewById(R.id.button2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int var_id=0;
                try{
                    var_id = Integer.parseInt(code.toString());
                }catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String name1 = team1.getText().toString();
                String name2 = team2.getText().toString();

                int score1=0;
                try{
                    score1 = Integer.parseInt((scoreteam1.getText().toString()));
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }
                int score2=0;
                try{
                    score2 = Integer.parseInt((scoreteam2.getText().toString()));
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }


                try{
                    GamesPin gamesPin = new GamesPin();
                    gamesPin.setId(var_id);
                    gamesPin.setDate(date);
                    gamesPin.setCity(Strcity);
                    gamesPin.setCountry(StrCountry);
                    gamesPin.setEidos("OMADIKO");
                    gamesPin.setSport(sport);
                    gamesPin.setTeam1(name1);
                    gamesPin.setTeam2(name2);
                    gamesPin.setScoreTeam1(score1);
                    gamesPin.setScoreTeam2(score2);
                    MainActivity.db.collection("Games").document(""+var_id).set(gamesPin)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "Game added",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "FAIL",Toast.LENGTH_LONG).show();
                        }
                    });



                }catch (Exception e){
                    String mess = e.getMessage();
                    Toast.makeText(getActivity(),mess,Toast.LENGTH_LONG).show();
                }




            }
        });










        back = view.findViewById(R.id.backOmadiko);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InsertGameFragment insertGameFragment = new InsertGameFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, insertGameFragment,
                        insertGameFragment.getTag()).addToBackStack(null).commit();

            }
        });












        return view;

    }
}