package by.ItAcademy.connect;

import java.sql.*;

public class Connect {
    private static Connection conn ;
    private static final String URL = "jdbc:mysql://localhost:3334/app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static java.sql.Connection get() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("драйвер не установлен", e);
        }
        return conn;
    }
    public static void closeConnection(){
        try {
            conn.close();
            System.out.println("connection closed");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}