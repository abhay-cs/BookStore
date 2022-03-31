package com.example.business;

import com.example.persistence.BooksDB;
import com.example.persistence.UsersDB;

import android.content.Context;

public class DatabaseHandler
{
    private Context context;
    private BooksDB booksDB;
    private UsersDB usersDB;

    DatabaseHandler(Context context)
    {
        this.context = context;
        booksDB = new BooksDB(context);
        booksDB.CreateDB();
        usersDB = new UsersDB(context);
        usersDB.CreateDB();
    }

    public boolean addBook(String name, String author, Double price, String description, String genre)
    {
        if(!name.equals("") && !author.equals("") && !price.equals("") && price > 0 && !description.equals("") && !genre.equals(""))
        {
            booksDB.InsertBook(name, author, price, description, genre);
            return true;
        }
        return false;
    }

    public boolean addUser(String fName, String lName, String email, String password)
    {
        if(!fName.equals("") && !lName.equals("") && !email.equals("") && !password.equals(""))
        {
            usersDB.InsertUser(fName, lName, email, password);
            return true;
        }
        return false;
    }

    public void getBooks()
    {
        if(booksDB != null)
            booksDB.GetBooks();
    }

    public void getUsers()
    {
        if(usersDB != null)
            usersDB.GetUsers();
    }
}
