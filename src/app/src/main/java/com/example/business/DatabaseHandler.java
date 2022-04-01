package com.example.business;

import com.example.objects.Book;
import com.example.objects.User;
import com.example.persistence.BooksDB;
import com.example.persistence.UsersDB;

import java.util.ArrayList;


public class DatabaseHandler
{
    private BooksDB booksDB;
    private UsersDB usersDB;


    public DatabaseHandler(String dbPath)
    {
        booksDB = new BooksDB(dbPath);
        booksDB.CreateDB();
        usersDB = new UsersDB(dbPath);
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
    public boolean isUser(String email, String password){

        ArrayList<User> users = getUsers();
        for (int i = 0; i < users.size(); i++) {
            if(email.equals(users.get(i).getEmailID()) && password.equals(users.get(i).getPassword())){
                return true;
            }

        }
        return false;
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
