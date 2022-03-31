package com.example.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.objects.Book;
import com.example.objects.User;

import java.util.ArrayList;

public class SqlDatabase extends SQLiteOpenHelper
{
    private static final String DBNAME = "appdatabase.db";

    private static final int VERSION = 1;

    private static final String TABLE1 = "books";
    private static final String BID = "id";
    private static final String BNAME = "name";
    private static final String BAUTHOR = "author";
    private static final String BPRICE = "price";
    private static final String BDESCRIPTION = "description";
    private static final String BGENRE = "genre";

    private static final String TABLE2 = "users";
    private static final String UID = "id";
    private static final String UFNAME = "firstname";
    private static final String ULNAME = "lastname";
    private static final String UEMAIL = "email";
    private static final String UPASSWORD = "password";


    public SqlDatabase(@Nullable Context context)
    {
        // Add context, the DB Name, leave the factory as null and update version as required
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) // Creates table in the database on startup
    {
        // CREATE TABLE TABLE1 (id integer primary, name text, author text)
        db.execSQL("CREATE TABLE " + TABLE1 + " (" + BID + " integer primary key, " + BNAME + " text, " + BAUTHOR + " text, " + BPRICE + " text, " + BDESCRIPTION + " text, " + BGENRE + " text)");
        db.execSQL("CREATE TABLE " + TABLE2 + " (" + UID + " integer primary key, " + UFNAME + " text, " + ULNAME + " text, " + UEMAIL + " text, " + UPASSWORD + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE " + TABLE1);
        db.execSQL("DROP TABLE " + TABLE2);
        onCreate(db);
    }

    public void insertBook(Book newBook)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); // Get the database handle in writable mode
        ContentValues contentValues = new ContentValues(); // Create a content collection

        // Set the content to be pushed - column name, value
        // Creating book table
        contentValues.put(BNAME, newBook.getBookTitle());
        contentValues.put(BAUTHOR, newBook.getAuthor());
        contentValues.put(BPRICE, newBook.getPrice());
        contentValues.put(BDESCRIPTION, newBook.getDescription());
        contentValues.put(BGENRE, newBook.getGenre());

        sqLiteDatabase.insert(TABLE1, null, contentValues); // insert into the table
    }

    public void insertUser(User newUser)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); // Get the database handle in writable mode
        ContentValues contentValues = new ContentValues(); // Create a content collection

        // Set the content to be pushed - column name, value
        // Creating user table
        contentValues.put(UFNAME, newUser.getFirstName());
        contentValues.put(ULNAME, newUser.getLastName());
        contentValues.put(UEMAIL, newUser.getEmailID());
        contentValues.put(UPASSWORD, newUser.getPassword());

        sqLiteDatabase.insert(TABLE2, null, contentValues); // insert into the table
    }

    public ArrayList<Book> getAllBooks()
    {
        ArrayList<Book> bookArray = new ArrayList<Book>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase(); // Get the database handle in readable mode

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE1, null);
        cursor.moveToFirst();


        while(!cursor.isAfterLast())
        {
            int getIdIndex = cursor.getColumnIndex(BID);
            int iID = cursor.getInt(getIdIndex);

            int getNameIndex = cursor.getColumnIndex(BNAME);
            String sName = cursor.getString(getNameIndex);

            int getAuthorIndex = cursor.getColumnIndex(BAUTHOR);
            String sAuthor = cursor.getString(getAuthorIndex);

            int getPriceIndex = cursor.getColumnIndex(BPRICE);
            double dPrice = cursor.getDouble(getPriceIndex);

            int getDescriptionIndex = cursor.getColumnIndex(BDESCRIPTION);
            String sDescription = cursor.getString(getDescriptionIndex);

            int getGenreIndex = cursor.getColumnIndex(BGENRE);
            String sGenre = cursor.getString(getGenreIndex);

            Book book = new Book(iID, sName, sAuthor, dPrice, sDescription, sGenre);
            bookArray.add(book);
            cursor.moveToNext();
        }

        return bookArray;
    }

    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> userArray = new ArrayList<User>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase(); // Get the database handle in readable mode

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE2, null);
        cursor.moveToFirst();


        while(!cursor.isAfterLast())
        {
            int getIdIndex = cursor.getColumnIndex(UID);
            int iID = cursor.getInt(getIdIndex);

            int getFirstNameIndex = cursor.getColumnIndex(UFNAME);
            String sFName = cursor.getString(getFirstNameIndex);

            int getLastNameIndex = cursor.getColumnIndex(ULNAME);
            String sLName = cursor.getString(getLastNameIndex);

            int getEmailIndex = cursor.getColumnIndex(UEMAIL);
            String sEmail = cursor.getString(getEmailIndex);

            int getPasswordIndex = cursor.getColumnIndex(UPASSWORD);
            String sPassword = cursor.getString(getPasswordIndex);

            User user = new User(iID, sFName, sLName, sEmail, sPassword);
            userArray.add(user);
            cursor.moveToNext();
        }

        return userArray;
    }
}
