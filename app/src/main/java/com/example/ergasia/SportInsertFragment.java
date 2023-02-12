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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SportInsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportInsertFragment extends Fragment {

    EditText name,id,kind,ply;
    Button insert,back;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SportInsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportInsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SportInsertFragment newInstance(String param1, String param2) {
        SportInsertFragment fragment = new SportInsertFragment();
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
        View view = inflater.inflate(R.layout.fragment_sport_insert, container, false);

        id=view.findViewById(R.id.editTextCodeSport);
        name=view.findViewById(R.id.editTextSportName);
        kind=view.findViewById(R.id.editTextKind);
        ply=view.findViewById(R.id.editTextPly);


        insert = view.findViewById(R.id.button_sport_insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_sportid = 0;
                try {
                    var_sportid = Integer.parseInt(id.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String var_name=name.getText().toString();
                String var_kind=kind.getText().toString();
                String var_ply=ply.getText().toString();
                try{

                SportPin sportPin =new SportPin();

                sportPin.setId(var_sportid);
                sportPin.setName(var_name);
                sportPin.setKind_sport(var_kind);
                sportPin.setPly_sport(var_ply);

                MainActivity.myDatabase.Daotemp().insertSport(sportPin);
                Toast.makeText(getActivity(), "Sport added!", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                id.setText("");
                name.setText("");
                kind.setText("");
                ply.setText("");

            }
        });
        back = view.findViewById(R.id.backSport);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InsertFragment insertFragment = new InsertFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, insertFragment,
                        insertFragment.getTag()).addToBackStack(null).commit();

            }
        });




        return view;
    }
}