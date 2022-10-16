package by.ItAcademy.service;

import by.ItAcademy.dao.MoviesDAOImp;
import by.ItAcademy.model.Movie;
import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

public class ManagerServiceImp implements ManagerService {
MoviesDAOImp dao = new MoviesDAOImp();

    @Override
    public boolean updateMovieName(User user, Movie movie,String name) {
        return dao.updateMovieName(user ,movie, name);
    }

    @Override
    public boolean updateMovieTime(User user, Movie movie) {
        return false;
    }

    @Override
    public boolean buyUserTicket(User user, Ticket Ticket) {
        return false;
    }

    @Override
    public boolean returnUserTicket(User user, Ticket ticket) {
        return false;
    }
}
