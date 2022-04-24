package com.uom.thebookstore.objects;

import java.util.ArrayList;

public class User
{
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String emailID;
    private final String Password;

    private Cart cart;
    private Watchlist watchlist;
    private ArrayList<String> recommendation;
  
    public User(int userId, String firstName, String lastName, String emailID, String Password)
    {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.Password = Password;
        this.cart = new Cart();
        this.watchlist = new Watchlist();
    }

    public void setRecommendation(String rec1, String rec2, String rec3)
    {
        this.recommendation.add(rec1);
        this.recommendation.add(rec2);
        this.recommendation.add(rec3);
    }

    public void addToWatchlist(Book newBook)
    {
        this.watchlist.addBook(newBook);
    }

    public void addToCart(Book newBook)
    {
        this.cart.addBook(newBook);
    }

    public ArrayList<String> getRecommendation()
    {
        return recommendation;
    }

    public Cart getCart()
    {
        return cart;
    }

    public Watchlist getWatchlist()
    {
        return watchlist;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public String getEmailID()
    {
        return emailID;
    }
   
    public String getPassword()
    {
        return Password;
    }

    public String toString()
    {
        return String.format("User: %s %s \nEmailID: %s \nPassword: %s ",firstName, lastName, emailID, Password);
    }
}
