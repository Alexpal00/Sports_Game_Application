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

import com.example.ergasia.ui.delete.DeleteFragment;
import com.example.ergasia.ui.update.UpdateFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Delete_teamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Delete_teamFragment extends Fragment {
    EditText code;
    Button delete,back;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Delete_teamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Delete_teamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Delete_teamFragment newInstance(String param1, String param2) {
        Delete_teamFragment fragment = new Delete_teamFragment();
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
        View view = inflater.inflate(R.layout.fragment_delete_team, container, false);

        code = view.findViewById(R.id.editTextCodeTeamDel);
        delete=view.findViewById(R.id.buttonDeleteTeam);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_teamid=0;
                try{
                    var_teamid = Integer.parseInt(code.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse "+ex);
                }
                try{
                TeamPin teamPin = new TeamPin();
                teamPin.setId(var_teamid);
                MainActivity.myDatabase.Daotemp().deleteTeam(teamPin);
                Toast.makeText(getActivity(), "Team with code " + var_teamid + " Deleted",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                code.setText("");

            }
        });

        back = view.findViewById(R.id.backDelTeam);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeleteFragment deleteFragment = new DeleteFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, deleteFragment,
                        deleteFragment.getTag()).addToBackStack(null).commit();

            }
        });


        return  view;
    }
}