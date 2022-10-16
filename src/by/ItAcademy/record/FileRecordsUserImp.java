package by.ItAcademy.record;

import by.ItAcademy.model.Ticket;
import by.ItAcademy.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileRecordsUserImp implements FileRecordsUser {
    private final static String PATHNAME = "D:\\Новая папка\\Final_Vlad_Petkevich\\file\\";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Calendar time = Calendar.getInstance();
    @Override
    public void registration(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists())
            file.createNewFile();
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(dateFormat.format
                (time.getTime()) + " / " + " пользователь "+user.getLogin()+ " создан " + "\n");
        fileWriter.close();

    }

    @Override
    public void authorization(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(dateFormat.format
                (time.getTime()) + " / " + " пользователь "+user.getLogin()+ " зашел в личный кабинет " + "\n");
        fileWriter.close();
    }

    @Override
    public void openMenu(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write( "зашел в меню" + "\n");
        fileWriter.close();
    }
    @Override
    public void openFilmMenu(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write( "открыто меню выбора фильма" + "\n");
        fileWriter.close();
    }

    @Override
    public void openTicketMenu(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write( "открыто меню выбора билета" + "\n");
        fileWriter.close();
    }

    @Override
    public void buyTicket(User user, Ticket ticket) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write
                ( "пользователь выбрал фильм:"+ticket.getName() + "\n"+"выбрал место:"+ticket.getId()+"\n");
        fileWriter.close();
    }

    @Override
    public void returnTicket(User user,Ticket ticket) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write
                ( "пользователь вернул билет , место:"+ticket.getId()+"\n");
        fileWriter.close();
    }

    @Override
    public void seePurchasedTicket(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write
                ( "пользователь посмотрел купленные билеты"+"\n");
        fileWriter.close();
    }

    @Override
    public void userLogOut(User user) throws IOException {
        File file = new File (PATHNAME +user.getLogin());
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(dateFormat.format
                (time.getTime()) + " / " + " пользователь "+user.getLogin()+ "вышел из приложения" + "\n");
        fileWriter.close();
    }
}
