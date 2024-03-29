package com.example.databasemanagementsystem;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import SharedDataTypes.*;

public class user_DB {
    public static void add_user(String username, String password, String type){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL add_user(?,?)}");
            dbStatement.setString("username", username);
            dbStatement.setString("password", password);
            dbStatement.setString("type", type);
            dbStatement.executeQuery();

        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static void delete_user(String username, String password){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try {
            dbStatement = dbConnection.prepareCall("{CALL delete_user(?,?)}");
            dbStatement.setString("username", username);
            dbStatement.setString("password", password);
            dbStatement.executeQuery();
        } catch (SQLException e) {
            DB_Connection.getSQLException(e);
        } finally {
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static User get_user(int user_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        ResultSet dbResultSet = null;
        User result = null;
        try{
            dbStatement = dbConnection.prepareCall("{CALL get_user(?)}");
            dbStatement.setInt("user_ID", user_ID);
            dbResultSet = dbStatement.executeQuery();
            while(dbResultSet.next()){
                String username = dbResultSet.getString("username");
                String password = dbResultSet.getString("password");
                String type = dbResultSet.getString("type");
                result = new User(user_ID, username, password, type);
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

    public static String getAuthority(int user_id){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        ResultSet dbResultSet = null;
        String res = "";
        try{
            dbStatement = dbConnection.prepareCall("{CALL get_user_authority(?)}");
            dbStatement.setInt("user_ID", user_id);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()){
                res = dbResultSet.getString("type");
            }
        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        } finally {
            DB_Connection.Closing(dbStatement, dbConnection);
            DB_Connection.ClosingResultSet(dbResultSet);
        }
        return res;
    }
}
