package com.example.persistence.sqldb;

import com.example.objects.User;
import com.example.persistence.IUserPersistence;

import java.sql.*;
import java.util.ArrayList;

public class UsersDB implements IUserPersistence
{
    private String dbPath;
    private static String TAG = "UsersDB";
    private Connection conn;
    private static String DBName = "appdatabase.db";

    private static final String TABLE2 = "users";
    private static final String UID = "id";
    private static final String UFNAME = "firstname";
    private static final String ULNAME = "lastname";
    private static final String UEMAIL = "email";
    private static final String UPASSWORD = "password";


    private boolean ConnectToUsersDB()
    {
        //String dbPath = context.getDatabasePath(DBName).getAbsolutePath();

        try
        {
            DriverManager.registerDriver((Driver) Class.forName("org.sqldroid.SQLDroidDriver").newInstance());
            conn = DriverManager.getConnection("jdbc:sqldroid:" + dbPath);
        }
        catch (Exception e)
        {
            //Log.e(TAG, "Unable to connect. Error: " + e.getMessage());
            return false;
        }

        return true;
    }

    // Creates a table if it does not exist
    public boolean CreateDB()
    {
        String createBooks = "CREATE TABLE " + TABLE2 + " (" + UID + " integer primary key, " + UFNAME + " text, " + ULNAME + " text, " + UEMAIL + " text, " + UPASSWORD + " text)";

        // Check if the table already exists
        String checkTable = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + TABLE2 + "'";
        if (ConnectToUsersDB())
        {
            try
            {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(checkTable);

                if (!rs.next())
                {
                    // Table does not exist, so we need to create it
                    stmt.close();
                    rs.close();
                    conn.close();

                    return ExecuteQuery(createBooks);
                }
                return true;
            }
            catch (Exception e)
            {
                //Log.e(TAG, "Unable to check if books table exists. Error: " + e.getMessage());
                return false;
            }
        }
        return ExecuteQuery(createBooks);
    }

    public boolean ExecuteQuery(String query)
    {
        if (ConnectToUsersDB())
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

    public boolean InsertUser(String firstName, String lastName, String email, String password)
    {
        String newBook = "INSERT INTO " + TABLE2 + " (" + UFNAME + ", " + ULNAME + ", " + UEMAIL + ", " + UPASSWORD + ") VALUES (?, ?, ?, ?)";
        if (ConnectToUsersDB()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(newBook);
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, email);
                stmt.setString(4, password);
                stmt.executeUpdate();
                stmt.close();
                conn.close();
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

    public ArrayList<User> GetUsers() {
        ArrayList<User> users = new ArrayList<User>();
        String getBooks = "SELECT * FROM users;";

        if (ConnectToUsersDB()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getBooks);

                while (rs.next()) {
                    User user = new User(rs.getInt(UID),
                            rs.getString(UFNAME),
                            rs.getString(ULNAME),
                            rs.getString(UEMAIL),
                            rs.getString(UPASSWORD));
                    //Log.i(TAG, user.getFirstName());
                    users.add(user);
                }

                stmt.close();

            } catch (Exception e) {
                //Log.e(TAG, "Unable to get users. Error: " + e.getMessage());
                return null;
            }
        }

        return users;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }
}