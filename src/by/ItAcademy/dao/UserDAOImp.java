package by.ItAcademy.dao;

import by.ItAcademy.connect.Connect;
import by.ItAcademy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImp implements UserDAO {
    @Override
    public StringBuilder seeEvents() {
        StringBuilder st = new StringBuilder();
        try {

            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Movie");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                st.append(rs.getInt("id"))
                        .append(": ")
                        .append(rs.getString("name"))
                        .append(" ")
                        .append(rs.getString("date"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return st;
    }





    @Override
    public int getUserId(User user) {

        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT id FROM user WHERE login = ? AND password=?");
            stmt.setString(1, String.valueOf(user.getLogin()));
            stmt.setString(2, String.valueOf(user.getPassword()));
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                return rs.getInt(1);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    return 0;
    }

    @Override
    public boolean registration(User user) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (login, password, role) SELECT ?,?,?");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3,"user");
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUser(String login) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement("SELECT login FROM user WHERE login=? ");
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String searchRole(User user) {
        String role="";
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement("SELECT role FROM user WHERE login=? AND password=?");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                user.setRole(rs.getString("role"));
                role=rs.getString("role");
            }
            stmt.close();
            conn.close();
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

}
