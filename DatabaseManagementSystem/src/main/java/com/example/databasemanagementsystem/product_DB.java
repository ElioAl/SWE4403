package com.example.databasemanagementsystem;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

public class product_DB {
    public void add_Product(String product_name, double product_price){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL add_product(?,?)}");
            dbStatement.setString("product_name", product_name);
            dbStatement.setDouble("product_price", product_price);
            dbStatement.executeQuery();
        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public void get_product(String product_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL get_product(?)}");
            dbStatement.setString("product_ID", product_ID);
            dbStatement.executeQuery();
        } catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally {
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }
}
