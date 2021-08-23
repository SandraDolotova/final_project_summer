package admin;
import javax.swing.*;
import java.util.Scanner;

public class AdminMenu {
    AdminController adminController = new AdminController();
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();

    public void adminLogIn(){
        try {
            System.out.println("Welcome to the event application log in page!\n");
            System.out.println("Enter your email: ");
            admin.email = scanner.nextLine();
            System.out.println("Enter password!");
            admin.password = scanner.nextLine();
            adminMenu();
            adminLogOut();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adminLogOut(){}

    public void adminMenu(){
        String adminChoice = JOptionPane.showInputDialog("Choose option:");
        switch (adminChoice){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            default:
                break;
        }
    }
}
