package com.example.databasemanagementsystem;

import SharedDataTypes.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class order_tracking_DB {
    public static String getOrder(int order_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        ResultSet dbResultSet = null;
        String temp = null;
        try{
            dbStatement = dbConnection.prepareCall("{CALL get_order(?)}");
            dbStatement.setInt("order_ID", order_ID);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()){
                temp = dbResultSet.getString("status");
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
        return temp;
    }
}
