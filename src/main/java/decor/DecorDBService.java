package decor;
import db.DBHandler;
import db.Queries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DecorDBService {
    DBHandler dbHandler = new DBHandler();

    // INSERT DECORATION INTO TABLE
    public void insertNewDecor(String decorName, int decorQwt, double decorPrice) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.insertNewDecor);
        pr.setString(1, decorName);
        pr.setInt(2, decorQwt);
        pr.setDouble(3, decorPrice);
        pr.execute();
        DBHandler.close(pr, dbHandler.getConnection());
        }

    //SET DECOR STATUS - value chosen by ADMIN from ComboBox = like out of stock, broken, not available
    public void setDecorStatus (String decorStatus) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.setDecorStatus);
        pr.setString(1, decorStatus);
        pr.execute();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    //DELETE DECOR
    public void deleteDecor(int decorId) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.deleteDecor);
        pr.setInt(1, decorId);
        pr.executeUpdate();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    // UPDATE DECOR PRICE IN TABLE
    public void updateDecorPrice(int decorId) throws SQLException {
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.updateDecorPrice);
        pr.setInt(1, decorId);
        pr.executeUpdate();
        DBHandler.close(pr, dbHandler.getConnection());
    }
    // SHOW ALL DECORATIONS FOR CUSTOMER
    //if(decorStatus = available) -> showAllDecor();
    public ArrayList<Decor> showAllDecorCustomer() throws SQLException {
        ArrayList<Decor> decors = new ArrayList<>();
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showAllDecorCustomer);
        ResultSet result = pr.executeQuery();
        while (result.next()){
            decors.add(new Decor(
                    result.getInt("decor_id"),
                    result.getString("decor_name"),
                    result.getInt("decor_qwt"),
                    result.getDouble("decor_price_vat")));
        }
        DBHandler.close(pr, dbHandler.getConnection());
        return decors;
    }
    // SHOW ALL DECORATIONS FOR ADMIN
    public ArrayList<Decor> showAllDecorAdmin() throws SQLException {
        ArrayList<Decor> decors = new ArrayList<>();
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showAllDecorAdmin);
        ResultSet result = pr.executeQuery();
        while (result.next()){
            decors.add(new Decor(
                    result.getInt("decor_id"),
                    result.getString("decor_name"),
                    result.getInt("decor_qwt"),
                    result.getDouble("decor_price"),
                    result.getDouble("decor_price_vat"),
                    result.getString("decor_status")));
        }
        DBHandler.close(pr, dbHandler.getConnection());
        return decors;
    }
    // SHOW SINGLE DECOR ITEM BY ID
    public static final String showSingleDecorByID = "SELECT decor_id, decor_name, decor_qwt, decor_price_vat FROM decor_list WHERE decor_id = ?";
    public Decor showSingleDecor(int decorId) throws SQLException {
        Decor decor = null;
        PreparedStatement pr = dbHandler.getConnection().prepareStatement(Queries.showSingleDecorByID);
        pr.setInt(1, decorId);
        ResultSet result = pr.executeQuery();
        if(result.next()){
            decor = new Decor(
                    result.getInt("decor_id"),
                    result.getString("decor_name"),
                    result.getInt("decor_qwt"),
                    result.getDouble("decor_price_vat"));
            DBHandler.close(pr, dbHandler.getConnection());
        }return decor;
    }

}




