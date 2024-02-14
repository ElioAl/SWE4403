package com.example.databasemanagementsystem;

import java.sql.*;
import java.util.Properties;

public class user_db extends Database{
    public void add_user(String username, String password){
        Connection dbConnection = Connection.Connect();
        CallableStatement dbStatement = null;

        /*try{
            dbStatement = dbConnection.prepareCall("{CALL add_user(?,?}");
        }
        catch(SQLException e){
            Connection.getSQLException(e);
        }
        finally{
            Connection.Closing(dbStatement, dbConnection);
        }*/
    }
}
