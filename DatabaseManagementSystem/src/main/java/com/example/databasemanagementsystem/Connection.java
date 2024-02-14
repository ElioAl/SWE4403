package com.example.databasemanagementsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connection {
    public static Connection Connect(){
        Connection dbConnection = null;
        Properties dbConnectionProps = new Properties();

        try{
            FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties");
            dbConnectionProps.load(inputStream);

            inputStream.close();

            Class.forName(dbConnectionProps.getProperty("driver-class-name")).newInstance();

            dbConnection = (Connection) DriverManager.getConnection(dbConnectionProps.getProperty("url"),
                    dbConnectionProps.getProperty("username"),
                    dbConnectionProps.getProperty("password"));
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
            /*try{
                //dbConnection.;
            }
            catch(SQLException e) {
                getSQLException(e);
            }*/
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
}
