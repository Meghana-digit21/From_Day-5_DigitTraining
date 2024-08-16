import java.sql.*;

public class InsertDataUsingPreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Workshop Database";
        String username = "postgres";
        String password = "root";
        String query = "insert into customers (customer_id, name, email) values (?, ?, ?)";

        int customer_id = 6;
        String name = "Jack Green";
        String email = "jackgreen@example.com";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(query);) {
            System.out.println("Connection Established Successfully!");
            st.setInt(1, customer_id);
            st.setString(2, name);
            st.setString(3, email);


            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0) {
                System.out.println("Record inserted successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}