package entities;

public class User {

    public static User PETER = new User("epam", "1234");
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
