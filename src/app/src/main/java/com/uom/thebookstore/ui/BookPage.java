package com.uom.thebookstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.User;


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

        SharedPreferences sh = getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
        String email = sh.getString("email", "");

        final TextView titletext = findViewById(R.id.book_name);
        titletext.setText(book.getBookTitle());

        final TextView desciption = findViewById(R.id.book_description);
        titletext.setText(book.getDescription());

        final TextView price_item = findViewById(R.id.price_item);
        titletext.setText("$ " + book.getPrice());

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


                if (email != null){
                    User user = databaseHandler.getByUserEmail(email);
                    Book book = databaseHandler.getBookById(bookId);
                    databaseHandler.addToCart(book.getID(),user.getUserId());
                }

            }
        });

        Button addToWatchList = findViewById(R.id.watchList);
        addToWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage = "Item added to watchlist";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

                if (email != null){
                    User user = databaseHandler.getByUserEmail(email);
                    Book book = databaseHandler.getBookById(bookId);
                    databaseHandler.addToWatchlist(book.getID(),user.getUserId());
                }

            }
        });
    }
}