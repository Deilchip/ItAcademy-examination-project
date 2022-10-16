package by.ItAcademy.service;

import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

public interface UserService {
    StringBuilder seeEvents();
    boolean buyTicket(User user, Ticket ticket, String name);
    boolean returnTicket(User user, Ticket ticket);
    StringBuilder seePurchasedTickets(User user);
    StringBuilder seeAllTickets(String name_film);
    String authorization(User user);
    boolean registration (User user);
    boolean checkExistUser (User user);
}
