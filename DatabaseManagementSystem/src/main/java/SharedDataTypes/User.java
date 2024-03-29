package SharedDataTypes;

public class User {
    private final int user_ID;
    private final String username;
    private final String password;

    public User(int user_IDIn, String usernameIn, String passwordIn){
        this.user_ID = user_IDIn;
        this.username = usernameIn;
        this.password = passwordIn;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
