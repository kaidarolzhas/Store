package Server;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import Class.*;
import Database.*;
public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Packagedata data = null;

            while((data = ((Packagedata)inputStream.readObject())) != null) {
                if (data.getOperationType().equals("ADD USER")) {
                    User customer = data.getUser();
                    manager.addUser(customer);
                    break;
                } else if (data.getOperationType().equals("ADD TICKET")) {
                    Ticket ticket = data.getTicket();
                    manager.addTicket(ticket);
                    break;
                }
                else if(data.getOperationType().equals("Delete ticket")){
                    int idServer = data.getId();
                    manager.deleteTicket(idServer);
                    break;
                }
                else if(data.getOperationType().equals("LIST TICKET")){
                    ArrayList<Ticket> arrayTicket = manager.getAllTicket();
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTickets(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET TICKET")){
                    Ticket arrayTicket = manager.getTicket(data.getId());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTicket(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET USER")){
                    User user = manager.getUser(data.getLogin());
                    Packagedata userlist = new Packagedata();
                    userlist.setUser(user);
                    outputStream.writeObject(userlist);
                    break;
                }
                else if(data.getOperationType().equals("ADD CARD")){
                    Ticket ticket= data.getTicket();
                    int id = data.getId();
                    manager.addCard(ticket,id);
                    break;
                }
                else if(data.getOperationType().equals("FIND TICKET")){
                    String genre = data.getLogin();
                    ArrayList<Ticket> arrayTicket = manager.FindTicket(genre);
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTickets(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                inputStream.close();
                outputStream.close();
                socket.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
