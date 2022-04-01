package com.example.persistence;
import com.example.objects.User;

import java.util.ArrayList;

public interface IUserPersistence {
    void setDbPath(String dbPath);
    boolean CreateDB();
    boolean ExecuteQuery(String query);
    ArrayList<User> GetUsers();
    boolean InsertUser(String firstName, String lastName, String email, String password);

}
