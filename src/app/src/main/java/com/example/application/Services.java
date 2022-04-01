package com.example.application;

import com.example.persistence.sqldb.BooksDB;
import com.example.persistence.sqldb.UsersDB;
import com.example.persistence.IUserPersistence;
import com.example.persistence.IBookPersistence;

public class Services
{
	private static IUserPersistence iUserPersistence = null;
	private static IBookPersistence iBookPersistence = null;

	public static synchronized IUserPersistence getiUserPersistence()
    {
		if (iUserPersistence == null) {
            iUserPersistence = new UsersDB();
        }
        return iUserPersistence;
	}

    public static synchronized IBookPersistence getiBookPersistence()
    {
        if (iBookPersistence == null)
        {
            iBookPersistence = new BooksDB();
        }

        return iBookPersistence;
    }

}
