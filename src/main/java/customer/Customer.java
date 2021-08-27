package customer;

public class Customer {

    int userId;
    String firstName;
    String lastName;
    String customerPassword;
    String customerEmail;
    int customerPhoneNumber;

    public Customer(int userId, String firstName, String lastName, String customerPassword, String customerEmail, int customerPhoneNumber) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerPassword = customerPassword;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

}




