package Database;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import Class.*;

public class DBManager  {
    public static Connection connection = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cinema?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void addCard(Ticket ticket,int customer_id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO card (id, customer_id,name, type, time,price, day, month, place, age) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?,?,?, ?)");
            statement.setInt(1, customer_id);
            statement.setString(2, ticket.getName());
            statement.setString(3, ticket.getType());
            statement.setString(4, ticket.getTime());
            statement.setInt(5, ticket.getPrice());
            statement.setInt(6, ticket.getDay());
            statement.setString(7, ticket.getMonth());
            statement.setInt(8, ticket.getPlace());
            statement.setInt(9, ticket.getAge());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    public ArrayList<Ticket> getCard(int customer_id){
        ArrayList<Ticket> ticketList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM card WHERE customer_id = '" + customer_id + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String where = resultSet.getString("wheree");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                ticketList.add(new Ticket(id, name, whereFrom, where, day, month, place));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ticketList;
    }

 */



    public void addUser(User customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO user (id, login, password, name, surname, age) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");
            statement.setString(1, customer.getLogin());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getSurname());
            statement.setInt(5, customer.getAge());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Ticket> FindTicket(String genre){
        ArrayList<Ticket> TicketList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket WHERE type ='" + genre + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                TicketList.add(new Ticket(id, type, name, time, price, day, month, place, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return TicketList;
    }


    public ArrayList<Ticket> getAllTicket(){
        ArrayList<Ticket> TicketList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                TicketList.add(new Ticket(id, type, name, time, price, day, month, place, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return TicketList;
    }

    public Ticket getTicket(int idClient){
        Ticket ticket = new Ticket();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket where id='" + idClient + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                ticket = new  Ticket(id, type, name, time, price, day, month, place, age);            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ticket;
    }



    public User getUser(String login) {
        User customer = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user where login='" + login + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");


                customer = new User(id);


            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }



    public void addTicket(Ticket ticket) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO ticket (id, name, type, time,price, day, month, place, age) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?,?,?)");
            statement.setString(1, ticket.getName());
            statement.setString(2, ticket.getType());
            statement.setString(3, ticket.getTime());
            statement.setInt(4, ticket.getPrice());
            statement.setInt(5, ticket.getDay());
            statement.setString(6, ticket.getMonth());
            statement.setInt(7, ticket.getPlace());
            statement.setInt(8, ticket.getAge());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void deleteTicket(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM ticket WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<User> getAllUser() {
        ArrayList<User> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                customerList.add(new User(id, login, password, name, surname, age));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }


}

