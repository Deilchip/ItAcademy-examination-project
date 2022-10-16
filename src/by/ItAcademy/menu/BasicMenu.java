package by.ItAcademy.menu;


import by.ItAcademy.model.User;
import by.ItAcademy.record.FileRecordsUserImp;
import by.ItAcademy.service.UserServiceImp;

import java.util.Scanner;

public class BasicMenu {
    public static void mainMenu (){
        String input;
        String login;
        String password;
        FileRecordsUserImp record = new FileRecordsUserImp();
        UserServiceImp userService= new UserServiceImp();
        System.out.println("Добро пожаловать в кинотеатр Октябрь");
        while(true){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1-зайти в личный кабинет");
                System.out.println("2-зарегистрироваться");
                System.out.println("3-выйти из приложения");
                input = sc.nextLine();
                if ("1".equals(input)) {
                    System.out.println("введите логин");
                   login = sc.nextLine();
                    System.out.println("введите пароль");
                    password = sc.nextLine();
                    password = userService.getHash(password);
                    User user = new User(login, password);
                  if(userService.authorization(user).equals("user")){
                      record.authorization(user);
                      record.openMenu(user);
                      UserMenu.userMenu(user);
                  }
                  if(userService.authorization(user).equals("user")){
                      record.authorization(user);
                      record.openMenu(user);
                      ManagerMenu.managerMenu(user);
                  }
                }
                if ("2".equals(input)) {
                    System.out.println("введите логин");
                    login = sc.nextLine();
                    System.out.println("введите пароль");
                    password = sc.nextLine();
                    password = userService.getHash(password);
                    User user = new User(login, password,"user");
                    if(!userService.checkExistUser(user)){
                        record.registration(user);
                        System.out.println(userService.registration(user));
                    } else{
                        throw new IllegalArgumentException("Пользователь с таким логином зарегистрирован уже");
                    }

                }
                if("3".equals(input)){
                    break;
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
