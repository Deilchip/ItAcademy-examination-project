package by.ItAcademy.record;

import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

import java.io.IOException;

public interface FileRecordsUser {

    void registration(User user) throws IOException;
    void authorization(User user)throws IOException;
    void openMenu(User user)throws IOException;
    void openFilmMenu(User user)throws IOException;
    void openTicketMenu(User user)throws IOException;
    void buyTicket(User user, Ticket ticket)throws IOException;
    void returnTicket(User user, Ticket ticket)throws IOException;
    void seePurchasedTicket(User user)throws IOException;
    void userLogOut(User user)throws IOException;
}
