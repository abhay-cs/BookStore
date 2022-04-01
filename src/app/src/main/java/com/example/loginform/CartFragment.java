package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.objects.Book;


public class CartFragment extends Fragment {

    private Book[] cartItems = {new Book(0,"Harry Potter 1", "Jk",7.22, "Goof Book","Horror"),
                                new Book(0,"Harry Potter 12", "Jk",71.22, "Goof Book","Horror"),
                                new Book(0,"Harry Potter 13", "Jk",790.22, "Goof Book","Horror")};
    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart,container,false);
        GridView cartGrid = view.findViewById(R.id.gridviewCart);
        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), cartItems);
        cartGrid.setAdapter(booksAdapter);
        
        return view;
    }
}