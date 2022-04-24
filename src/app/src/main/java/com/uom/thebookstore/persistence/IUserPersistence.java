package com.uom.thebookstore.persistence;
import com.uom.thebookstore.objects.User;

public interface IUserPersistence {
    User insertUser (final User currentUser);
}
