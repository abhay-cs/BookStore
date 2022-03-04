package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText user_email;
    private EditText user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

