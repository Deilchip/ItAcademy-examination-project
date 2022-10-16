package by.ItAcademy.dao;

import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

public interface TicketDAO {
    boolean buyTicket(User user, Ticket ticket, String name);
    boolean returnTicket(User user,int id);
    StringBuilder seePurchasedTickets(User user);
    StringBuilder seeAllTickets(String name_film);
}
