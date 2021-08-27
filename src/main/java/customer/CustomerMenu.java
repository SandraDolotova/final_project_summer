package customer;

import admin.Admin;
import admin.AdminController;

import javax.swing.*;
import java.util.Scanner;

public class CustomerMenu {

    CustomerController customerController = new CustomerController();
    Scanner scanner = new Scanner(System.in);

    public void customerMenu(){

        String customerChoice = JOptionPane.showInputDialog(null, "Please choose option:\n"
                + "\n1. Add New Event"
                + "\n2. Create Guest List"
                + "\n3. Choose Decorations"
                + "\n4. Exit");
        switch (customerChoice){
            case "1":
                customerController.addNewEvent();
                break;
            case "2":
                customerController.insertGuests();
                break;
            case "3":
                customerController.chooseDecorations();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                break;
        }
        customerMenu();
    }
}

