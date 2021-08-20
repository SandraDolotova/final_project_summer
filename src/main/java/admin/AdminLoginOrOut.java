package admin;

import java.util.Scanner;

public class AdminLoginOrOut {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();

    public void adminLogIn(){
        System.out.println("Welcome to the event application log in page!\n");
        System.out.println("Enter your email: ");
        admin.email = scanner.nextLine();
        System.out.println("Enter password!");
        admin.password = scanner.nextLine();
    }

    public void adminLogOut(){

    }
}
