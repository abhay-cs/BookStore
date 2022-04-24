package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import com.example.objects.User;


public class BookPage extends AppCompatActivity {
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
        Book book = databaseHandler.getBookById(bookId);

        final TextView titletext = findViewById(R.id.book_name);
        titletext.setText(book.getBookTitle());

        //check when buy now button button is clicked
        Button buyButton = findViewById(R.id.buy_now);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buyPageIntent = new Intent(getApplicationContext(), BuyPage.class);
                buyPageIntent.putExtra("To buy", bookId);
                startActivity(buyPageIntent);
            }
        });

        Button addToCart = findViewById(R.id.addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toastMessage = "Item added to cart";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

                SharedPreferences sh = getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
                String email = sh.getString("email", "");

                if (email != null){
                    User user = databaseHandler.getByUserEmail(email);
                    Book book = databaseHandler.getBookById(bookId);
                    databaseHandler.addToCart(book.getID(),user.getUserId());
                }

            }
        });
    }
}