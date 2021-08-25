package admin;

import db.DBHandler;
import db.Queries;
import decor.Decor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDBService {
    DBHandler dbHandler = new DBHandler();
//all methods with queries in here
    public void addDecorationsToDB(String name, int quantity, double price) throws SQLException {
        Connection connection = dbHandler.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Queries.insertNewDecor);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setDouble(3, price);
        preparedStatement.execute();
        preparedStatement.close();
    }

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
