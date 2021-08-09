package Panels;
import com.sun.xml.internal.bind.v2.TODO;
import login.UserValidation;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class WelcomePanel {

    // TODO: 09.08.2021  how to * password inputs ;
    // TODO: 09.08.2021 addNewUser ; 
    // TODO: 09.08.2021  sql tables ;
    
    public static JTextField passField = new JTextField(10);
    public static JTextField loginField = new JTextField(10);

    public static JPanel getWelcomePanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Login: "));
        loginPanel.add(loginField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passField);
        loginPanel.add(buttonEnter());
        return loginPanel;
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
