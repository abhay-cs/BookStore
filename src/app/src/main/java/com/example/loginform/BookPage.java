package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;

import java.util.ArrayList;

public class BookPage extends AppCompatActivity {
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);

        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        Intent intent = getIntent();
        String bookId = intent.getExtras().getString("Book name");
        Book book = databaseHandler.getById(bookId);

        final TextView titletext = findViewById(R.id.book_name);
        titletext.setText(book.getBookTitle());

    }
}