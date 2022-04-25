

package com.uom.thebookstore.ui;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.Cart;
import com.uom.thebookstore.objects.User;
import com.uom.thebookstore.objects.Watchlist;

import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
public class UnitTest
{
    @Test
    public void testBook()
    {
        Book newBook = new Book(1, "Book A", "Author A", 19.99, "This is the first book", "Test Book");

        assert (newBook.getID() == 1);
        assert (newBook.getBookTitle().equals("Book A"));
        assert (newBook.getAuthor().equals("Author A"));
        assert (newBook.getPrice() == 19.99);
        assert (newBook.getDescription().equals("This is the first book"));
        assert (newBook.getGenre().equals("Test Book"));
    }

    @Test
    public void testUser()
    {
        User newUser = new User(1, "Huge", "Chair", "hugechair@chair.com", "HugeChair1234");

        assert (newUser.getUserId() == 1);
        assert (newUser.getFirstName().equals("Huge"));
        assert (newUser.getLastName().equals("Chair"));
        assert (newUser.getEmailID().equals("hugechair@chair.com"));
        assert (newUser.getPassword().equals("HugeChair1234"));
    }

    @Test
    public void testCart()
    {
        Cart cart = new Cart();
        Book bookA = new Book(1, "Book A", "Lazy Panther", 10.99, "This is the first book.", "Mystery");
        Book bookB = new Book(2, "Book B", "Smart Tiger", 21.99, "This is the second book.", "Magic");
        Book bookC = new Book(3, "Book C", "Huge Magnet", 19.99, "This is the third book.", "Romance");

        cart.addBook(bookA);
        cart.addBook(bookB);
        cart.addBook(bookC);

        ArrayList<Book> cartBooks = cart.getBooks();
        assert(cartBooks.get(0).equals(bookA));
        assert(cartBooks.get(1).equals(bookB));
        assert(cartBooks.get(2).equals(bookC));
    }

    @Test
    public void testWatchlist()
    {
        Watchlist watchlist = new Watchlist();
        Book bookA = new Book(1, "Book A", "Lazy Panther", 10.99, "This is the first book.", "Mystery");
        Book bookB = new Book(2, "Book B", "Smart Tiger", 21.99, "This is the second book.", "Magic");
        Book bookC = new Book(3, "Book C", "Huge Magnet", 19.99, "This is the third book.", "Romance");

        watchlist.addBook(bookA);
        watchlist.addBook(bookB);
        watchlist.addBook(bookC);

        ArrayList<Book> cartBooks = watchlist.getBooks();
        assert(cartBooks.get(0).equals(bookA));
        assert(cartBooks.get(1).equals(bookB));
        assert(cartBooks.get(2).equals(bookC));
    }


}

    /*@Test
    public void runTest()
    {
        writeBooks();
        readBooks();
    }

    public void writeBooks()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        assert (db!=null);

        // Clear the Books table
        Boolean bReset = db.ResetBooksDB();
        assert(bReset != false);

        Boolean bInserted = false;

        bInserted = db.addBook("Book ONE","Souvik Ray", 123.45,  "An interesting book", "Sci-Fi");
        assert(bInserted != false);

        bInserted = db.addBook("Book TWO","Souvik Ray", 234.56,  "Read this book", "Romance");
        assert(bInserted != false);

        bInserted = db.addBook("Book THREE","Souvik Ray", 345.67,  "A must read", "Ancient History");
        assert(bInserted != false);
    }


    public void readBooks()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM");

        ArrayList<Book> books =  db.getBooks();

        // There must be only 3 books
        assert(books.size() == 3);

        // The author of the first book must be Souvik Ray
        assert(books.get(0).getAuthor().equals("Souvik Ray"));
    }*/
