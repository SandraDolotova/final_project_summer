package DB;

public class Queries {

   public static final String userValidation = "SELECT login_name, user_password FROM user_validation";
   public static final String insertNewUser = "INSERT INTO user_validation (login_name, user_password, phone, email) VALUES (?, ?, ?, ?)";

}
