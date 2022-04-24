package com.uom.thebookstore.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;

import java.util.ArrayList;


public class HomeFragment extends Fragment
{
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;

    private Book[] books = {new Book(1,"Harry Potter 1", "Jk",7.22, "Goof Book","Horror"),
            new Book(2,"Harry Potter 2", "Walter",5.99, "sample","Fiction"),
            new Book(3,"Harry Potter 3", "Jk",12.22, "Goof Book","Horror"),
            new Book(4,"Harry Potter 4", "Jk",15.22, "Goof Book","Horror"),
            new Book(5,"Harry Potter 5", "Jk",5.22, "Goof Book","Horror"),
            new Book(6,"Harry Potter 6", "Jk",787.22, "Goof Book","Horror"),
            new Book(7,"Harry Potter 7", "Jk",234.22, "Goof Book","Horror"),
            new Book(8,"Harry Potter 8", "Walter",524.99, "sample","Fiction"),
            new Book(9,"Harry Potter 9", "Walter",524.99, "sample","Fiction"),
            new Book(10,"Harry Potter 10", "Jk",74.22, "Goof Book","Horror"),
            new Book(11,"Harry Potter 11", "Jk",79.22, "Goof Book","Horror"),
            new Book(12,"Harry Potter 12", "Jk",74.22, "Goof Book","Horror"),
            new Book(13,"Harry Potter 13", "Jk",71.22, "Goof Book","Horror"),
            new Book(14,"Harry Potter 14", "Jk",790.22, "Goof Book","Horror")};

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //getting path name of table and create it if not already exists
        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        for(int i = 0; i < books.length; i++)
        {
            databaseHandler.addBook(books[i].getBookTitle(), books[i].getAuthor(), books[i].getPrice(), books[i].getDescription(), books[i].getGenre());
        }

//       databaseHandler.emptyBooks();

////        adding lists of books in database
//        if (databaseHandler.addListBook(books)){
//            Toast.makeText(getActivity(), "Successfully added", Toast.LENGTH_LONG).show();
//        }

        ArrayList <Book> books = databaseHandler.getBooks();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = (SearchView)view.findViewById(R.id.searchViewBar);

        //GridView //
        GridView gridView = (GridView)view.findViewById(R.id.gridviewBuyPage);
        Book[] bookArray = databaseHandler.toArray(books);
        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), bookArray);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Book book = bookArray[position];
                String bookID = "" + book.getID();

                Intent intent = new Intent(getActivity(),BookPage.class);
                intent.putExtra("Book name", bookID);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null){
                    //Searching for user input in database
                    Intent showResults = new Intent(HomeFragment.this.getActivity(), SearchResultActivity.class);
                    showResults.putExtra("Search Value", query);
                    startActivity(showResults);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return view;
    }

}