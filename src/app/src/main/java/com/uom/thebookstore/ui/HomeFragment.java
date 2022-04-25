package com.uom.thebookstore.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import com.uom.thebookstore.business.DatabaseHandler;
import com.uom.thebookstore.objects.Book;

import java.util.ArrayList;


public class HomeFragment extends Fragment
{
    private static String DBName = "appdatabase.db";
    private String dbPath;
    private DatabaseHandler databaseHandler;

    /*private Book[] books = {new Book(1,"Things Fall Apart", "Jk",7.22, "Goof Book","Horror"),
            new Book(2,"Pride and Prejudice", "Walter",5.99, "sample","Fiction"),
            new Book(3,"Nineteen Eighty-Four", "Jk",12.22, "Goof Book","Horror"),
            new Book(4,"Harry Potter 4", "Jk",15.22, "Goof Book","Horror"),
            new Book(5,"Harry Potter 5", "Jk",5.22, "Goof Book","Horror"),
            new Book(6,"Harry Potter 6", "Jk",787.22, "Goof Book","Horror"),
            new Book(7,"Harry Potter 7", "Jk",234.22, "Goof Book","Horror"),
            new Book(8,"Harry Potter 8", "Walter",524.99, "sample","Fiction"),
            new Book(9,"Harry Potter 9", "Walter",524.99, "sample","Fiction"),
            new Book(10,"Harry Potter 10", "Jk",74.22, "Goof Book","Horror"),
            new Book(11,"Harry Potter 11", "Jk",79.22, "Goof Book","Horror"),
            new Book(12,"Harry Potter 12", "Jk",74.22, "Goof Book","Horror"),
            new Book(13,"Harry Potter 13", "Jk",71.22, "Goof Book","Horror"),
            new Book(14,"Harry Potter 14", "Jk",790.22, "Goof Book","Horror")};*/

