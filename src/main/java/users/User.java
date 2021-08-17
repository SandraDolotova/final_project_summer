package users;
import lombok.Getter;
@Getter
public class User {

    int userId;
    String userName;
    String userFullName;
    String userPassword;
    String userEmail;
    int phoneNumber;
    boolean participation;


    public User(String userName, String userPassword, String userEmail, int phoneNumber) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public User(String userName, String userFullName, String userPassword, String userEmail, int phoneNumber) {
        this.userName = userName;
        this.userFullName = userFullName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public User(int userId, String userName, String userFullName, String userEmail, int phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public User(int userId, String userFullName, boolean participation) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.participation = participation;
    }

}
