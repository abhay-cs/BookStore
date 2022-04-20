package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;
import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;
    private ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Intent intent = getIntent();
        String userInput = intent.getExtras().getString("Search Value");

        dbPath = getDatabasePath(DBName).getAbsolutePath();
        databaseHandler = new DatabaseHandler(dbPath);

        bookList = databaseHandler.search(userInput);

        if (bookList.size() > 0) {
            //GridView //
            GridView gridView = findViewById(R.id.gridview);
            Book[] books = databaseHandler.toArray(bookList);

            BooksAdapter booksAdapter = new BooksAdapter(this.getApplicationContext(), books);
            gridView.setAdapter(booksAdapter);
        } else {
            Toast.makeText(getApplicationContext(), "No books found", Toast.LENGTH_LONG).show();
        }
    }
}
