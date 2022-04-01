package com.example.objects;

public class Book
{
    private String title;
    private int id;
    private double price;
    private String description;
    private String genre;


    public Book(int id,String title, double price,String description, String genre)
    {

        this.title = title;
        this.id=id;
        this.price = price;
        this.description = description;
        this.genre = genre;
    }

    public String getBookTitle()
    {
        return (title);
    }

    public int getID(){return (id);}

    public double getPrice(){return (price);}

    public String getDescription(){return (description);}

    public String getGenre(){return (genre);}

    public String toString()
    {
        return String.format("Book: %s  \nPrice : %d ",price);
    }
}