package customer;

import db.DBHandler;
import db.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustomerDBService {
    DBHandler dbHandler = new DBHandler();

    // to get user login name and password from DB
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

    //to register new user to DB
    public void addNewUser(String userName, String userPassword, String userEmail, int phoneNumber) throws SQLException {
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(Queries.insertNewUser);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, userPassword);
        preparedStatement.setString(3, userEmail);
        preparedStatement.setInt(4, phoneNumber);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
