package admin;

import javax.swing.*;

public class AdminEventMenu {
    AdminController adminController = new AdminController();

    public void adminEventMenu(){

        String adminChoice = JOptionPane.showInputDialog(null, "Choose option:\n"
                + "\n1. Add Event"
                + "\n2. Delete Event"
                + "\n3. View All Events"
                + "\n4. View Single Event"
                + "\n5. Update Event Date"
        + "\n8. Exit");

        switch (adminChoice){
            case "1":
                adminController.addEvent();
                break;
            case "2":
                adminController.deleteEventFromDB();
                break;
            case "3":
                adminController.getAllEventsFromDB();
                break;
            case "4":
                adminController.getSingleEventFromDB();
                break;
            case "5":
                adminController.updateDate();
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                System.exit(0);
                break;
            default:
                break;
        }
        adminEventMenu();
    }
}
