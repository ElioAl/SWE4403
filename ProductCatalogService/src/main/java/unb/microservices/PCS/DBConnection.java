package unb.microservices.PCS;
//singleton class to manage db instance.
public class DBConnection {
    private static volatile DBConnection DBInstance;
    private DBConnection () {}

    public static DBConnection getDBInstance() {
        if (DBInstance == null)
            DBInstance = new DBConnection();
        return DBInstance;
    }


    public void createProduct() {

    }



    //specific update/read methods
}