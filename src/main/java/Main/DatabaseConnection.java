package Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection() {
        String dataName = "login";
        String dataUser = "root";
        String dataPassword = "hung55410";
        String url = "jdbc:mysql://localhost:3306/" + dataName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, dataUser, dataPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
