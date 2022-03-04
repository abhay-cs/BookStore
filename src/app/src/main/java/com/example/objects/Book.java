public class Book 
{
    private String title;
    private String yearPublished;
    private String author;
  
    public Book(String title, String author, String yearPublished)
    {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
     
    public String getBookTitle()
    {
        return (title);
    }	 	
    
    public String getAuthor()
    {
        return (author);
    }
   
    public String getYearPublished()
    {
         return (yearPublished);
    }

    public String toString()
    {
         return String.format("Book: %s \nYear Published: %s \nAuthor name: %s ",title, yearPublished, author);
    }
}