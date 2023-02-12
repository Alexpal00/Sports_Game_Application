package com.example.ergasia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateOmadikoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateOmadikoFragment extends Fragment {
    TextView id,code;

    Button insert,back;
    EditText Team1,scoreteam1,Team2,scoreteam2,textViewDate,city,country,eidos,sport;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateOmadikoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateOmadikoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateOmadikoFragment newInstance(String param1, String param2) {
        UpdateOmadikoFragment fragment = new UpdateOmadikoFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_omadiko, container, false);
        textViewDate=view.findViewById(R.id.textViewDate);
        city = view.findViewById(R.id.textViewCity);
        country = view.findViewById(R.id.textViewCountry);
        code=view.findViewById(R.id.editTextTextPersonName11);
        Team1 = view.findViewById(R.id.editTextTextPersonName9);
        scoreteam1=view.findViewById(R.id.editTextNumber);
        Team2=view.findViewById(R.id.editTextTextPersonName10);
        scoreteam2 = view.findViewById(R.id.editTextNumber2);
        sport = view.findViewById(R.id.textView2);



        Bundle bundle = this.getArguments();
        int id2 = bundle.getInt("id");

        int var_gameid=0;
        try{
            var_gameid = Integer.parseInt(String.valueOf(id2));
        }catch (NumberFormatException ex){
            System.out.println("Could not parse "+ex);
        }


        GamesPin gamesPin =new GamesPin();

        CollectionReference collectionRef = MainActivity.db.collection("Games");
        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result2 = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    GamesPin gamesPin = documentSnapshot.toObject(GamesPin.class);


                    Integer id = gamesPin.getId();
                    if (id2 == id) {


                        String Date = gamesPin.getDate();
                        String City = gamesPin.getCity();
                        String Country = gamesPin.getCountry();
                        String Eidos = gamesPin.getEidos();
                        String Sport = gamesPin.getSport();
                        String team1 = gamesPin.getTeam1();
                        String team2 = gamesPin.getTeam2();
                        Integer score1 = gamesPin.getScoreTeam1();
                        Integer score2 = gamesPin.getScoreTeam2();

                        String var_score1 = "";
                        try {
                            var_score1 = String.valueOf(score1);
                        } catch (NumberFormatException ex) {
                            System.out.println("Could not parse " + ex);
                        }

                        String var_score2 = "";
                        try {
                            var_score2 = String.valueOf(score2);
                        } catch (NumberFormatException ex) {
                            System.out.println("Could not parse " + ex);
                        }

                        String var_id2 = "";
                        try {
                            var_id2 = String.valueOf(id);
                        } catch (NumberFormatException ex) {
                            System.out.println("Could not parse " + ex);
                        }

                        city.setText(City);
                        textViewDate.setText(Date);
                        country.setText(Country);
                        Team1.setText(team1);
                        Team2.setText(team2);
                        scoreteam1.setText(var_score1);
                        scoreteam2.setText(var_score2);
                        code.setText(var_id2);
                        sport.setText(Sport);


                    } else {
                        Toast.makeText(getActivity(),"Ο ΚΩΔΙΚΟΣ ΔΕΝ ΥΠΑΡΧΕΙ",Toast.LENGTH_LONG);

                        String Date = "";
                        String City = "";
                        String Country = "";
                        String Eidos = "";
                        String Sport = "";
                        String team1 = "";
                        String team2 = "";
                        Integer score1 = null;
                        Integer score2 = null;
                    }
                }
            }
        });



        insert = view.findViewById(R.id.button2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    String strcity = city.getText().toString();
                    String strdate = textViewDate.getText().toString();
                    String strcountry = country.getText().toString();
                    String strdat = textViewDate.getText().toString();
                    String name1 = Team1.getText().toString();
                    String name2 = Team2.getText().toString();
                    String Sport = sport.getText().toString();

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




                    GamesPin gamesPin = new GamesPin();
                    gamesPin.setId(id2);
                    gamesPin.setDate(strdate);
                    gamesPin.setCity(strcity);
                    gamesPin.setCountry(strcountry);
                    gamesPin.setEidos("OMADIKO");
                    gamesPin.setSport(Sport);
                    gamesPin.setTeam1(name1);
                    gamesPin.setTeam2(name2);
                    gamesPin.setScoreTeam1(score1);
                    gamesPin.setScoreTeam2(score2);
                    MainActivity.db.collection("Games").document(""+id2).set(gamesPin)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "GAME UPDATED",Toast.LENGTH_LONG).show();
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

        back = view.findViewById(R.id.back_update_omadiko);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateGamesFragment updateGamesFragment = new UpdateGamesFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateGamesFragment,
                        updateGamesFragment.getTag()).addToBackStack(null).commit();

            }
        });



        return view;
    }
}