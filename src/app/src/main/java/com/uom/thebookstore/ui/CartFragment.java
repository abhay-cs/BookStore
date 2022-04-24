package com.uom.thebookstore.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.User;

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