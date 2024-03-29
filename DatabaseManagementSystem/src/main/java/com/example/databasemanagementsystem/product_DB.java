package com.example.databasemanagementsystem;

import SharedDataTypes.Product;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

public class product_DB {
    public static void add_product(String product_name, double product_price, int quantity){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL add_product(?,?,?)}");
            dbStatement.setString("product_name", product_name);
            dbStatement.setDouble("product_price", product_price);
            dbStatement.setInt("product_quanity", quantity);
            dbStatement.executeQuery();
        }
        catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally{
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static void get_product(int product_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        ResultSet dbResultSet = null;
        ArrayList<Product> result = null;

        try{
            result = new ArrayList<>();
            dbStatement = dbConnection.prepareCall("{CALL get_product(?)}");
            dbStatement.setInt("product_ID", product_ID);
            dbResultSet = dbStatement.executeQuery();
            while(dbResultSet.next()){
                String name = dbResultSet.getString("product_name");
                double cost = dbResultSet.getDouble("product_cost");
                int quantity = dbResultSet.getInt("product_quanity");
                Product prod = new Product(product_ID, name, cost, quantity);
                result.add(prod);
            }
        } catch(SQLException e){
            DB_Connection.getSQLException(e);
        }
        finally {
            DB_Connection.Closing(dbStatement, dbConnection);
            DB_Connection.ClosingResultSet(dbResultSet);
        }
    }

    public static void setProductQuantity(int product_ID, int quantity){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL update_quantity(?,?)}");
            dbStatement.setInt("product_ID", product_ID);
            dbStatement.setInt("product_quantity", quantity);
            dbStatement.executeQuery();
        } catch (SQLException e){
            DB_Connection.getSQLException(e);
        } finally {
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static void updateProduct(Product toUpdate){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;

        try{
            dbStatement = dbConnection.prepareCall("{CALL updateProduct(?,?,?,?)}");
            dbStatement.setInt("product_ID", toUpdate.getProduct_ID());
            dbStatement.setString("product_name", toUpdate.getName());
            dbStatement.setDouble("product_cost", toUpdate.getCost());
            dbStatement.setInt("product_quantity", toUpdate.getQuantity());
            dbStatement.executeQuery();
        } catch(SQLException e){
            DB_Connection.getSQLException(e);
        } finally {
            DB_Connection.Closing(dbStatement, dbConnection);
        }
    }

    public static Product deleteProduct(int product_ID){
        Connection dbConnection = DB_Connection.Connect();
        CallableStatement dbStatement = null;
        Product result = null;
        ResultSet dbResultSet = null;
        try{

            dbStatement = dbConnection.prepareCall("{CALL deleteProduct(?)}");
            dbStatement.setInt("product_ID", product_ID);
            dbResultSet = dbStatement.executeQuery();
            if(dbResultSet.next()){
                int id = dbResultSet.getInt("Product_ID");
                String name = dbResultSet.getString("product_name");
                double cost = dbResultSet.getDouble("product_cost");
                int quantity = dbResultSet.getInt("product_quantity");
                result = new Product(id, name, cost, quantity);
            }
        } catch(SQLException e){
            DB_Connection.getSQLException(e);
        } finally {
            DB_Connection.Closing(dbStatement, dbConnection);
        }
        return result;
    }
}
