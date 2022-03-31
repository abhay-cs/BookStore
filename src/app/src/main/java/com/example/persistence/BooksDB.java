package com.example.persistence;

import android.util.Log;

import com.example.objects.Book;

import java.sql.*;
import java.util.ArrayList;

public class DBOperations {
    private static String TAG = "DBOperations";
    private Connection conn;
    private static String DBName = "uombooks.db";

    private boolean ConnectToBooksDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + DBName);
        } catch (Exception e){
            Log.e(TAG, "Unable to connect. Error: " + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean ExecuteQuery(String query) {
        if (ConnectToBooksDB()) {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
            } catch (Exception e) {
                Log.e(TAG, "Unable to execute query: " + query + ". Error: " + e.getMessage());
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean InsertData(String query) {
        if (ConnectToBooksDB()) {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.commit();
                conn.close();
            } catch (Exception e) {
                Log.e(TAG, "Unable to insert data: " + query + ". Error: " + e.getMessage());
                return false;
            }

            return true;
        }

        return false;
    }

    public ArrayList<Book> GetBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        String getBooks = "SELECT * FROM books;";

        if (ConnectToBooksDB()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getBooks);

                while (rs.next()) {
                    
                }

            } catch (Exception e) {
                Log.e(TAG, "Unable to get books. Error: " + e.getMessage());
                return null;
            }
        }

        return books;
    }
}
