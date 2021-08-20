package Panels;
import users.UserValidation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class WelcomePanel {

    public static JTextField loginField = new JTextField(10);
    public static JTextField passField = hidePassword();

    public static JPanel getWelcomePanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Login: "));
        loginPanel.add(loginField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passField);
        loginPanel.add(buttonEnter());
        return loginPanel;
    }
    public static JPasswordField hidePassword(){
        JPasswordField jPasswordField = new JPasswordField(10);
        jPasswordField.setEchoChar('*');
        return jPasswordField;
    }
    public static JButton buttonEnter() {
        JButton enter = new JButton("ENTER");
        enter.addActionListener(action());
        return enter;
    }
    public static ActionListener action() {
        ActionListener actionListener = e -> {
            UserValidation userValidation = new UserValidation();
            try {
                userValidation.login();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        };
        return actionListener;
    }
    public static void showWelcomeFrame() {
        JFrame frame = new JFrame("Welcome Panel");
        frame.pack();
        frame.add(getWelcomePanel());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
