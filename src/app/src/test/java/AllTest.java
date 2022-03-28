////import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//public class JUnitTest {
//
//    @Test
//    public void test1()
//    {
//        Book Book1 = new Book("Book A", "Ron", "2008");
//        Book Book2 = new Book("Book B", "John", "2011");
//        Book Book3 = new Book("Book C", "Mike", "2020");
//
//        assert (Book1 != null);
//        assert (Book2 != null);
//        assert (Book3 != null);
//
//        // Sample test database
//        Database d = new Database();
//        d.addData(0, Book1);
//        d.addData(0, Book2);
//        d.addData(0, Book3);
//
//        assert (d != null);
//    }
//
//    @Test
//    public void test2()
//    {
//        Book Book1 = new Book("Book A", "Ron", "2008");
//
//        assert (Book1.getBookTitle().equals("Book A"));
//        assert (Book1.getAuthor().equals("Ron"));
//        assert (Book1.getYearPublished().equals("2008"));
//
//        System.out.println("Success!");
//    }
//
//    @Test
//    public void test3()
//    {
//        User User1 = new User("Sam", "Brick", "sambrick@gmail.com", "Winter2022-1");
//
//        assert (User1.getFirstName().equals("Sam"));
//        assert (User1.getLastName().equals("Brick"));
//        assert (User1.getEmailID().equals("sambrick@gmail.com"));
//        assert (User1.getPassword().equals("Winter2022-1"));
//
//        System.out.println("Success!");
//    }
//
//    @Test
//    public void test4()
//    {
//        Book Book1 = new Book("Book A", "Ron", "2008");
//        Book Book2 = new Book("Book B", "John", "2011");
//        Book Book3 = new Book("Book C", "Mike", "2020");
//
//        assert (Book1 != null);
//        assert (Book2 != null);
//        assert (Book3 != null);
//
//        // Sample test database
//        Database d = new Database();
//        d.addData(0, Book1);
//        d.addData(0, Book2);
//        d.addData(0, Book3);
//
//        assert (d != null);
//
//        d.addNewColumn();
//
//        d.addData(1, Book3);
//
//        assert(d.viewBook(0, 0).equals(Book1));
//        assert(d.viewBook(1, 0).equals(Book3));
//    }
//}