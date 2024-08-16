
import java.sql.*;

public class ExecuteSimpleQuery {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Workshop Database";
        String username = "postgres";
        String password = "root";
        String query = "select * from customers";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery();) {
            System.out.println("Connection Established Successfully");
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 1; i < columns; i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                for(int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
