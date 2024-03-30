package com.example.databasemanagementsystem;

import SharedDataTypes.Order;
import SharedDataTypes.Order_Tracking;
import SharedDataTypes.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class order_DB {

    public static int getOrderUser(int order_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        int result = 0;
        ResultSet dbResultSet = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL getUserOrder(?)}");
            dbStatement.setInt("user_ID", order_ID);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()) {
                result = dbResultSet.getInt("user_ID");
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

    public static Order_Tracking getOrderStatus(int user_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        Order_Tracking result = null;
        ResultSet dbResultSet = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL getIrder(?)}");
            dbStatement.setInt("user_ID", user_ID);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()) {
                String res = dbResultSet.getString("status");
                result = Order_Tracking.valueOf(res);
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
