package com.example.databasemanagementsystem;

import SharedDataTypes.User;
import org.apache.catalina.startup.UserConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

    static User UserLoggedIn;
    public static Connection Connect(){
        Connection dbConnection = null;
        Properties dbConnectionProps = new Properties();

        try{
            FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties");
            dbConnectionProps.load(inputStream);

            inputStream.close();

            String url=dbConnectionProps.getProperty("url");
            String username = dbConnectionProps.getProperty("username");
            String password = dbConnectionProps.getProperty("password");

            dbConnection=DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            getSQLException(e);
        }
        catch (Exception e) {
            return null;
        }
        return dbConnection;
    }

    public static void Closing(CallableStatement dbStatement, Connection dbConnection){
        if(dbStatement != null){
            try{
                dbStatement.close();
            } catch (SQLException e) {
                getSQLException(e);
            }

        }

        if(dbConnection != null){
            try{
                dbConnection.close();
            }
            catch(SQLException e) {
                getSQLException(e);
            }
        }
    }

    public static void ClosingResultSet(ResultSet dbResultSet){
        if(dbResultSet != null) {
            try {
                dbResultSet.close();
            } catch (SQLException ex) {
                getSQLException(ex);
            }
        }
    }

    public static void getSQLException(SQLException e){
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

    public static int getAuthority(String required){
        if(UserLoggedIn.getUserType().equals(required)){
            return 200;
        }
        return 400;
    }

    public static void setAuthority(String username, String password){
        UserLoggedIn = user_DB.login(username, password);
    }

//    public static void main(String[] args){
//        //Connection dbConnection = Connect();
//        System.out.println("Connected");
//        DBAccess dbAccess = new DBAccess();
//        dbAccess.add_user("TEst", "Testing");
//        ArrayList<String> res = dbAccess.get_User(2);
//        for (String re : res) {
//            System.out.println(re);
//        }
//        dbAccess.delete_user("TEst", "Testing");
//        ArrayList<String> resu = dbAccess.get_User(2);
//        for (String re : resu) {
//            System.out.println(re);
//        }
//    }
}
