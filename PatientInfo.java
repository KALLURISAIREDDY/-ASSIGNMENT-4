import java.sql.*;

public class PatientInfo {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "siva", " ");

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT patient_id, name, problem, bill FROM patients");

            while (rs.next()) {
                int Id = rs.getInt("patientid");
                String name = rs.getString("name");
                String problem = rs.getString("problem");
                double bill = rs.getDouble("bill");

                System.out.println("Patient ID: " + Id);
                System.out.println("Name: " + name);
                System.out.println("Problem: " + problem);
                System.out.println("Bill: " + bill);
                System.out.println();
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
          
