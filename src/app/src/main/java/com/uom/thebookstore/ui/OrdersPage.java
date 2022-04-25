package com.uom.thebookstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.Cart;
import com.uom.thebookstore.objects.User;

public class OrdersPage extends AppCompatActivity {
    private String dbPath;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_page);
        //getting path name of table and create it if not already exists
        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        SharedPreferences sh = getSharedPreferences("SharedPreference", Context.MODE_PRIVATE);
        String email = sh.getString("email", "");

        User user = databaseHandler.getByUserEmail(email);
        Book[] orderList = databaseHandler.getOrders(user);

        GridView gridView = findViewById(R.id.gridViewOrder);
        BooksAdapter booksAdapter = new BooksAdapter(this.getApplicationContext(), orderList);
        gridView.setAdapter(booksAdapter);


    }
}