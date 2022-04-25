package com.uom.thebookstore.business;

import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.User;

import com.uom.thebookstore.persistence.BooksDB;
import com.uom.thebookstore.persistence.CartsDB;
import com.uom.thebookstore.persistence.UsersDB;
import com.uom.thebookstore.persistence.WatchlistDB;

import java.util.ArrayList;

public class DatabaseHandler
{
    private BooksDB booksDB;
    private UsersDB usersDB;
    private CartsDB cartsDB;
    private WatchlistDB watchlistDB;

    public DatabaseHandler(String dbPath)
    {
        booksDB = new BooksDB(dbPath);
        booksDB.CreateDB();
        usersDB = new UsersDB(dbPath);
        usersDB.CreateDB();
        cartsDB = new CartsDB(dbPath);
        cartsDB.CreateDB();
        watchlistDB =new WatchlistDB(dbPath);
        watchlistDB.CreateDB();
    }

    public boolean addListBook(Book [] bookList)
    {
        boolean flag = false;
        for (int i = 0; i< bookList.length ;i++){
            flag = addBookHelper(bookList[i]) ;
        }
        return flag;
    }

    public boolean ResetBooksDB() {
        return booksDB.ResetDB();
    }

    public boolean ResetCartsDB() {
        return cartsDB.ResetDB();
    }

    public boolean ResetUsersDB() {
        return usersDB.ResetDB();
    }
    public boolean addBookHelper(Book book)
    {
        return addBook(book.getBookTitle(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getGenre());
    }
    public boolean addBook(String name, String author, Double price, String description, String genre)
    {
        int id = getBookMaxId() + 1;
        if (duplicate(name)){
            return false;
        }
        if(!name.equals("") && !author.equals("") && !price.equals("") && price > 0 && !description.equals("") && !genre.equals(""))
        {
            return booksDB.InsertBook(id, name, author, price, description, genre);
        }
        return false;
    }

    public boolean addToCart(int bID, int uID)
    {
        if(bID > -1 && uID > -1)
        {
            return cartsDB.InsertToCart(bID, uID);
        }
        return false;
    }

    public boolean addUser(String fName, String lName, String email, String password)
    {
        int id = getUserMaxId() + 1;
        if(!fName.equals("") && !lName.equals("") && !email.equals("") && !password.equals("") )
        {
            return usersDB.InsertUser(id,fName, lName, email, password);
        }
        return false;
    }

    public ArrayList<Book> search(String searchVal)
    {
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

    public ArrayList<String> getNames(ArrayList <Book> bookList)
    {
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

    public ArrayList<Book> getCart(int uID)
    {
        ArrayList<Book> books;
        ArrayList<Integer> bIDs;
        ArrayList<Book> retBooks = new ArrayList<Book>();

        if(cartsDB != null && booksDB != null)
        {
            bIDs = cartsDB.GetCartFromUser(uID);
            books = booksDB.GetBooks();

            for(int i = 0; i < books.size(); i++)
            {
                Book tempBook = books.get(i);

                for(int j = 0; j < bIDs.size(); j++)
                {
                    if(tempBook.getID() == bIDs.get(j))
                    {
                        retBooks.add(tempBook);
                    }
                }
            }
            return retBooks;
        }

        return retBooks;
    }

    public ArrayList<Book> getWatchlist(int uID)
    {
        ArrayList<Book> books;
        ArrayList<Integer> bIDs;
        ArrayList<Book> retBooks = new ArrayList<Book>();

        if(watchlistDB != null && booksDB != null)
        {
            bIDs = watchlistDB.GetWatchlistFromUser(uID);
            books = booksDB.GetBooks();

            for(int i = 0; i < books.size(); i++)
            {
                Book tempBook = books.get(i);

                for(int j = 0; j < bIDs.size(); j++)
                {
                    if(tempBook.getID() == bIDs.get(j))
                    {
                        retBooks.add(tempBook);
                    }
                }
            }
            return retBooks;
        }

        return retBooks;
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
    public void emptyCarts(){ cartsDB.ResetDB();}
    public void emptyUsers(){usersDB.ResetDB();}

    public Book getBookById(String id){
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

    public User getByUserEmail(String email){
        User user = null;
        ArrayList<User> userList = getUsers();

        for (int i = 0;i< userList.size();i++){
            if (userList.get(i).getEmailID().equals(email)){
                user = userList.get(i);
                break;
            }
        }
        return user;
    }

    public int getBookMaxId(){
        int count = -1;
        ArrayList<Book> bookArrayList = getBooks();
        for (int i = 0; i< bookArrayList.size();i++){
            if (bookArrayList.get(i).getID()>count){
                count = bookArrayList.get(i).getID();
            }
        }
        return count;
    }

    public int getUserMaxId(){
        int count = -1;
        ArrayList<User> userArrayList = getUsers();
        for (int i = 0; i< userArrayList.size();i++){
            if (userArrayList.get(i).getUserId()>count){
                count = userArrayList.get(i).getUserId();
            }
        }
        return count;
    }
    public boolean addToWatchlist(int bID, int uID)
    {
        if(bID > -1 && uID > -1)
        {
            return watchlistDB.InsertToWishlist(bID, uID);
        }
        return false;
    }

    public Book[] getOrders(User user){
        Book[] orderList;

        ArrayList<Integer> booksId =  cartsDB.GetCartFromUser(user.getUserId());
        orderList = new Book[booksId.size()];

        for (int i =0;i<booksId.size();i++){
            Book temp = getBookById(booksId.get(i) + "");
            orderList[i] = temp;
        }
        return orderList;
    }


}
