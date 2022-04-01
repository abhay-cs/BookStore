package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.objects.Book;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Book[] books = {new Book(0,"Harry Potter", 7.22,"Nice", "sample")
                        ,new Book(1,"Harry Potter 2", 77.22,"Nice part 2", "sample")};

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = (SearchView)view.findViewById(R.id.searchViewBar);
        //GridView //
        GridView gridView = (GridView)view.findViewById(R.id.gridview);

        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), books);
        gridView.setAdapter(booksAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(query != null){
                    // this is the search item output
                    Toast.makeText(getActivity(),query,Toast.LENGTH_LONG).show();
                }


                return false;
            }
        // a
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return view;
    }
}