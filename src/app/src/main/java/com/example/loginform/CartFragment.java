package com.example.loginform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import com.example.objects.User;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    private String dbPath;
    private DatabaseHandler databaseHandler;

    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        View view = inflater.inflate(R.layout.fragment_cart,container,false);
        GridView cartGrid = view.findViewById(R.id.gridviewCart);

        SharedPreferences sh = getActivity().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
        String email = sh.getString("email", "");

        User user = databaseHandler.getByUserEmail(email);
        ArrayList<Book> bookArrayList = databaseHandler.getCart(user.getUserId());

        Book[] cartItems = databaseHandler.toArray(bookArrayList);

        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), cartItems);
        cartGrid.setAdapter(booksAdapter);
        
        return view;
    }
}