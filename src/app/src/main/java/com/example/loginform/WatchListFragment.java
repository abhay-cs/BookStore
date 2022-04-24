package com.example.loginform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import com.example.objects.User;

import java.util.ArrayList;


public class WatchListFragment extends Fragment {
    private String dbPath;
    private DatabaseHandler databaseHandler;


    public WatchListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        View view = inflater.inflate(R.layout.fragment_watch_list,container,false);
        GridView watchlistGrid = view.findViewById(R.id.gridviewWatchlist);

        SharedPreferences sh = getActivity().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
        String email = sh.getString("email", "");

        User user = databaseHandler.getByUserEmail(email);
        ArrayList<Book> bookArrayList = databaseHandler.getWatchlist(user.getUserId());

        Book[] listItems = databaseHandler.toArray(bookArrayList);
        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), listItems);
        watchlistGrid.setAdapter(booksAdapter);

        return view;
    }
}