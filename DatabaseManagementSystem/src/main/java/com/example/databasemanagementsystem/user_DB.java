package com.example.databasemanagementsystem;

import java.sql.CallableStatement;

public class user_DB {
    public static void add_user(String username, String password){
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

    public static void delete_user(String username, String password) {
        Connection dbConnection = Connection.Connect();
        CallableStatement dbStatement = null;

        /*try{
            dbStatement = dbConnection.prepareCall("{CALL delete_user(?,?}");
        }
        catch(SQLException e){
            Connection.getSQLException(e);
        }
        finally{
            Connection.Closing(dbStatement, dbConnection);
        }*/

    }
}
