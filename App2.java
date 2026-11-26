
import java.sql.*;

public class App2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "MySQL123";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM employees"
            )
        ) {
            System.out.println("MySQL Connected!");
            System.out.println("Employee Details:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getInt("salary")
                );
            }

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
