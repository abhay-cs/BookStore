package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static String DBName = "appdatabase.db";
    private String dbPath;


    public HomeFragment() {
        // Required empty public constructor
        dbPath = this.getContext().getDatabasePath(DBName).getAbsolutePath();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Book[] books = {new Book(0,"Harry Potter","JK", 7.22,"DescSample","Sample")
                ,new Book(1,"Harry Potter 2", "JK",77.22,"DescSample","sample")};

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = (SearchView)view.findViewById(R.id.searchViewBar);
        //GridView //
        GridView gridView = (GridView)view.findViewById(R.id.gridview);

//        DatabaseHandler databaseHandler = new DatabaseHandler(dbPath);
//       databaseHandler.addBook("a","b",2.0,"asample", "sample");
//
//       ArrayList<Book> books2 = databaseHandler.getBooks();
//        Book[] arr = new Book[books2.size()];
//       arr = books2.toArray(arr);

//        for (Book x : arr)
//            System.out.print(x + " ");

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