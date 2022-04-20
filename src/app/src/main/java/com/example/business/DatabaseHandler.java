package com.example.business;

import com.example.objects.Book;
import com.example.objects.User;

import com.example.persistence.BooksDB;
import com.example.persistence.UsersDB;

import java.util.ArrayList;
import java.util.Locale;

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

    public boolean addListBook(Book [] bookList){
        boolean flag = false;
        for (int i = 0; i< bookList.length ;i++){
            flag = addBookHelper(bookList[i]) ;
        }
        return flag;
    }

    public boolean addBookHelper(Book book){

        return addBook(book.getBookTitle(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getGenre());
    }
    public boolean addBook(String name, String author, Double price, String description, String genre)
    {
        if (duplicate(name)){
            return false;
        }
        if(!name.equals("") && !author.equals("") && !price.equals("") && price > 0 && !description.equals("") && !genre.equals(""))
        {
            booksDB.InsertBook(name, author, price, description, genre);
            return true;
        }
        return false;
    }

    public boolean addUser(String fName, String lName, String email, String password)
    {
        if(!fName.equals("") && !lName.equals("") && !email.equals("") && !password.equals("") )
        {
            usersDB.InsertUser(fName, lName, email, password);
            return true;
        }
        return false;
    }

    public ArrayList<Book> search(String searchVal){
        ArrayList <Book> bookList = getBooks();
        ArrayList <Book>  searchResults = new ArrayList<>();
        //store all related search in array found books
        if (bookList != null){
            for (int i = 0; i< bookList.size();i++){
                if (bookList.get(i).getBookTitle().toLowerCase().contains(searchVal.trim().toLowerCase()) || bookList.get(i).getGenre().trim().toLowerCase().contains(searchVal.toLowerCase().trim())){
                    searchResults.add(bookList.get(i));
                }
            }
        }
        //no book found
        return searchResults;
    }

    public ArrayList<String> getNames(ArrayList <Book> bookList){
        ArrayList <String> temp = new ArrayList<>();

        for (int i =0 ;i< bookList.size();i++){
            temp.add(bookList.get(i).getBookTitle());
        }
        return temp;
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
    public boolean duplicate(String title){
        ArrayList <Book> bookList = getBooks();

        for (int i = 0 ;i< bookList.size();i++)
            if (bookList.get(i).getBookTitle().equals(title))
                return true;

        return false;
    }

    public Book[] toArray(ArrayList<Book> bookList){
        Book [] temp = new Book[bookList.size()];

        for (int i = 0; i< bookList.size();i++) {
            temp[i] = bookList.get(i);
        }
        return temp;

    }
    public void emptyBooks(){
        booksDB.deleteAllBooks();
    }

    public Book getById(String id){
        int bId = Integer.parseInt(id);
        Book temp = null;

        ArrayList <Book> bookList = getBooks();
        for (int i = 0; i< bookList.size();i++){
            if (bId == bookList.get(i).getID()){
                temp =  bookList.get(i);
            }
        }
        return temp;
    }
}
