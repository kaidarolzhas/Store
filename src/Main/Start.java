package Main;

import Database.Packagedata;
import Class.*;
import Pages.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Start {
    public static MainFrame frame;
    public static void connect(Packagedata pd){
        try{
            Socket socket = new Socket("127.0.0.1", 6555);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD TICKET") ){
                outputStream.writeObject(pd);
            }
            else if (pd.getOperationType().equals("ADD USER")) {
                outputStream.writeObject(pd);

            }
            if(pd.getOperationType().equals("Delete ticket")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST TICKET")){
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata)inputStream.readObject();
                ArrayList<Ticket> arrayListFromServer = infoFromServer.getTickets();
                String s = "";
                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                DeleteTicket.textArea.setText(s);
                AdminMenu.textArea.setText(s);
                BuyTicket.textArea.setText(s);
            }
            else if(pd.getOperationType().equals("FIND TICKET")){
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata)inputStream.readObject();
                ArrayList<Ticket> arrayListFromServer = infoFromServer.getTickets();
                String s = "";
                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
               Find.textArea.setText(s);
            }
            else if (pd.getOperationType().equals("ADD PLANE TICKET")) {
                outputStream.writeObject(pd);

            }

            else if(pd.getOperationType().equals("GET TICKET")){
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata)inputStream.readObject();
                Ticket arrayListFromServer = infoFromServer.getTicket();
                BuyTicket.ticket = arrayListFromServer;

            }
            else if(pd.getOperationType().equals("GET USER")){
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata)inputStream.readObject();
                User arrayListFromServer = infoFromServer.getUser();
                MainMenu.user = arrayListFromServer;

            }


            else if (pd.getOperationType().equals("ADD CARD")) {
                outputStream.writeObject(pd);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

    }
}
