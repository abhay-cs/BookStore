package com.example.objects;

public class User
{
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String emailID;
    private final String Password;
  
    public User(int userId, String firstName, String lastName, String emailID, String Password)
    {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.Password = Password;
    }

    public int getUserId() { return userId; }

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
