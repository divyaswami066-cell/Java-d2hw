
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "MYSQL123";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("MySQL Connected Successfully!");
            System.out.println("-----------------------------");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM students"
            );

            System.out.println("ID | Name | Marks");
            System.out.println("-----------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(
                    id + " | " + name + " | " + marks
                );
            }

            rs.close();
            stmt.close();
            con.close();

            System.out.println("-----------------------------");
            System.out.println("Connection Closed Successfully!");

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}
