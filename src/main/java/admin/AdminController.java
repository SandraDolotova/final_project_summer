package admin;
import decor.Decor;
import decor.DecorDBService;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AdminController {
AdminDBService adminDBService = new AdminDBService();
DecorDBService decorDBService = new DecorDBService();

    private String decorListTitle = "ID \t| Name \t| Quantity \t| Price \t| Price vat \t| Status\n";

//funkcijas, kas strādā:
    public void addDecorations(){
        try {
            String name = JOptionPane.showInputDialog(null, "Decor name:");
            int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Decor quantity:"));
            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Decor price:"));
            String status = JOptionPane.showInputDialog(null, "Decor status:");
            decorDBService.insertNewDecor(name, quantity, price, status);
            JOptionPane.showMessageDialog(null,"New decor added successfully!");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while adding decor");
        }
    }
    public void deleteDecoration(){
        String info = "Enter decor ID:";
        int decorId = Integer.parseInt(JOptionPane.showInputDialog(info));
        try {
            decorDBService.deleteDecor(decorId);
            JOptionPane.showMessageDialog(null, "Decor deleted successfully!");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while deleting decor");
        }
    }
    public void getAllDecorsFromDB(){
        ArrayList<Decor> decorList = new ArrayList<>();
        try {
            decorList = decorDBService.showAllDecorAdmin();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println();
        }
        String message = decorListTitle + decorList.stream().map(Decor::toString).collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, message);
    }
    public void getSingleDecorFromDB(){
        String decorId = JOptionPane.showInputDialog(null, "Enter decor ID:");
        Decor decor = null;
        try {
            decor = decorDBService.showSingleDecor(Integer.parseInt(decorId));
        }catch (SQLException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, decorListTitle + decor);
    }




    //funkcijas, kas nestrādā:
    public void updatePrice(){
        try {
            int decorId = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter decor ID you want to update:"));
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new price:"));
            decorDBService.updateDecorPrice(decorId, newPrice);
            JOptionPane.showMessageDialog(null, "Decor price updated successfully!");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while updating decor price");
        }
    }

    public void decorStatus(){
        String info = "Enter decor ID:";
        int decorId  = Integer.parseInt(JOptionPane.showInputDialog(info));
        String decorStatus = "Enter decor status:";
        try {
            decorDBService.setDecorStatus(decorId, decorStatus);
            JOptionPane.showMessageDialog(null, "Decor status updated successfully!");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while updating decor status");

        }
    }
    public void updateDecoration(){}



    public void addFreeDates(){}
    public void updateEvent(){
        //date
        //type
        //location
        //decoration
        //payment
        //participants

    }
    public void deleteEvent(){
        //date
        //type
        //location
        //decoration
        //payment
        //participants
    }
    public void checkPlannedEventList(){}
    public void checkPaymentStatus(){}
}
