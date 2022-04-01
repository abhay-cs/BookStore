package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;

import java.util.ArrayList;

public class start_page extends AppCompatActivity {
    // Copy these two lines to the activities which
    // require access to the database
    private static String DBName = "appdatabase.db";
    private String dbPath;

    private Button signin_button;
    private Button signup_button;
    private Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);


        signin_button = findViewById(R.id.signin);
        signup_button = findViewById(R.id.signup);
        addUser = findViewById(R.id.addUser);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Determine the path to the application database
                dbPath = getApplicationContext().getDatabasePath(DBName).getAbsolutePath();

                // Make calls to the database using the dbPath
                DatabaseHandler databaseHandler = new DatabaseHandler(dbPath);

                // Now you make all the database operations here
                databaseHandler.addBook("ABC", "Mike", 20.99, "ghkdfghsk", "Romantic");
                ArrayList<Book> books = databaseHandler.getBooks();
                String nString = books.get(0).getBookTitle();
                Toast.makeText(getApplicationContext(), nString, Toast.LENGTH_SHORT).show();
            }
        });

        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(start_page.this,MainActivity.class);
                //startActivity(intent);
                Toast.makeText(getApplicationContext(), "This is a test", Toast.LENGTH_SHORT).show();
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(start_page.this,signup_page.class);
                startActivity(intent);
            }
        });

    }



}