package com.example.persistence;

import com.example.objects.Book;

import java.sql.*;

import java.util.ArrayList;

public class BooksDB
{
    private String dbPath;
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

    public BooksDB(String dbPath)
    {
        this.dbPath = dbPath;
    }

    private boolean ConnectToBooksDB()
    {
        //String dbPath = context.getDatabasePath(DBName).getAbsolutePath();

        try {
            DriverManager.registerDriver((Driver) Class.forName("org.sqldroid.SQLDroidDriver").newInstance());
            conn = DriverManager.getConnection("jdbc:sqldroid:" + dbPath);
        } catch (Exception e){
            //Log.e(TAG, "Unable to connect. Error: " + e.getMessage());
            return false;
        }

        return true;
    }

    // Creates a table if it does not exist
    public boolean CreateDB() {
        String createBooks = "CREATE TABLE " + TABLE1 + " (" + BID + " integer primary key, " + BNAME + " text, " + BAUTHOR + " text, " + BPRICE + " double, " + BDESCRIPTION + " text, " + BGENRE + " text)";

        // Check if the table already exists
        String checkTable = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + TABLE1 + "'";
        if (ConnectToBooksDB()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(checkTable);

                if (!rs.next()) {
                    // Table does not exist, so we need to create it
                    stmt.close();
                    rs.close();
                    conn.close();

                    return ExecuteQuery(createBooks);
                }
                return true;
            } catch (Exception e) {
                //Log.e(TAG, "Unable to check if books table exists. Error: " + e.getMessage());
                return false;
            }
        }
        return ExecuteQuery(createBooks);
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
                conn.close();
            }
            catch (Exception e)
            {
                //Log.e(TAG, "Unable to execute query: " + query + ". Error: " + e.getMessage());
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean InsertBook(String title, String author, double price, String description, String genre) {
        String newBook = "INSERT INTO " + TABLE1 + " (" + BNAME + ", " + BAUTHOR + ", " + BPRICE + ", " + BDESCRIPTION + ", " + BGENRE + ") VALUES (?, ?, ?, ?, ?)";
        if (ConnectToBooksDB()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(newBook);
                stmt.setString(1, title);
                stmt.setString(2, author);
                stmt.setDouble(3, price);
                stmt.setString(4, description);
                stmt.setString(5, genre);
                stmt.executeUpdate();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                //Log.e(TAG, "Unable to insert data. Error: " + e.getMessage());
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
                    //Log.i(TAG, book.getBookTitle());
                    books.add(book);
                }

                stmt.close();

            } catch (Exception e) {
                //Log.e(TAG, "Unable to get books. Error: " + e.getMessage());
                return null;
            }
        }

        return books;
    }
}
