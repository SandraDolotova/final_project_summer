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

        String adminChoice = JOptionPane.showInputDialog(null, "Choose option:\n"
        + "\n1. Add Decoration"
        + "\n2. Delete Decoration"
        + "\n3. Change Decor Status"
        + "\n4. See All Decorations"
        + "\n5. See Single Decoration"
        + "\n6. Update Decor Price"
        + "\n8. Exit");
        switch (adminChoice){
            case "1":
                adminController.addDecorations();
                break;
            case "2":
                adminController.deleteDecoration();
                break;
            case "3":
               // adminController.decorStatus();
                break;
            case "4":
                adminController.getAllDecorsFromDB();
                break;
            case "5":
                adminController.getSingleDecorFromDB();
                break;
            case "6":
                adminController.updatePrice();
                break;
            case "7":
                break;
            case "8":
                System.exit(0);
                break;
            default:
                break;
        }
        adminMenu();
    }
}
