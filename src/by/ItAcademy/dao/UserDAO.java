package by.ItAcademy.dao;

import by.ItAcademy.model.User;

public interface UserDAO {
    StringBuilder seeEvents();
    int getUserId(User user);
    boolean registration(User user);
    boolean checkUser (String login);
}
