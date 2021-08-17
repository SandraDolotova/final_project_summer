package customer;

import javax.swing.*;
import java.sql.SQLException;

public class CustomerRegistration {
    CustomerDBService userDBService = new CustomerDBService();

    //to get data from user Input
    public void collectNewUserInfo() throws SQLException {
        try{
            String userName = JOptionPane.showInputDialog(null, "Enter your name: ");
            String userPassword = JOptionPane.showInputDialog(null, "Create password: ");
            String userEmail = JOptionPane.showInputDialog(null, "Enter your email: ");
            int phoneNumber = JOptionPane.showConfirmDialog(null, "Enter your phone number: ");
            userDBService.addNewUser(userName, userPassword, userEmail, phoneNumber);
            JOptionPane.showMessageDialog(null, "Thank you for registration. Now. please log in");
        }catch (SQLException exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR. New user ws not added");
        }
    }
}
