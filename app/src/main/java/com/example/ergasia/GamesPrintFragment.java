package com.example.ergasia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GamesPrintFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesPrintFragment extends Fragment  {
    ArrayList<Cricketer> cricketers = new ArrayList<>();
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView queryText,queryResult;
    Button print,back;
    int test;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GamesPrintFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GamesPrintFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GamesPrintFragment newInstance(String param1, String param2) {
        GamesPrintFragment fragment = new GamesPrintFragment();
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
        View view = inflater.inflate(R.layout.fragment_games_print, container, false);

        final String[] queryArray = getResources().getStringArray(R.array.query_games_array);
        queryText = view.findViewById(R.id.textQuery);
        spinner = view.findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.eidos_array, R.layout.support_simple_spinner_dropdown_item);
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

                List<String> athletes;
                switch (test){
                    case 1:
                        CollectionReference collectionReference = MainActivity.db.collection("Atomiko");

                        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                int i =0;
                                int n = 0;

                                String result1 ="";
                                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots ){
                                    Cricketer cricketer =new Cricketer();

                                    AtomikoGames atomikoGames = documentSnapshot.toObject(AtomikoGames.class);
                                    Integer id = atomikoGames.getId();
                                    String Date = atomikoGames.getDate();
                                    String City = atomikoGames.getCity();
                                    String Country = atomikoGames.getCountry();
                                    String Eidos = atomikoGames.getEidos();
                                    String Sport = atomikoGames.getSport();
                                    for (String name : atomikoGames.getName()){
                                        i=i+1;
                                        result1 += "\nΟνομα αθλητη "+i+": " +name;
                                    }

                                    for (String score : atomikoGames.getScore()){
                                        n = n+1;
                                        result1 += "\nScore "+n+": " +score;
                                    }


                                    result1 +="\nΚΩΔΙΚΟΣ ΑΓΩΝΑ: "+id+"\nΗΜΕΡΟΜΗΝΙΑ ΑΓΩΝΑ: "+Date
                                            +"\nΠΟΛΗ ΔΙΕΞΑΓΩΓΗΣ ΑΓΩΝΑ: "+City+"\nΧΩΡΑ ΔΙΕΞΑΓΩΓΗΣ ΑΓΩΝΑ: "
                                            +
                                            Country+"\nΕΙΔΟΣ ΑΓΩΝΑ: "+Eidos+"\nΑΘΛΗΜΑ ΑΓΩΝΑ: "+Sport+"\n\n\n"
                                            ;
                                    queryResult.setText(result1);
                                    i=0;
                                    n=0;
                            }
                            }
                    });
                        break;
                    case 2:


                        CollectionReference collectionRef = MainActivity.db.collection("Games");
                        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                String result2 = "";
                                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots ){
                                    GamesPin gamesPin = documentSnapshot.toObject(GamesPin.class);
                                    Integer id = gamesPin.getId();
                                    String Date = gamesPin.getDate();
                                    String City = gamesPin.getCity();
                                    String Country = gamesPin.getCountry();
                                    String Eidos = gamesPin.getEidos();
                                    String Sport = gamesPin.getSport();
                                    String team1 = gamesPin.getTeam1();
                                    String team2 = gamesPin.getTeam2();
                                    Integer score1=gamesPin.getScoreTeam1();
                                    Integer score2 = gamesPin.getScoreTeam2();

                                    result2 +="ΚΩΔΙΚΟΣ ΑΓΩΝΑ: "+id+"\nΗΜΕΡΟΜΗΝΙΑ ΑΓΩΝΑ: "+Date
                                            +"\nΠΟΛΗ ΔΙΕΞΑΓΩΓΗΣ ΑΓΩΝΑ: "+City+"\nΧΩΡΑ ΔΙΕΞΑΓΩΓΗΣ ΑΓΩΝΑ: "
                                            +
                                            Country+"\nΕΙΔΟΣ ΑΓΩΝΑ: "+Eidos+"\nΑΘΛΗΜΑ ΑΓΩΝΑ: "+Sport+"\n"+team1+" "+score1+" - "+score2+" "+team2+"\n";

                                }
                                queryResult.setText(result2);
                            }
                        });
                        break;


                    default:

                }
            }
        });



        return view;

    }
}
