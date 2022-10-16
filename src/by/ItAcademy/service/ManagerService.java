package by.ItAcademy.service;

import by.ItAcademy.model.Movie;
import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

public interface ManagerService {
    boolean updateMovieName(User user ,Movie movie, String name);
    boolean updateMovieTime(User user , Movie movie);
    boolean buyUserTicket (User user, Ticket Ticket);
    boolean returnUserTicket(User user, Ticket ticket);

}
