package com.uom.thebookstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;

public class BuyPage extends AppCompatActivity {
    private String dbPath;
    private DatabaseHandler databaseHandler;
    private Button buy_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_page);

        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        Intent intent = getIntent();
        String bookId = intent.getExtras().getString("To buy");

        Book book = databaseHandler.getBookById(bookId);

        Book[] bookArray = {book};
        BooksAdapter booksAdapter = new BooksAdapter(this.getApplicationContext(), bookArray);

        GridView gridView = findViewById(R.id.gridviewBuyPage);
        gridView.setAdapter(booksAdapter);



    }
}