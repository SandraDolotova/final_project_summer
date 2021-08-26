package users;
import db.DBHandler;
import db.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDBService {

    DBHandler dbHandler = new DBHandler();

    // to get user login name and password from DB for login validation
    public Map<String, String> userCheck() throws SQLException {
        Connection connection = dbHandler.getConnection();
        Map<String, String> mapResult = new HashMap<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(Queries.userValidation);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String nameKey = resultSet.getString("login_name");
                    String passValue = resultSet.getString("user_password");
                    mapResult.put(nameKey, passValue);
                }
              //  connection.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return mapResult;
    }

    // to validate userName input while register new user in the system
    public boolean checkLoginNameExists(String userLoginName) throws SQLException {
        boolean userLoginNameExists = false;
        try{
            PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(Queries.checkLoginNameExists);
            preparedStatement.setString(1, userLoginName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                userLoginNameExists = true;
                System.out.println("such login name already exists");
                }
            }catch(SQLException exc){
            exc.printStackTrace();
        }
        return userLoginNameExists;
    }

    //to register new user in DB
    public void addNewUser(String userName, String userPassword, String userEmail, int phoneNumber) throws SQLException {
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(Queries.insertNewUser);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, userPassword);
        preparedStatement.setString(3, userEmail);
        preparedStatement.setInt(4, phoneNumber);
        preparedStatement.execute();
        preparedStatement.close();
    }

    // to show all existing users to Admin
    public ArrayList<User> showUsers () throws SQLException { {
            ArrayList<User> users = new ArrayList<>();
            PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showUserList);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                users.add(new User(
                        result.getInt("id"),
                        result.getString("login_name"),
                        result.getString("user_name"),
                        result.getString("email"),
                        result.getInt("phone")));
            }
            pr.close();
            return users;
        }
    }
    // INSERT INTO GUEST LIST - customer inserts names
    public void insertGuests (String guestFullName) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.insertGuests);
        pr.setString(1, guestFullName);
        pr.execute();
        pr.close();
    }

    // DELETE FROM GUEST LIST
    public void deleteGuest(int guestId) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.deleteGuest);
        pr.setInt(1, guestId);
        pr.executeUpdate();
        pr.close();
    }
    // UPDATE GUEST LIST - customer sets participation status for his guests
    //
    public void setGuestStatus(String eventName) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.setGuestStatus);
        pr.setString(1, eventName);
        pr.executeUpdate();
        pr.close();
    }

    // SHOW ALL GUESTS FROM THE LIST
    public static final String showAllGuests = "SELECT * FROM event_guest_list";
    public ArrayList<User> showAllGuests() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showAllGuests);
        ResultSet result = pr.executeQuery();
        while (result.next()){
            users.add(new User(
                    result.getInt("guest_id"),
                    result.getString("guest_name"),
                    result.getBoolean("participation")));
        }
        pr.close();
        return users;
    }
}
