package by.ItAcademy.dao;

import by.ItAcademy.connect.Connect;
import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAOImp implements TicketDAO {
    @Override
    public boolean buyTicket(User user, Ticket ticket, String name) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt1 = conn.prepareStatement
                    ("UPDATE tickets SET login=? , purchase='1' WHERE name_film=? AND №place=? AND purchase='0'");
            stmt1.setString(1,user.getLogin());
            stmt1.setString(2,name);
            stmt1.setInt(3,ticket.getPlace());
            stmt1.executeUpdate();
            stmt1.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public boolean returnTicket(User user,int id) {
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt1 = conn.prepareStatement
                    ("UPDATE tickets SET login=? , purchase=? WHERE id=? AND login=? AND purchase='1'");
            stmt1.setString(4, user.getLogin());
            seePurchasedTickets(user);
            stmt1.setInt(3, id);
            stmt1.setString(1, "");
            stmt1.setBoolean(2, false);
            stmt1.executeUpdate();
            stmt1.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public StringBuilder seePurchasedTickets(User user) {
        StringBuilder st = new StringBuilder();
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT id,№place,name_film,price FROM tickets WHERE login=?");
            stmt.setString(1, user.getLogin());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                st.append("купленные билеты:")
                        .append(" фильм: ")
                        .append(rs.getString("name_film"))

                        .append(" место в зале:")
                        .append(rs.getInt("№place"))
                        .append(" стоимость купленного билета:")
                        .append(rs.getInt("price"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    @Override
    public StringBuilder seeAllTickets(String name) {
        StringBuilder st = new StringBuilder();
        try {
            Connection conn = Connect.get();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT №place,name_film,price,purchase FROM tickets WHERE name_film=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean purchase = rs.getBoolean("purchase");
                if (!purchase) {
                    st.append("место:")
                            .append(rs.getInt("№place"))
                            .append(" Название фильма:")
                            .append(rs.getString("name_film"))
                            .append(" цена билета (в бел. рублях):")
                            .append(rs.getInt("price"))
                            .append(" Куплен ли билет -")
                            .append(rs.getBoolean("purchase"))
                            .append("\n");
                }


            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

}
