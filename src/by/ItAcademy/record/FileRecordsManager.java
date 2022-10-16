package by.ItAcademy.record;

import by.ItAcademy.model.User;

public interface FileRecordsManager {
    boolean updateMovieName(User user );
    boolean updateMovieTime(User user );
    boolean buyUserTicket (User user);
    boolean returnUserTicket(User user);
}
