package by.ItAcademy.service;

import by.ItAcademy.dao.TicketDAOImp;
import by.ItAcademy.dao.UserDAOImp;
import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServiceImp implements UserService {
    private UserDAOImp userDao = new UserDAOImp();
    private TicketDAOImp ticketDao = new TicketDAOImp();

    @Override
    public StringBuilder seeEvents() {
        return userDao.seeEvents();
    }

    @Override
    public boolean buyTicket(User user, Ticket ticket , String name) {

        return ticketDao.buyTicket(user, ticket, name);
    }

    @Override
    public boolean returnTicket(User user, Ticket ticket) {

        return ticketDao.returnTicket(user, ticket.getId());
    }

    @Override
    public StringBuilder seePurchasedTickets(User user) {
        return ticketDao.seePurchasedTickets(user);
    }

    @Override
    public StringBuilder seeAllTickets(String name) {
        return ticketDao.seeAllTickets(name);
    }

    @Override
    public String authorization(User user) {
        return userDao.searchRole(user);
    }

    @Override
    public boolean registration(User user) {
        return userDao.registration(user);
    }

    @Override
    public boolean checkExistUser(User user) {
        return userDao.checkUser(user.getLogin());
    }

    public String getHash(String password) throws NoSuchAlgorithmException {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(password.getBytes(),0,password.length());
       return new BigInteger(1,m.digest()).toString(16);
    }

}
