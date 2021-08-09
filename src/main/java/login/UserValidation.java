package login;

import Panels.WelcomePanel;

import javax.swing.*;
import java.sql.SQLException;

public class UserValidation extends WelcomePanel {

    UserDBService userDBService = new UserDBService();
    String userInputLoginName = loginField.getText();
    String userInputPassword = passField.getText();

    // to validate user input according to names and passwords in DB
    public void login() throws SQLException {
        if (!userDBService.userCheck().containsKey(userInputLoginName) || !userDBService.userCheck().containsValue(userInputPassword)) {
            showMessageWarning();
        } else if (userDBService.userCheck().containsKey(userInputLoginName) &&
                userDBService.userCheck().containsValue(userInputPassword)) {
            showMessagePositive();
        }
    }
    private void showMessageWarning() {
        JOptionPane.showMessageDialog(dialogFrame, "Incorrect input. Try again", "warning", JOptionPane.WARNING_MESSAGE);
    }
    private void showMessagePositive() {
        JOptionPane.showMessageDialog(dialogFrame, "You are logged in successfully", "good", JOptionPane.PLAIN_MESSAGE);
    }
    private static JFrame dialogFrame;
}


