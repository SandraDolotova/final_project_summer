package customer;

public class Customer {
    String userName;
    String userPassword;
    String userEmail;
    int phoneNumber;

    public Customer() {}

    public Customer(String userName, String userPassword, String userEmail, int phoneNumber) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;

    }
}
