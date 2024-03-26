package unb.microservices.PCS;
//singleton class to manage db instance.
public class DBConnection {
    private static DBConnection DBInstance;
    private DBConnection () {}

    public DBConnection getDBInstance() {
        if (DBInstance == null)
            DBInstance = new DBConnection();
        return DBInstance;
    }

    //specific update/read methods
}