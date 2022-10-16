package by.ItAcademy.menu;

import by.ItAcademy.dao.MoviesDAOImp;
import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;
import by.ItAcademy.record.FileRecordsUserImp;
import by.ItAcademy.service.UserServiceImp;

import java.util.Scanner;

public class UserMenu {

    protected static void userMenu(User user) {
        String name,place;
        int id;
        FileRecordsUserImp record = new FileRecordsUserImp();
        UserServiceImp userService = new UserServiceImp();
        MoviesDAOImp movieDAO = new MoviesDAOImp();
        System.out.println("Здравствуйте,пользователь "+user.getLogin());
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1-посмотреть мероприятия");
                System.out.println("2-посмотреть билеты");
                System.out.println("3-купить билет");
                System.out.println("4-вернуть билет");
                System.out.println("5-посмотреть купленные билеты");
                System.out.println("6-выйти из приложения ");
                String input = sc.nextLine();
                if ("1".equals(input)) {
                    System.out.println(userService.seeEvents().toString());
                    record.openFilmMenu(user);
                }
                if ("2".equals(input)){
                    System.out.println("на какой фильм хотите посмотреть билеты?");
                    String in = sc.nextLine();
                    if(movieDAO.movieExist(in)){
                        System.out.println(userService.seeAllTickets(in).toString());
                        record.openTicketMenu(user);
                    }
                    else{
                        throw new IllegalArgumentException("такого фильма не существует");
                    }
                }
                if ("3".equals(input)) {
                    System.out.println("Введите фильм на который хотите пойти");
                    name =sc.nextLine();
                    if(movieDAO.movieExist(name)){
                        System.out.println(userService.seeAllTickets(name).toString());
                        System.out.println("Введите № желаемого места");
                        place = sc.nextLine();
                        Ticket ticket = new Ticket(user, Integer.parseInt(place),name);
                        record.buyTicket(user,ticket);
                        System.out.println(userService.buyTicket(user,ticket,name));
                    }
                    else{
                        throw new IllegalArgumentException("такого фильма не существует");
                    }


                }
                if ("4".equals(input)) {
                    System.out.println("какой билет хотите вернуть?");
                    System.out.println(userService.seePurchasedTickets(user).toString());
                    id = Integer.parseInt(sc.nextLine());
                    Ticket ticket = new Ticket(user, id);
                    System.out.println(userService.returnTicket(user,ticket));
                    record.returnTicket(user,ticket);
                }
                if ("5".equals(input)) {
                    System.out.println(userService.seePurchasedTickets(user).toString());
                    record.seePurchasedTicket(user);
                }
                if ("6".equals(input)) {
                    record.userLogOut(user);
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


