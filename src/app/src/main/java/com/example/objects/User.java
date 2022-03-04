public class User
{
    private String firstName;
    private String lastName;
    private String emailID;
    private String Password;
  
    public User(String firstName, String lastName, String emailID, String Password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.Password = Password;
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
