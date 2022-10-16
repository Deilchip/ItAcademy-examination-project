package by.ItAcademy.dao;

import by.ItAcademy.model.Movie;
import by.ItAcademy.model.User;

public interface MoviesDAO {
    boolean updateMovieName(User user ,Movie movie, String name);
    boolean updateMovieTime(User user , Movie movie);
    boolean movieExist(String name);
}
