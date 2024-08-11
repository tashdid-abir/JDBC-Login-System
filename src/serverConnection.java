import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class serverConnection {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    private static final String url = "jdbc:mysql://localhost:3306/student_management_system";
    private static final String username = "root";
    private static final String password = "root";

    serverConnection() {

        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try {
                    statement = connection.createStatement();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try {
                connection = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

//    void verifyLogin() {
//        try {
//            String query = String.format("SELECT * FROM personal_details WHERE username = '%s' AND PASSWORD = '%s'", usernameTextField.getText(), new String(passwordField.getPassword()));
//            resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//
//                int ID = resultSet.getInt(1);
//                String Name = resultSet.getString(2);
//
//                System.out.println("ID : " + ID);
//                System.out.println("Username : " + Name);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

    static void addValue(String u_name, String u_pass) {
        try {
            statement = connection.createStatement();
            String query = String.format("INSERT INTO personal_details(id, stu_name, password) VALUES(%o, '%s', '%s')", 12 ,u_name, u_pass);
            statement.executeUpdate(query);
            JFrame frame2 = new JFrame("OK");
            frame2.setVisible(true);

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
