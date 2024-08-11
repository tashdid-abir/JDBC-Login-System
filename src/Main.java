//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


public class Main {

//    private  static  final String url = "jdbc:mysql://localhost:3306/student_management_system";
//    private  static  final String username = "root";
//    private static final String password = "root";

    public static void main(String[] args) {

        new loginPage();
//        serverConnection serverConnection = new serverConnection();
//        serverConnection.printTable();
//        {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//            } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//
//            try {
//                Connection connection = DriverManager.getConnection(url, username, password);
//
//                Statement statement = connection.createStatement();
//                String query = "SELECT * FROM personal_details";
//
//
//                ResultSet resultSet = statement.executeQuery(query);
//
//                while (resultSet.next()) {
//
//                    int ID = resultSet.getInt(1);
//                    String Name = resultSet.getString(2);
//
//                    System.out.println("ID : " + ID);
//                    System.out.println("Username : " + Name);
//                }
//
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }

    }
}