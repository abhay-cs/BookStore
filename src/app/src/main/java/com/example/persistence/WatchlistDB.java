package com.example.persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WatchlistDB
{
    private String dbPath;
    private String DBName = "appdb.db";
    private static String TAG = "CartsDB";
    private Connection conn;

    // Table Schema
    private static final String TABLE4 = "watchlist";
    private static final String WID = "id";
    private static final String BID = "book_id";
    private static final String UID = "user_id";
    private static final String WSTATUS = "status";

    public WatchlistDB(String dbPath)
    {
        this.dbPath = dbPath;
    }

    private boolean ConnectToWatchlistDB()
    {
        try
        {
            DriverManager.registerDriver((Driver) Class.forName("org.hsqldb.jdbcDriver").newInstance());
            conn = DriverManager.getConnection("jdbc:hsqldb:file:"  + dbPath + ";hsqldb.lock_file=false;shutdown=true", "SA", "");
        }
        catch (Exception e)
        {
            //Log.e(TAG, "Unable to connect. Error: " + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean CreateSchema()
    {
        String dbSchema = "CREATE SCHEMA IF NOT EXISTS appschema";
        return ExecuteQuery(dbSchema);
    }

    public boolean ExecuteQuery(String query)
    {
        if (ConnectToWatchlistDB())
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
                //Log.e(TAG, "Unable to execute query: " + query + ". Error: " + e.getMessage());
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean InsertToWishlist(int bID, int uID)
    {
        String newCartItem = "INSERT INTO " + TABLE4 + " (" + UID + ", " + BID + ", " + WSTATUS + ") VALUES (?, ?, ?)";
        if (ConnectToWatchlistDB()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(newCartItem);
                stmt.setInt(1, uID);
                stmt.setInt(2, bID);
                stmt.setBoolean(3, true);
                stmt.executeUpdate();
                stmt.close();
                //conn.close();
            }
            catch (Exception e)
            {
                //Log.e(TAG, "Unable to insert data. Error: " + e.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean ResetDB() {
        if (ConnectToWatchlistDB())
        {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("TRUNCATE TABLE " + TABLE4 + " RESTART IDENTITY");
                stmt.close();
                //conn.close();
            } catch (Exception e) {
                System.out.println("DB Reset error: " + e.getMessage());
            }
        }
        else
        {
            return false;
        }

        return true;
    }

    public ArrayList<Integer> GetWatchlistFromUser(int uID)
    {
        ArrayList<Integer> bookIDs = new ArrayList<Integer>();
        String getBooks = "SELECT * FROM watchlist;";

        if (ConnectToWatchlistDB())
        {
            try
            {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getBooks);

                while (rs.next())
                {
                    if(rs.getInt(UID) == uID)
                    {
                        bookIDs.add(rs.getInt(BID));
                    }
                }

                stmt.close();

            } catch (Exception e) {
                //Log.e(TAG, "Unable to get users. Error: " + e.getMessage());
                return null;
            }
        }

        return bookIDs;
    }
}