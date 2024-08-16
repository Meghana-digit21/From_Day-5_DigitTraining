
import java.sql.*;

public class BasicConnection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Workshop Database";
        String username = "postgres";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
