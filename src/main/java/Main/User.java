package Main;

public class User {
    private static final User instance = new User();
    private String username;
    private User(){}
    public static User getInstance(){
        return instance;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }




}
