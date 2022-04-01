package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WatchListFragment extends Fragment {


    public WatchListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_watch_list,container,false);

        // sample books added
        String[] listItems = {"Harry potter", "Game of thrones","New Book 1","Another One",
                             "something book", "some new book"};

        ListView listView = (ListView) view.findViewById(R.id.watchListView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                listItems
        );
        listView.setAdapter(listViewAdapter);

        return view;
    }
}