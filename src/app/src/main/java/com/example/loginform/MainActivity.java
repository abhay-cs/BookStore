package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import com.example.persistence.BooksDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText user_email;
    private EditText user_password;

    // Copy these two lines to the activities which
    // require access to the database
    private static String DBName = "appdatabase.db";
    private String dbPath;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Determine the path to the application database
        dbPath = this.getDatabasePath(DBName).getAbsolutePath();

        // Make calls to the database using the dbPath
        DatabaseHandler databaseHandler = new DatabaseHandler(dbPath);

        // Now you make all the database operations here
        databaseHandler.addBook("ABC", "Mike", 20.99, "ghkdfghsk", "Romantic");
        ArrayList<Book> books = databaseHandler.getBooks();
        String nString = books.get(0).getBookTitle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        user_email = findViewById(R.id.userName);
        user_password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_email.getText().length() > 0 && user_password.getText().length() > 0){
                    String toastMessage = "Username: " + user_email.getText().toString() + ", Password: " + user_password.getText().toString();
                    //Toast.makeText(getApplicationContext(),toastMessage, Toast.LENGTH_SHORT).show();

                    Toast.makeText(getApplicationContext(),nString, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,welcome_page.class);
                    startActivity(intent);
                }
                else {
                String toastMessage = "enter again";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}

