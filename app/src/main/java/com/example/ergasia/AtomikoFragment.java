package com.example.ergasia;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.ergasia.ui.insert.InsertFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtomikoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtomikoFragment extends Fragment implements View.OnClickListener  {
    LinearLayout layoutlist;
    List<String> tags,tags2;
    Button add,insert,back;
    int i=0;
    EditText edittext,city,country,eidos,id;


    String Strcity;
    String StrCountry;
    String sport;
    String code;
    String date;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AtomikoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtomikoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtomikoFragment newInstance(String param1, String param2) {
        AtomikoFragment fragment = new AtomikoFragment();
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
        View view = inflater.inflate(R.layout.fragment_atomiko, container, false);

        Bundle bundle = this.getArguments();

        date = bundle.getString("date2");
        Strcity=bundle.getString("city2");
        StrCountry=bundle.getString("country2");
        sport = bundle.getString("sport2");
        code = bundle.getString("id2");

        layoutlist = view.findViewById(R.id.layout_list);
        add = view.findViewById(R.id.add);
        insert = view.findViewById(R.id.buttonInertGame);

        insert.setOnClickListener(this);
        add.setOnClickListener(this);
        back = view.findViewById(R.id.backAtomiko);
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


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.add:
                i = i+1;
                addView();
                break;
            case R.id.buttonInertGame:

                if(checkIfValidAndRead()){

                    int var_id=0;
                    try{
                        var_id = Integer.parseInt(code.toString());
                    }catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    try{
                        AtomikoGames atomikoGames = new AtomikoGames();
                        atomikoGames.setId(var_id);
                        atomikoGames.setDate(date);
                        atomikoGames.setCity(Strcity);
                        atomikoGames.setCountry(StrCountry);
                        atomikoGames.setEidos("ATOMIKO");
                        atomikoGames.setSport(sport);

                        atomikoGames.setName(tags);
                        atomikoGames.setScore(tags2);

                        MainActivity.db.collection("Atomiko").document(""+var_id).set(atomikoGames)
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
            default:

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
            AtomikoGames atomikoGames = new AtomikoGames();
            Cricketer cricketer = new Cricketer();


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



