package Main;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String dataName = "QLPT";
        String dataUser = "sa";
        String dataPassword = "123";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dataName + ";encrypt=true;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            databaseLink = DriverManager.getConnection(url, dataUser, dataPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
