import java.sql.*;

public class PatientInfoDisplay {

    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM patients");

            System.out.println("Patient Information:");
            System.out.println("--------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-10s%n", "ID", "Name", "Problem", "Bill");
            System.out.println("--------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");
                System.out.printf("%-10d %-20s %-20s %-10.2f%n", id, name, problem, bill);
            }
            System.out.println("--------------------------------------");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
