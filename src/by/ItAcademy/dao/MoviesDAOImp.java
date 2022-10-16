package by.ItAcademy.dao;

import by.ItAcademy.connect.Connect;
import by.ItAcademy.model.Movie;
import by.ItAcademy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviesDAOImp implements MoviesDAO {
    @Override
    public boolean updateMovieName(User user, Movie movie, String name) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement
                    ("Update movie SET name=? WHERE name=? ");
            stmt.setString(1, name);
            stmt.setString(2, movie.getName());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean updateMovieTime(User user, Movie movie) {
        return false;
    }

    @Override
    public boolean movieExist(String name) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT name FROM movie WHERE name=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                stmt.close();
                conn.close();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
