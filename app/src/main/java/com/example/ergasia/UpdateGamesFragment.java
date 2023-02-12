package com.example.ergasia;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.ergasia.ui.delete.DeleteFragment;
import com.example.ergasia.ui.update.UpdateFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateGamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateGamesFragment extends Fragment {

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

    public UpdateGamesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateGamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateGamesFragment newInstance(String param1, String param2) {
        UpdateGamesFragment fragment = new UpdateGamesFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_games, container, false);


        spinner = view.findViewById(R.id.spinnerUpdate);
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


        code = view.findViewById(R.id.editTextCodegameUpd);
        delete=view.findViewById(R.id.buttonUpdatetGame);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override

        public void onClick(View v) {

            if(itemPos==0){
                int var_gameid=0;
                try{
                    var_gameid = Integer.parseInt(code.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("id3",var_gameid);

                UpdateAtomikoFragment updateAtomikoFragment = new UpdateAtomikoFragment();
                updateAtomikoFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateAtomikoFragment,
                        updateAtomikoFragment.getTag()).addToBackStack(null).commit();

            }else if(itemPos==1) {

                int var_gameid=0;
                try{
                    var_gameid = Integer.parseInt(code.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("id",var_gameid);

                UpdateOmadikoFragment updateOmadikoFragment = new UpdateOmadikoFragment();
                updateOmadikoFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, updateOmadikoFragment,
                        updateOmadikoFragment.getTag()).addToBackStack(null).commit();

                code.setText("");
            }
        }

    });

    back = view.findViewById(R.id.backUpGame);
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