package events;
import lombok.Getter;
import java.sql.Date;

@Getter
public class Event {

    int eventId;
    String eventName;
    Date dueDate;
    String location;
    int guestNumber;


    public Event(int eventId, String eventName, Date dueDate, String location, int guestNumber) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.dueDate = dueDate;
        this.location = location;
        this.guestNumber = guestNumber;
    }
}
