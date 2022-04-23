package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.objects.Book;

public class BuyPage extends AppCompatActivity {

    private String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_page);

        GridView gridView = findViewById(R.id.gridviewBuyPage);
//        Book[] books = databaseHandler.toArray(bookList);

//        BooksAdapter booksAdapter = new BooksAdapter(this.getApplicationContext(), books);
//        gridView.setAdapter(booksAdapter);


    }
}