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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateAtomikoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAtomikoFragment extends Fragment implements View.OnClickListener {
    LinearLayout layoutlist;
    List<String> tags,tags2;
    int i=0;
    TextView id,code;
    int id2;
    String City;
    String Country;
    String Sport;
    String Code;
    String Date;
    String Eidos;
    Button insert,add,back;
    EditText textViewDate,city,country,eidos,sport;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateAtomikoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAtomikoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAtomikoFragment newInstance(String param1, String param2) {
        UpdateAtomikoFragment fragment = new UpdateAtomikoFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_atomiko, container, false);

        textViewDate=view.findViewById(R.id.editTextTextPersonName12);
        city = view.findViewById(R.id.editTextTextPersonName13);
        country = view.findViewById(R.id.editTextTextPersonName14);
        code=view.findViewById(R.id.CODE);
        sport = view.findViewById(R.id.editTextTextPersonName8);
        insert=view.findViewById(R.id.buttonInertGame);
        add=view.findViewById(R.id.add);
        layoutlist = view.findViewById(R.id.layout_list);

        insert.setOnClickListener(this);
        add.setOnClickListener(this);

        Bundle bundle = this.getArguments();

         id2 = bundle.getInt("id3");

        AtomikoGames atomikoGames =new AtomikoGames();

        CollectionReference collectionRef = MainActivity.db.collection("Atomiko");
        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result2 = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    AtomikoGames atomikoGames = documentSnapshot.toObject(AtomikoGames.class);

                    Integer id = atomikoGames.getId();
                    if (id2 == id) {


                        Date = atomikoGames.getDate();
                        City = atomikoGames.getCity();
                        Country = atomikoGames.getCountry();
                        Eidos = atomikoGames.getEidos();
                        Sport = atomikoGames.getSport();

                        String var_id2 = "";
                        try {
                            var_id2 = String.valueOf(id);
                        } catch (NumberFormatException ex) {
                            System.out.println("Could not parse " + ex);
                        }

                        city.setText(City);
                        textViewDate.setText(Date);
                        country.setText(Country);
                        code.setText(var_id2);
                        sport.setText(Sport);

                    } else {
                        Toast.makeText(getActivity(),"Ο ΚΩΔΙΚΟΣ ΔΕΝ ΥΠΑΡΧΕΙ",Toast.LENGTH_LONG);
                        System.out.println("DATE: ");
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
        back = view.findViewById(R.id.back_update_atomiko);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.add:
                i = i+1;
                addView();
                break;
            case R.id.buttonInertGame:

                if(checkIfValidAndRead()){

                    try{

                        AtomikoGames atomikoGames = new AtomikoGames();
                        atomikoGames.setId(id2);
                        atomikoGames.setDate(Date);
                        atomikoGames.setCity(City);
                        atomikoGames.setCountry(Country);
                        atomikoGames.setEidos("ATOMIKO");
                        atomikoGames.setSport(Sport);
                        atomikoGames.setName(tags);
                        atomikoGames.setScore(tags2);


                        MainActivity.db.collection("Atomiko").document(""+id2).set(atomikoGames)
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

                break;
                }


    }

    private boolean checkIfValidAndRead() {

        boolean result = true;
        String[] tagArray=null;
        int n =0;
        int y =0;
        String[] tagArray2 =null;
        String tagInput ="";
        String tagInput2 ="";
        for(int i=0;i<layoutlist.getChildCount();i++){
            View cricketerView = layoutlist.getChildAt(i);
            EditText editTextName = (EditText) cricketerView.findViewById(R.id.editTextTextPersonName);
            EditText editTextName2 = (EditText) cricketerView.findViewById(R.id.editTextTextPersonName2);

            if(!(editTextName.getText().toString().equals(""))){
                n=n+1;

                tagInput =editTextName.getText().toString() +" , " + tagInput;

            }else{
                result = false;
            }
            if(!(editTextName2.getText().toString().equals(""))){
                y=y+1;
                tagInput2 = editTextName2.getText().toString()+" , "+tagInput2;

            }
            else{
                result = false;
                break;
            }

        }
        tagArray = tagInput.split("\\s* , \\s*");

        tags = Arrays.asList(tagArray);

        tagArray2 = tagInput2.split("\\s* , \\s*");

        tags2 = Arrays.asList(tagArray2);

        if(n==0 && y==0){

            result =false;
            Toast.makeText(getActivity(),"Add Athlete first!",Toast.LENGTH_SHORT).show();

        }else if(!result){

            Toast.makeText(getActivity(),"Enter All Details Correctly!",Toast.LENGTH_SHORT).show();
        }
        return result;

    }
    private void addView() {

        final View cricketerView = getLayoutInflater().inflate(R.layout.add_athlete, null, false);

        EditText editText = (EditText) cricketerView.findViewById(R.id.editTextTextPersonName);
        EditText editText2 = (EditText) cricketerView.findViewById(R.id.editTextTextPersonName2);
        ImageView imageClose = (ImageView) cricketerView.findViewById(R.id.imageView2);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(cricketerView);
            }
        });
        layoutlist.addView(cricketerView);
    }
    private void removeView(View view){
        layoutlist.removeView(view);
    }
}
