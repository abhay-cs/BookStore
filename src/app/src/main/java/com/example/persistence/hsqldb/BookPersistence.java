package com.example.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.objects.Book;
import com.example.persistence.IBookPersistence;

public class BookPersistence implements IBookPersistence {

    private final String dbPath;

    public BookPersistence(final String dbPath){
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file" + dbPath + ";shutdown=true", "SA" , "" );
    }

    @Override
    public Book insertBook(Book currentBook) {

        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?,?)");
            st.setInt(1, currentBook.getID());
            st.setString(2, currentBook.getBookTitle());
            st.setDouble(3,  currentBook.getPrice());
            st.setString(4, currentBook.getDescription());
            st.setString(5, currentBook.getGenre());
            st.executeUpdate();
            return currentBook;

        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
