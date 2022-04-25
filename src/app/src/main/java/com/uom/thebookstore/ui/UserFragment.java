package com.uom.thebookstore.ui;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.uom.thebookstore.business.DatabaseHandler;


public class UserFragment extends Fragment {

    private String dbPath;
    private DatabaseHandler databaseHandler;
    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        SharedPreferences sh = getContext().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
        String email = sh.getString("email", "");

        String[] userProfileList = {"Orders","Email: "+email, "Name: "+databaseHandler.getByUserEmail(email).getFirstName() +" "+databaseHandler.getByUserEmail(email).getLastName()};

        ListView listView = (ListView) view.findViewById(R.id.userProfile);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                userProfileList
        );
        listView.setAdapter(listViewAdapter);
//
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(getContext(),OrdersPage.class);
                    startActivity(intent);
                }

            }
        });
        return view;
    }
}