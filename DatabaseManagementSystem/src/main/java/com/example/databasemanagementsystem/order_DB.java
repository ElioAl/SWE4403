package com.example.databasemanagementsystem;

import SharedDataTypes.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class order_DB {
    public static int addOrder(int user_id){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        int result = 0;
        ResultSet dbResultSet = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL addOrder(?)}");
            dbStatement.setInt("user_ID", user_id);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()) {
                result = dbResultSet.getInt(1);
            }

        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
            DB_Connection.ClosingResultSet(dbResultSet);
        }
        return result;
    }

    public static void addToOrder(int order_ID, int user_id, Product toInsert){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL addOrder(?)}");
            dbStatement.setInt("order_ID", order_ID);
            dbStatement.setInt("product_ID", toInsert.getProduct_ID());
            dbStatement.setInt("user_ID", user_id);
            dbStatement.executeQuery();

        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }
}
