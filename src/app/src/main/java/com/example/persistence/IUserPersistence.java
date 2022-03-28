package com.example.persistence;
import com.example.objects.User;

public interface IUserPersistence {
    User insertUser (final User currentUser);
}
