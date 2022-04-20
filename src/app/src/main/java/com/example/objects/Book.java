package com.example.objects;

public class Book
{
    private String title;
    private int id;
    private double price;
    private String author;
    private String description;
    private String genre;


    public Book(int id, String title, String author, double price, String description, String genre)
    {
        this.title = title;
        this.id = id;
        this.author = author;
        this.price = price;
        this.description = description;
        this.genre = genre;
    }

    public String getBookTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getID()
    {
        return id;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription()
    {
        return description;
    }

    public String getGenre()
    {
        return genre;
    }

    public String toString()
    {
        String temp = "Book = " + title ;
        return temp ;
    }
}