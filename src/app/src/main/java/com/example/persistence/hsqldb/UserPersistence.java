package com.example.persistence.hsqldb;
import com.example.objects.User;
import com.example.persistence.IUserPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserPersistence implements IUserPersistence{

    private final String dbPath;

    public UserPersistence(final String dbPath){
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file"+dbPath +";shutdown=true", "SA","");

    }
    @Override
    public User insertUser(User currentUser) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO USERS VALUES (?,?,?)");
            st.setInt(1,currentUser.getUserId());
            st.setString(2,currentUser.getFirstName() + " " + currentUser.getLastName());
            st.setString(3,currentUser.getEmailID());
            st.setString(4,currentUser.getPassword());
            st.executeUpdate();

            return currentUser;
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
