package com.example.databasemanagementsystem;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

public class user_DB {
    public static void add_user(String username, String password){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL add_user(?,?)}");
            dbStatement.setString("username", username);
            dbStatement.setString("password", password);
            dbStatement.executeQuery();

        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static void delete_user(String username, String password) {
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL delete_user(?,?)}");
            dbStatement.setString("username", username);
            dbStatement.setString("password", password);
            dbStatement.executeQuery();
        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }

    }

    public static ArrayList<String> get_user(int user_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        ResultSet dbResultSet = null;
        ArrayList<String> result = null;
        try{
            dbStatement = dbConnection.prepareCall("{CALL get_user(?)}");
            dbStatement.setInt("user_ID", user_ID);
            dbResultSet = dbStatement.executeQuery();
            result = new ArrayList<>();
            while(dbResultSet.next()){
                String username = dbResultSet.getString("username");
                String password = dbResultSet.getString("password");
                result.add(username);
                result.add(password);
            }
        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
            return null;
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
            DB_Connection.ClosingResultSet(dbResultSet);
        }
        return result;
    }
}
