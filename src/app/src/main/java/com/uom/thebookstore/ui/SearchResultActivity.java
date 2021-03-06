package com.uom.thebookstore.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
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

        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        bookList = databaseHandler.search(userInput);

        if (bookList.size() > 0) {
            //GridView //
            GridView gridView = findViewById(R.id.gridviewBuyPage);
            Book[] books = databaseHandler.toArray(bookList);

            BooksAdapter booksAdapter = new BooksAdapter(this.getApplicationContext(), books);
            gridView.setAdapter(booksAdapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Book book = books[position];
                    String bookID = "" + book.getID();

                    Intent intent = new Intent(getApplicationContext(),BookPage.class);
                    intent.putExtra("Book name", bookID);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "No books found", Toast.LENGTH_LONG).show();
        }
    }
}
