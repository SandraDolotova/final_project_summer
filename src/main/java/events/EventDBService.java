package events;

import db.DBHandler;
import db.Queries;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDBService {
    DBHandler dbHandler = new DBHandler();

    // INSERT INTO EVENTS
    public void insertNewEvent(String eventName, Date dueDate, String location, int guestNumber) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.insertNewEvent);
        pr.setString(1, eventName);
        pr.setDate(2, dueDate);
        pr.setString(3, location);
        pr.setInt(4, guestNumber);
        pr.execute();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    // DELETE EVENT

    public static final String deleteEvent = "DELETE FROM events WHERE event_name = ?";
    public void deleteEvent(String eventName) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.deleteEvent);
        pr.setString(1, eventName);
        pr.executeUpdate();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    // UPDATE EVENT date
    public static final String updateEventDate = "UPDATE events SET dueDate = ? WHERE event_name = ?";
    public void updateEventDate(String eventName) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.updateEventDate);
        pr.setString(1, eventName);
        pr.executeUpdate();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    // SHOW EVENT LIST for ADMIN
    public ArrayList<Event> showAllEvents () throws SQLException {
        ArrayList<Event> events = new ArrayList<>();
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showAllEvents);
        ResultSet result = pr.executeQuery();
        while (result.next()) {
            events.add(new Event(
                    result.getInt("event_id"),
                    result.getString("event_name"),
                    result.getDate("dueDate"),
                    result.getString("location_name"),
                    result.getInt("guests_number")));
        }
        DBHandler.close(pr, dbHandler.getConnection());
        return events;
    }
    // SHOW ONE EVENT
    public static final String showSingleEvent = "SELECT event_id, event_name, dueDate, location_name, guests_number FROM events WHERE event_name = ?";
    public Event showSingleEvent(String eventName) throws SQLException {
        Event event = null;
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showSingleEvent);
        pr.setString(1, eventName);
        ResultSet result = pr.executeQuery();
        if(result.next()){
            event = new Event(
                    result.getInt("event_id"),
                    result.getString("event_name"),
                    result.getDate("dueDate"),
                    result.getString("location_name"),
                    result.getInt("guests_number"));
            DBHandler.close(pr, dbHandler.getConnection());
        }return event;
    }






}
