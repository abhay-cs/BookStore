import android.app.Instrumentation;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;
import com.uom.thebookstore.objects.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest extends Instrumentation{
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler dbh;



//    context = InstrumentationRegistry.getContext();
//    private InstrumentationContext instrumentationContext = new InstrumentationContext();
//    @Before
//    private void setup() {
//        instrumentationContext = InstrumentationRegistry.getInstrumentation().context;
//    }
//
//    @Test
//    public void test1()
//    {
//
//        Context context = getContext();
//        dbPath = context.getDatabasePath(DBName).getAbsolutePath();
//        dbh = new DatabaseHandler(dbPath);
//
//        Book Book1 = new Book(1,"Book A","prabal", 10,  "very good book", "sci-fi");
//        Book Book2 = new Book(2,"Book B", "muzaffar",12,  "very bad book", "romance");
//        Book Book3 = new Book(3,"Book c", "abhay",13,  "very awesome book", "romance");
//
//        assert (Book1 != null);
//        assert (Book2 != null);
//        assert (Book3 != null);
//
//        // Sample test database
//        boolean inserted = dbh.addBook("Book A","prabal", 10.00,  "very good book", "sci-fi");
//        assert (inserted == true);
//        inserted = dbh.addBook("Book B", "muzaffar", 12.00, "very bad book", "romance");
//        assert (inserted == true);
//        inserted = dbh.addBook("Book c", "abhay", 13.00, "very awesome book", "romance");
//        assert (inserted == true);
//        assert (dbh != null);
//
//        ArrayList<Book> books = dbh.getBooks();
//        assert (books != null);
//        System.out.println(books.toString());
//        System.out.println("SUCCESS!");
//        System.out.println("Books database passed..................................................");
//
//    }

    @Test
    public void test2()
    {


        double price = 10.00;
        Book Book1 = new Book(1,"Book A","", price,  "very good book", "sci-fi");

        assert (Book1.getID() == 1);
        assert (Book1.getBookTitle().equals("Book A"));
        assert (Book1.getPrice() == price);
        assert (Book1.getDescription().equals("very good book"));
        assert (Book1.getGenre().equals("sci-fi"));
        System.out.println("SUCCESS!");
        System.out.println("Books class passed..................................................");
    }

    @Test
    public void test3()
    {

        User User1 = new User(1,"Sam", "Brick", "sambrick@gmail.com", "Winter2022-1");

        assert (User1.getFirstName().equals("Sam"));
        assert (User1.getLastName().equals("Brick"));
        assert (User1.getEmailID().equals("sambrick@gmail.com"));
        assert (User1.getPassword().equals("Winter2022-1"));
        System.out.println("SUCCESS!");
        System.out.println("User class passed..................................................");
    }

//    @Test
//    public void test4()
//    {
//
//        User U1 = new User(1,"Prabal", "Mendiratta", "mendirap", "prabal123");
//        User U2 = new User(2,"muzaffar", "ali", "muzaa", "ali@123");
//        User U3 = new User(3,"souvik", "ray", "soura", "ray@123");
//
//        assert (U1 != null);
//        assert (U2 != null);
//        assert (U3 != null);
//
//        // Sample test database
//
//
//        boolean inserted = dbh.addUser("Prabal", "Mendiratta", "mendirap", "prabal123");
//        assert (inserted == true);
//        inserted = dbh.addUser("muzaffar", "ali", "muzaa", "ali@123");
//        assert (inserted == true);
//        inserted = dbh.addUser("souvik", "ray", "soura", "ray@123");
//        assert (inserted == true);
//
//
//        assert (dbh != null);
//
//
//        ArrayList<User> users = new ArrayList<User>();
//        users = dbh.getUsers();
//        assert (users != null);
//        System.out.println("SUCCESS!");
//        System.out.println("Users database passed..................................................");
//    }
//
//
}