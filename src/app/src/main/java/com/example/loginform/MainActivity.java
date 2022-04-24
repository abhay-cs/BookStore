package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import android.content.Context;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import com.example.objects.User;
import com.example.persistence.BooksDB;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText user_email;
    private EditText user_password;
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;
    private ArrayList<User> userList;

    // Copy these two lines to the activities which
    // require access to the database


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        user_email = findViewById(R.id.userName);
        user_password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_email.getText().length() > 0 && user_password.getText().length() > 0){

                    dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
                    databaseHandler = new DatabaseHandler(dbPath);

                    if(databaseHandler.isUser(user_email.getText().toString(), user_password.getText().toString())){

                        User user = databaseHandler.getByUserEmail(user_email.getText().toString());
                        SharedPreferences preferences = getSharedPreferences("SharedPreference", MODE_PRIVATE);

                        if (user != null) {
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("email", user_email.getText().toString());
                            edit.commit();
                        }

                        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,welcome_page.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid User", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                String toastMessage = "enter again";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}

