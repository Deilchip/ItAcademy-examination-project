package by.ItAcademy.menu;

import by.ItAcademy.dao.MoviesDAOImp;
import by.ItAcademy.model.Movie;
import by.ItAcademy.model.User;
import by.ItAcademy.record.FileRecordsUserImp;
import by.ItAcademy.service.ManagerServiceImp;
import by.ItAcademy.service.UserServiceImp;

import java.util.Scanner;

public class ManagerMenu {
    protected static void  managerMenu(User user){
        String name;
        String date;
        FileRecordsUserImp record = new FileRecordsUserImp();
        UserServiceImp userService = new UserServiceImp();
        ManagerServiceImp managerService = new ManagerServiceImp();
        MoviesDAOImp movieDAO = new MoviesDAOImp();
        System.out.println("Здравствуйте,пользователь "+user.getLogin());
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1-Открыть меню управления мероприятиями");
                System.out.println("2-Открыть меню управления билетами пользователей");
                System.out.println("3-Выйти из приложения");
                String input = sc.nextLine();
                if ("1".equals(input)) {
                    System.out.println("Управление мероприятиями");
                    System.out.println("1-Изменить название фильма");
                    System.out.println("2-Изменить дату премьеры");
                    System.out.println("3-вернуться обратно в меню");
                   String in = sc.nextLine();
                    if("1".equals(in)){
                        System.out.println("Введите название фильма которое хотите изменить");
                        userService.seeEvents();
                        name = sc.nextLine();
                        Movie movie = new Movie(name);
                        if(movieDAO.movieExist(name)) {
                            System.out.println("Введите новое название фильма");
                            name = sc.nextLine();
                            System.out.println(managerService.updateMovieName(user ,movie,name));
                        }
                    }
                }
                if ("2".equals(input)){
                    System.out.println("на какой фильм хотите посмотреть билеты?");
                    String in = sc.nextLine();
                    System.out.println(userService.seeAllTickets(in).toString());
                    record.openTicketMenu(user);
                }
                if ("3".equals(input)) {
                    break;

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }


