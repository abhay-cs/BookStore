package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup_page extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText user_email;
    private EditText user_password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
//
        // Shows error in the runtime
//        firstName = findViewById(R.id.editTextTextPersonNam);
//        lastName = findViewById(R.id.editTextTextPersonName2);
//        user_email = findViewById(R.id.editTextTextEmailAddress);
//        user_password = findViewById(R.id.editTextTextPassword);
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (user_email.getText().length() > 0 && user_password.getText().length() > 0 && firstName.getText().length() > 0 && lastName.getText().length() > 0) {
//                    String toastMessage = "Firstname: " + firstName.getText().toString() + ", Lastname: " + lastName.getText().toString();
//                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
//                    String toastMessage2 = "Username: " + user_email.getText().toString() + ", Password: " + user_password.getText().toString();
//                    Toast.makeText(getApplicationContext(), toastMessage2, Toast.LENGTH_SHORT).show();
//                } else {
//                    String toastMessage = "enter again";
//                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}

