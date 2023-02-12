package com.example.ergasia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ergasia.ui.delete.DeleteFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteGameFragment extends Fragment {
    EditText code;
    Button delete,back;
    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;
    int itemPos=0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteOmadikoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteGameFragment newInstance(String param1, String param2) {
        DeleteGameFragment fragment = new DeleteGameFragment();
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
        View view = inflater.inflate(R.layout.fragment_delete_game, container, false);

        spinner = view.findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.eidos_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemPos=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        code = view.findViewById(R.id.editTextCodegameDel);
        delete=view.findViewById(R.id.buttonDeleteGame);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(itemPos==0){

                    int var_gameid=0;
                    try{
                        var_gameid = Integer.parseInt(code.getText().toString());
                    }
                    catch (NumberFormatException ex){
                        System.out.println("Could not parse "+ex);
                    }

                    try{
                        AtomikoGames atomikoGames = new AtomikoGames();
                        atomikoGames.setId(var_gameid);

                         MainActivity.db.collection("Atomiko").document("" + var_gameid).delete().addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "This Code Does Not Exist",Toast.LENGTH_LONG).show();
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getActivity(), "Game Deleted",Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                    catch (Exception e){
                        String message = e.getMessage();
                        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                    }
                    code.setText("");

                }else if(itemPos==1) {

                    int var_gameid=0;
                    try{
                        var_gameid = Integer.parseInt(code.getText().toString());
                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse "+ex);
                    }

                    try{
                        GamesPin gamesPin = new GamesPin();
                        gamesPin.setId(var_gameid);
                        MainActivity.db.collection("Games").document(""+var_gameid).delete();
                        Toast.makeText(getActivity(), "Game with code " + var_gameid + " Deleted",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e){
                        String message = e.getMessage();
                        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                    }
                    code.setText("");

                }
                }

        });



        back = view.findViewById(R.id.backDelGame);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeleteFragment deleteFragment = new DeleteFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, deleteFragment,
                        deleteFragment.getTag()).addToBackStack(null).commit();

            }
        });

        return view;

    }


}