package com.uom.thebookstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.User;


public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText user_email;
    private EditText user_password;
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;


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