    private Book[] books = {new Book(1,"Things Fall Apart", "Chinua Achebe",14.99,"A simple story of a strong man whose life is dominated by fear and anger, Things Fall Apart is written with remarkable economy and subtle irony. Uniquely and richly African, at the same time it reveals Achebe's keen awareness of the human qualities common to men of all times and places.","Fiction"),
            new Book(2,"Pride and Prejudice","Jane Austen",14.99,"Since its immediate success in 1813, Pride and Prejudice has remained one of the most popular novels in the English language. Jane Austen called this brilliant work her own darling child and its vivacious heroine, Elizabeth Bennet, as delightful a creature as ever appeared in print. The romantic clash between the opinionated Elizabeth and her proud beau, Mr. Darcy, is a splendid performance of civilized sparring. And Jane Austen's radiant wit sparkles as her characters dance a delicate quadrille of flirtation and intrigue, making this book the most superb comedy of manners of Regency England.","Fiction"),
            new Book(3,"Nineteen Eighty-Four","George Orwell",12.99,"Among the seminal texts of the 20th century, Nineteen Eighty-Four is a rare work that grows more haunting as its futuristic purgatory becomes more real. Published in 1949, the book offers political satirist George Orwell's nightmarish vision of a totalitarian, bureaucratic world and one poor stiff's attempt to find individuality. The brilliance of the novel is Orwell's prescience of modern life—the ubiquity of television, the distortion of the language—and his ability to construct such a thorough version of hell. Required reading for students since it was published, it ranks among the most terrifying novels ever written.","Fiction"),
            new Book(4,"Wuthering Heights","Emily Brontë",13.99," It concerns two families of the landed gentry living on the West Yorkshire moors, the Earnshaws and the Lintons, and their turbulent relationships with Earnshaw's foster son, Heathcliff","Fiction"),
            new Book(5,"Absalom, Absalom!","William Faulkner",15.99,"Taking place before, during, and after the American Civil War, it is a story about three families of the American South, with a focus on the life of Thomas Sutpen.","Fiction"),
            new Book(6,"The Canterbury Tales","Geoffrey Chaucer",10.99,"The tales (mostly written in verse, although some are in prose) are presented as part of a story-telling contest by a group of pilgrims as they travel together from London to Canterbury to visit the shrine of Saint Thomas Becket at Canterbury Cathedral.","Fiction"),
            new Book(7,"Great Expectations","Charles Dickens",12.99," It depicts the education of an orphan nicknamed Pip (the book is a bildungsroman, a coming-of-age story).","Fiction"),
            new Book(8,"Middlemarch","George Eliot",11.99,"Set in Middlemarch, a fictional English Midland town, in 1829 to 1832, it follows distinct, intersecting stories with many characters.","Fiction"),
            new Book(9,"Invisible Man","Ralph Ellison",14.99,"It addresses many of the social and intellectual issues faced by African Americans in the early twentieth century, including black nationalism, the relationship between black identity and Marxism, and the reformist racial policies of Booker T.","Fiction"),
            new Book(10,"The Outsiders","S. E. Hinton",11.99,"The book details the conflict between two rival gangs divided by their socioeconomic status: the working-class greasers and the upper-class Socs.","Fiction"),
            new Book(11,"The Old Man and the Sea","Ernest Hemingway",15.99,"One of his most famous works, it tells the story of Santiago, an aging Cuban fisherman who struggles with a giant marlin far out in the Gulf Stream off the coast of Cuba.","Fiction"),
            new Book(12,"Ulysses","James Joyce",14.95,"Ulysses is the Latinised name of Odysseus, the hero of Homer's epic poem the Odyssey, and the novel establishes a series of parallels between the poem and the novel, with structural correspondences between the characters and experiences of Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus, in addition to events and themes of the early 20th-century context of modernism, Dublin, and Ireland's relationship to Britain. ","Fiction"),
            new Book(13,"To Kill a Mockingbird","E. B. White",11.99," The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte. When Wilbur is in danger of being slaughtered by the farmer, Charlotte writes messages praising Wilbur in her web in order to persuade the farmer to let him live.","Fiction"),
            new Book(14,"Moby Dick","Harper Lee",15.00,"To Kill a Mockingbird is a coming-of-age story about a girl named Scout. Scout and her brother Jem try to understand and relate to their father, Atticus, who is a lawyer charged with defending a black man falsely accused of raping a white woman.","Fiction"),
            new Book(15,"Beloved","Toni Morrison",12.99,"Beloved, novel by Toni Morrison, published in 1987 and winner of the 1988 Pulitzer Prize for fiction. The work examines the destructive legacy of slavery as it chronicles the life of a Black woman named Sethe, from her pre-Civil War days as a slave in Kentucky to her time in Cincinnati, Ohio, in 1873.","Fiction"),
            new Book(16,"Lolita","Vladimir Nabokov",14.99,"The novel is notable for its controversial subject: the protagonist and unreliable narrator, a French middle-aged literature professor under the pseudonym Humbert Humbert, is obsessed with an American 12-year-old girl, Dolores Haze, whom he sexually molests after he becomes her stepfather","Fiction"),
            new Book(17,"The Book Thief","Markus Zusak",13.99,"The Book Thief is a story narrated by a compassionate Death who tells us about Liesel, a girl growing up in Germany during World War II. She steals books, learns to read, and finds comfort in words. She and Max, the Jew her family protects, are the only main characters that survive the war.","Fiction"),
            new Book(18,"Animal Farm","George Orwell",13.99,"The book tells the story of a group of farm animals who rebel against their human farmer, hoping to create a society where the animals can be equal, free, and happy.","Fiction"),
            new Book(19,"Charlotte's Web","Salman Rushdie",10.00," The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte. When Wilbur is in danger of being slaughtered by the farmer, Charlotte writes messages praising Wilbur in her web in order to persuade the farmer to let him live.","Fiction"),
            new Book(20,"Frankenstein","Mary Shelley",15.00,"Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment. ","Fiction"),
            new Book(21,"Brave New World","Aldous Huxley",15.00,"Largely set in a futuristic World State, whose citizens are environmentally engineered into an intelligence-based social hierarchy, the novel anticipates huge scientific advancements in reproductive technology, sleep-learning, psychological manipulation and classical conditioning that are combined to make a dystopian society which is challenged by only a single individual: the story's protagonist.","Fiction"),
            new Book(22,"The Life And Opinions of Tristram Shandy","Laurence Sterne",13.99,"Tristram Shandy, is a novel by Laurence Sterne. It was published in nine volumes, the first two appearing in 1759, and seven others following over the next seven years (vols. 3 and 4, 1761; vols. 5 and 6, 1762; vols. 7 and 8, 1765; vol. 9, 1767). It purports to be a biography of the eponymous character. Its style is marked by digression, double entendre, and graphic devices.","Fiction"),
            new Book(23,"Gulliver's Travels","Laurence Sterne",15.00,"Gulliver's Travels, or Travels into Several Remote Nations of the World. In Four Parts. By Lemuel Gulliver, First a Surgeon, and then a Captain of Several Ships is a 1726 prose satire by the Anglo-Irish writer and clergyman Jonathan Swift, satirising both human nature and the travellers' tales literary subgenre.","Fiction"),
            new Book(24,"The Adventures of Huckleberry Finn","Mark Twain",12.99,"The plot of Huckleberry Finn tells the story of two characters' attempts to emancipate themselves. Huck desires to break free from the constraints of society, both physical and mental, while Jim is fleeing a life of literal enslavement.","Fiction"),
            new Book(25,"Leaves of Grass","Walt Whitman",14.50,"The collection of loosely connected poems represents the celebration of his philosophy of life and humanity and praises nature and the individual human's role in it. Rather than focusing on religious or spiritual matters, Leaves of Grass focuses primarily on the body and the material world. With one exception, its poems do not rhyme or follow standard rules for meter and line length.","Fiction"),
            new Book(26,"To the Lighthouse","Virginia Woolf",14.00,"The novel recalls childhood emotions and highlights adult relationships. Among the book's many tropes and themes are those of loss, subjectivity, the nature of art and the problem of perception.","Fiction"),
            new Book(27,"Midnight's Children","Salman Rushdie",14.95,"It portrays India's transition from the British colonial rule to the independence and the partition of India.","Fiction")};

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //getting path name of table and create it if not already exists
        dbPath = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/UOM";
        databaseHandler = new DatabaseHandler(dbPath);

        databaseHandler.ResetBooksDB();
        for(int i = 0; i < books.length; i++)
        {
            databaseHandler.addBook(books[i].getBookTitle(), books[i].getAuthor(), books[i].getPrice(), books[i].getDescription(), books[i].getGenre());
        }

        ArrayList <Book> books = databaseHandler.getBooks();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = (SearchView)view.findViewById(R.id.searchViewBar);

        //GridView //
        GridView gridView = (GridView)view.findViewById(R.id.gridviewBuyPage);
        Book[] bookArray = databaseHandler.toArray(books);
        BooksAdapter booksAdapter = new BooksAdapter( this.getContext(), bookArray);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Book book = bookArray[position];
                String bookID = "" + book.getID();

                Intent intent = new Intent(getActivity(),BookPage.class);
                intent.putExtra("Book name", bookID);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null){
                    //Searching for user input in database
                    Intent showResults = new Intent(HomeFragment.this.getActivity(), SearchResultActivity.class);
                    showResults.putExtra("Search Value", query);
                    startActivity(showResults);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return view;
    }

}