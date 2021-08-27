package customer;

import admin.AdminDBService;
import decor.Decor;
import decor.DecorDBService;
import events.EventDBService;
import sun.util.calendar.BaseCalendar;
import users.UserDBService;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerController {
    UserDBService userDBService = new UserDBService();
    DecorDBService decorDBService = new DecorDBService();
    EventDBService eventDBService = new EventDBService();

    private String decorListTitle = "ID \t| Name \t| Quantity \t| Price \t| Price vat \t| Status\n";
    private String guestListTitle = "ID \t| Full Name \t| Phone number  \t| Participation\n";
    private String eventTitle = "ID \t| Name \t| Date \t| Location \t| Guest number vat \t| Status\n";

    public void addNewEvent() {
        try {
            String name = JOptionPane.showInputDialog(null, "Event name:");
            String date = JOptionPane.showInputDialog(null, "Event date:");
            String location = JOptionPane.showInputDialog(null, "Location:");
            int guestNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Guest number:"));
            eventDBService.insertNewEvent(name, date, location, guestNumber);
            JOptionPane.showMessageDialog(null, "New event added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while adding event");
        }
    }

    public void insertGuests(){}

    public void deleteGuest(){
        String info = "Enter guest ID:";
        int guestId = Integer.parseInt(JOptionPane.showInputDialog(info));
        try {
            userDBService.deleteGuest(guestId);
            JOptionPane.showMessageDialog(null, "Guest deleted successfully!");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while deleting guest");
        }
    }

    public void setGuestStatus(){}

    public void showAllGuests(){}

    public void chooseDecorations() {}
}

