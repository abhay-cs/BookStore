package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.business.DatabaseHandler;

public class signup_page extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText user_email;
    private EditText user_password;
    private Button signup;
    private DatabaseHandler databaseHandler;
    private static String DBName = "appdatabase.db";
    private String dbPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        firstName = findViewById(R.id.editTextTextPersonNam);
        lastName = findViewById(R.id.editTextTextPersonName2);
        user_email = findViewById(R.id.editTextTextEmailAddress);
        user_password = findViewById(R.id.editTextTextPassword);
        signup = findViewById(R.id.signup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_email.getText().length() > 0 && user_password.getText().length() > 0 && firstName.getText().length() > 0 && lastName.getText().length() > 0) {
                    dbPath = getApplicationContext().getDatabasePath(DBName).getAbsolutePath();

                    databaseHandler = new DatabaseHandler(dbPath);
                    databaseHandler.addUser(firstName.getText().toString(),
                            lastName.getText().toString(),
                            user_email.getText().toString(),
                            user_password.getText().toString()
                    );
                    Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup_page.this,MainActivity.class);
                    startActivity(intent);
//
                } else {
                    String toastMessage = "Invalid Input";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

