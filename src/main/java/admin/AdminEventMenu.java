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
                + "\n5. Update Event Name"
                + "\n6. Update Event Date"
                + "\n7. Update Event Time"
                + "\n8. Update Event Location"
                + "\n9. Update Event Guest Amount"
                + "\n10. Exit");

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
                adminController.updateNameEvent();
                break;
            case "6":
                adminController.updateDate();
                break;
            case "7":
                adminController.updateTime();
                break;
            case "8":
                adminController.updateLocation();
                break;
            case "9":
                adminController.updateGuestAmount();
                break;
            case "10":
                System.exit(0);
                break;
            default:
                break;
        }
        adminEventMenu();
    }
}
