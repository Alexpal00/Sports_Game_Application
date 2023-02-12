package com.example.ergasia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ergasia.ui.delete.DeleteFragment;
import com.example.ergasia.ui.insert.InsertFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertGameFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button buttonNext,back;
    EditText edittext,city,country,eidos,id;
    String Item="ΑΤΟΜΙΚΟ";
    int itemPos;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertGameFragment newInstance(String param1, String param2) {
        InsertGameFragment fragment = new InsertGameFragment();
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
        View view =  inflater.inflate(R.layout.fragment_insert_game, container, false);

        spinner = view.findViewById(R.id.spinner);
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
        edittext=view.findViewById(R.id.editTextTextPersonName3);
        city=view.findViewById(R.id.editTextTextPersonName4);
        country=view.findViewById(R.id.editTextTextPersonName5);
        eidos=view.findViewById(R.id.editTextTextPersonName6);
        id=view.findViewById(R.id.editTextTextPersonName7);

        buttonNext = view.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(itemPos==0){

                    Bundle bundle = new Bundle();
                    bundle.putString("date2",edittext.getText().toString());
                    bundle.putString("city2",city.getText().toString());
                    bundle.putString("country2",country.getText().toString());
                    bundle.putString("sport2",eidos.getText().toString());
                    bundle.putString("id2",id.getText().toString());

                    AtomikoFragment atomikoFragment = new AtomikoFragment();
                    atomikoFragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment, atomikoFragment,
                            atomikoFragment.getTag()).addToBackStack(null).commit();

                }
                else if(itemPos==1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("date",edittext.getText().toString());
                    bundle.putString("city",city.getText().toString());
                    bundle.putString("country",country.getText().toString());
                    bundle.putString("sport",eidos.getText().toString());
                    bundle.putString("id",id.getText().toString());

                    OmadikoFragment omadikoFragment = new OmadikoFragment();
                    omadikoFragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment, omadikoFragment,
                            omadikoFragment.getTag()).addToBackStack(null).commit();
                }
            }
        });

        back = view.findViewById(R.id.backInsGame);
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