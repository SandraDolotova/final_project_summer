package db;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import java.sql.*;

public class DBHandler {
    PropertiesConfiguration databaseProperties = new PropertiesConfiguration();

    private static Connection connection;

    public DBHandler() {
        try {
            databaseProperties.load("database.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        String pass = databaseProperties.getString("database.password");
        String user = databaseProperties.getString("database.user");
        String host = databaseProperties.getString("database.host");
        String port = databaseProperties.getString("database.port");
        String dbName = databaseProperties.getString("database.name");
        String connectionUrl = host + ":" + port + "/" + dbName + "?serverTimezone=GMT%2B3";

        try {
            connection = DriverManager.getConnection(connectionUrl, user, pass);
        } catch (SQLException ex) {
            System.out.println("Unable to connect to database");
            ex.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static void close(PreparedStatement pr, Connection connection) {
        try {
            pr.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void close (ResultSet result, PreparedStatement pr, Connection connection) throws SQLException {
        try {
            result.close();
            pr.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
