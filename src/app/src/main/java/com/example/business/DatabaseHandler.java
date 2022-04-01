package com.example.business;

import com.example.objects.Book;
import com.example.objects.User;
import com.example.persistence.IBookPersistence;
import com.example.persistence.IUserPersistence;
import com.example.application.Services;
import java.util.ArrayList;


public class DatabaseHandler
{
    private IBookPersistence booksDB;
    private IUserPersistence usersDB;


    public DatabaseHandler(String dbPath)
    {
        booksDB = Services.getiBookPersistence();
        usersDB = Services.getiUserPersistence();
        booksDB.setDbPath(dbPath);
        booksDB.CreateDB();
        usersDB.setDbPath(dbPath);
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

    public ArrayList<Book> getBooks()
    {
        ArrayList<Book> books;
        if(booksDB != null) {
            books = booksDB.GetBooks();
            return books;
        }
        return null;
    }

    public ArrayList<User> getUsers()
    {
        ArrayList<User> users;
        if(usersDB != null) {
            users = usersDB.GetUsers();
            return users;
        }
        return null;
    }
}
