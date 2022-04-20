package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.objects.Book;

public class HomeFragment extends Fragment {


    private Book[] books = {new Book(0,"Harry Potter 1", "Jk",7.22, "Goof Book","Horror"),
            new Book(1,"Harry Potter 2", "Walter",5.99, "sample","Fiction"),
            new Book(0,"Harry Potter 3", "Jk",12.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 4", "Jk",15.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 5", "Jk",5.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 5", "Jk",787.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 6", "Jk",234.22, "Goof Book","Horror"),
            new Book(1,"Harry Potter 7", "Walter",524.99, "sample","Fiction"),
            new Book(1,"Harry Potter 8", "Walter",524.99, "sample","Fiction"),
            new Book(0,"Harry Potter 9", "Jk",74.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 10", "Jk",79.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 11", "Jk",74.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 12", "Jk",71.22, "Goof Book","Horror"),
            new Book(0,"Harry Potter 13", "Jk",790.22, "Goof Book","Horror"),};

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = (SearchView)view.findViewById(R.id.searchViewBar);
        //GridView //
        GridView gridView = (GridView)view.findViewById(R.id.gridview);

        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), books);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent intent = new Intent(getActivity(),BookPage.class);
                intent.putExtra("Book name", "some");
                startActivity(intent);

            }
        });




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(query != null){
                    // this is the search item output
                    Toast.makeText(getActivity(),"No books found",Toast.LENGTH_LONG).show();
                    // search up the query agaisnt DB
                    // fiction action scifi or harry potter
                    // show up a list view -- > template
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