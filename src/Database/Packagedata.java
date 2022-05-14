package Database;
import Class.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Packagedata implements Serializable {
    private String operationType;
    private User user;
    private Ticket ticket;
    private int id;
    private int id_user;

    private String login;

    private ArrayList<User> users;
    private ArrayList<Ticket> tickets;

    public Packagedata() {
    }

    public Packagedata(String operationType, Ticket ticket, int id) {
        this.operationType = operationType;
        this.ticket = ticket;
        this.id = id;
    }

    public Packagedata(String operationType, int id, int id_user) {
        this.operationType = operationType;
        this.id = id;
        this.id_user = id_user;
    }

    public Packagedata(String operationType, String login) {
        this.operationType = operationType;
        this.login = login;
    }

    public Packagedata(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public Packagedata(String operationType, Ticket ticket) {
        this.operationType = operationType;
        this.ticket = ticket;
    }

    public Packagedata(String operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }

    public Packagedata(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
