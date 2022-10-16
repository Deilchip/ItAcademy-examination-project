package by.ItAcademy.model;

import java.sql.SQLException;

import by.ItAcademy.dao.*;

public class User {
    private int id;
    private String login;
    private String password;
    private String role;
    private UserDAOImp UserDao = new UserDAOImp();

    public User() {
    }

    public User(String login, String password) throws SQLException{
      //  chekUser(login,password);
        this.login = login;
        this.password = password;
        this.id=UserDao.getUserId(this);
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

  // private void chekUser(String name, String password) throws SQLException, NullUserException {
  //     Connection conn = AbstractConnection.get();
  //     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
  //     stmt.setString(1, name);
  //     stmt.setString(2, password);
  //     ResultSet rs = stmt.executeQuery();
  //     if (!(rs.next()))
  //         throw new NullUserException("неверный логин или пароль");
  //     stmt.close();
  //     conn.close();
  // }



//  public String getId(String name, String password) throws SQLException {
//      Connection conn = AbstractConnection.get();
//      PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE login = ? AND password = ?");
//      String role = null;
//      try {
//          stmt.setString(1, name);
//          stmt.setString(2, password);
//          ResultSet rs = stmt.executeQuery();
//          while (rs.next()) {
//              role = rs.getString("id");
//          }
//          return role;
//      } catch (SQLException e) {
//          e.printStackTrace();
//      } finally {
//          stmt.close();
//          conn.close();
//      }
//      return role;
//  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}