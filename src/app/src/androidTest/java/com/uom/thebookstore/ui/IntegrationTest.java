package com.uom.thebookstore.ui;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.Cart;
import com.uom.thebookstore.objects.User;

import org.junit.Test;

import java.util.ArrayList;

public class IntegrationTest
{
    @Test
    public void testCartIntegration()
    {
        Cart cart = new Cart();
        Book bookA = new Book(1, "Book A", "Lazy Panther", 10.99, "This is the first book.", "Mystery");
        Book bookB = new Book(2, "Book B", "Smart Tiger", 21.99, "This is the second book.", "Magic");
        Book bookC = new Book(3, "Book C", "Huge Magnet", 19.99, "This is the third book.", "Romance");

        User newUser1 = new User(1, "Huge", "Chair", "hugechair@chair.com", "HugeChair1234");
        User newUser2 = new User(2, "Mega", "Mouse", "megamouse@mouse.com", "MegaMouse1234");

        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");
        assert (db!=null);
        writeBooks();
        writeUsers();
        assert(db.getUsers().size() == 2);

        writeCart();
        assert(db.getUsers().size() == 2);
        checkCart();
    }

    public void checkCart()
    {
        Book bookA = new Book(0, "Book A", "Lazy Panther", 10.99, "This is the first book.", "Mystery");
        Book bookB = new Book(1, "Book B", "Smart Tiger", 21.99, "This is the second book.", "Magic");

        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        ArrayList<Book> books =  db.getBooks();

        // There must be only 3 books
        assert(books.size() == 3);

        ArrayList<User> users =  db.getUsers();

        // There must be only 2 users
        assert(users.size() == 2);

        ArrayList<Book> cartBooks =  db.getCart(1);
        assert(cartBooks.get(0).getBookTitle().equals(bookA.getBookTitle()));
        assert(cartBooks.get(0).getAuthor().equals(bookA.getAuthor()));
        assert(cartBooks.get(1).getBookTitle().equals(bookB.getBookTitle()));
        assert(cartBooks.get(1).getAuthor().equals(bookB.getAuthor()));
        assert(cartBooks.get(0).getBookTitle().equals(bookA.getBookTitle()));
        assert(cartBooks.get(0).getBookTitle().equals(bookA.getBookTitle()));
    }

    public void writeCart()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        assert (db!=null);

        Boolean bReset = db.ResetCartsDB();
        assert(bReset != false);

        Boolean bInserted = false;

        bInserted = db.addToCart(0,1);
        assert(bInserted != false);
        bInserted = db.addToCart(1,1);
        assert(bInserted != false);
        bInserted = db.addToCart(0,2);
        assert(bInserted != false);
        bInserted = db.addToCart(1,2);
        assert(bInserted != false);
        bInserted = db.addToCart(2,2);
        assert(bInserted != false);
    }

    public void writeUsers()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        assert (db!=null);

        User newUser1 = new User(1, "Huge", "Chair", "hugechair@chair.com", "HugeChair1234");
        User newUser2 = new User(2, "Mega", "Mouse", "megamouse@mouse.com", "MegaMouse1234");

        // Clear the Users table
        Boolean bReset = db.ResetUsersDB();
        assert(bReset != false);

        Boolean bInserted = false;

        bInserted = db.addUser(newUser1.getFirstName(), newUser1.getLastName(), newUser1.getEmailID(), newUser1.getPassword());
        assert(bInserted != false);

        bInserted = db.addUser(newUser2.getFirstName(), newUser2.getLastName(), newUser2.getEmailID(), newUser2.getPassword());
        assert(bInserted != false);
        assert(db.getUsers().size() == 2);
    }

    public void writeBooks()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        assert (db!=null);

        Book bookA = new Book(1, "Book A", "Lazy Panther", 10.99, "This is the first book.", "Mystery");
        Book bookB = new Book(2, "Book B", "Smart Tiger", 21.99, "This is the second book.", "Magic");
        Book bookC = new Book(3, "Book C", "Huge Magnet", 19.99, "This is the third book.", "Romance");

        // Clear the Books table
        Boolean bReset = db.ResetBooksDB();
        assert(bReset != false);

        Boolean bInserted = false;

        bInserted = db.addBook(bookA.getBookTitle(), bookA.getAuthor(), bookA.getPrice(),  bookA.getDescription(), bookA.getGenre());
        assert(bInserted != false);

        bInserted = db.addBook(bookB.getBookTitle(), bookB.getAuthor(), bookB.getPrice(),  bookB.getDescription(), bookB.getGenre());
        assert(bInserted != false);

        bInserted = db.addBook(bookC.getBookTitle(), bookC.getAuthor(), bookC.getPrice(),  bookC.getDescription(), bookC.getGenre());
        assert(bInserted != false);
    }
}
