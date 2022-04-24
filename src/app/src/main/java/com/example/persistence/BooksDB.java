package com.example.persistence;

import android.util.Log;

import com.example.objects.Book;

import java.sql.*;

import java.util.ArrayList;
import java.util.Locale;

public class BooksDB
{
    private String dbPath;
    private String DBName = "appdb.db";
    private static String TAG = "BooksDB";
    private Connection conn;

    // Table Schema
    private static final String TABLE1 = "books";
    private static final String BID = "id";
    private static final String BNAME = "name";
    private static final String BAUTHOR = "author";
    private static final String BPRICE = "price";
    private static final String BDESCRIPTION = "description";
    private static final String BGENRE = "genre";

    public BooksDB(String dbPath) {
        this.dbPath = dbPath;
    }

    private boolean ConnectToBooksDB()
    {
        try
        {
            DriverManager.registerDriver((Driver) Class.forName("org.hsqldb.jdbcDriver").newInstance());
            conn = DriverManager.getConnection("jdbc:hsqldb:file:"  + dbPath + ";hsqldb.lock_file=false;shutdown=true", "SA", "");
        }
        catch (Exception e)
        {
            System.out.println("Connection error: " + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean CreateSchema() {
        String dbSchema = "CREATE SCHEMA IF NOT EXISTS appschema";
        return ExecuteQuery(dbSchema);
    }

    // Creates a table if it does not exist
    public boolean CreateDB() {
        if (!CreateSchema())
            return false;

        String createBooks = "CREATE TABLE IF NOT EXISTS " + TABLE1 + " (" + BID + " INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " + BNAME + " VARCHAR(50), " + BAUTHOR + " VARCHAR(50), " + BPRICE + " double, " + BDESCRIPTION + " VARCHAR(50), " + BGENRE + " VARCHAR(50))";

        if (ConnectToBooksDB()) {
            return ExecuteQuery(createBooks);
        }
        return false;
    }

    public boolean ResetDB() {
        if (ConnectToBooksDB()) {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("TRUNCATE TABLE " + TABLE1 + " RESTART IDENTITY");
                stmt.close();
                //conn.close();

            } catch (Exception e) {
                System.out.println("DB Reset error: " + e.getMessage());
            }
        } else {
            return false;
        }

        return true;
    }

    public boolean ExecuteQuery(String query)
    {
        if (ConnectToBooksDB())
        {
            try
            {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                //conn.close();
            }
            catch (Exception e)
            {
                System.out.println("DB Execute error: " + e.getMessage());
                return false;
            }

            return true;
        }

        return false;
    }


    public boolean InsertBook(int id, String title, String author, double price, String description, String genre) {
        String newBook = "INSERT INTO " + TABLE1 + " (" + BID + ", " + BNAME + ", " + BAUTHOR + ", " + BPRICE + ", " + BDESCRIPTION + ", " + BGENRE + ") VALUES (? ,?, ?, ?, ?, ?)";
        if (ConnectToBooksDB()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(newBook);
                stmt.setInt(1, id);
                stmt.setString(2, title);
                stmt.setString(3, author);
                stmt.setDouble(4, price);
                stmt.setString(5, description);
                stmt.setString(6,genre);
                stmt.executeUpdate();
                stmt.close();
                //conn.close();
            } catch (Exception e) {
                System.out.println("DB Write error: " + e.getMessage());
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
                    Book book = new Book(rs.getInt(BID),
                            rs.getString(BNAME),
                            rs.getString(BAUTHOR),
                            rs.getDouble(BPRICE),
                            rs.getString(BDESCRIPTION),
                            rs.getString(BGENRE));
                    books.add(book);
                }

                stmt.close();

            } catch (Exception e) {
                System.out.println("DB Read error: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("Unable to connect to the DB");
        }

        return books;
    }

    public void deleteAllBooks() {
        if (ConnectToBooksDB()) {
            try {
                final PreparedStatement sc = conn.prepareStatement("DELETE FROM books;");
                sc.executeUpdate();
                sc.close();
                //conn.close();
            } catch (final SQLException e) {
//                throw new PersistenceException(e);
            }

        }
    }
}
