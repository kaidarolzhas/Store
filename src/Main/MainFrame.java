package Main;

import javax.swing.*;
import Pages.*;

public class MainFrame extends JFrame {
    public static MainMenu mainMenu;
    public static UserMenu userMenu;
    public static Sign sign;

    public static AddTicket addTicket;

    public static AdminMenu adminMenu;
    public static DeleteTicket deleteTicket;
    public static BuyTicket buyTicket;
    public static Find find;
    public MainFrame(){
        setSize(500, 500);
        setTitle("Cinema ticket");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        mainMenu = new MainMenu();
        mainMenu.setLocation(0,0);
        add(mainMenu);

        find = new Find();
        find.setLocation(0,0);
        find.setVisible(false);
        add(find);

        userMenu = new UserMenu();
        userMenu.setVisible(false);
        userMenu.setLocation(0,0);
        add(userMenu);

        buyTicket = new BuyTicket();
        buyTicket.setVisible(false);
        buyTicket.setLocation(0,0);
        add(buyTicket);

        adminMenu = new AdminMenu();
        adminMenu.setVisible(false);
        adminMenu.setLocation(0,0);
        add(adminMenu);

        deleteTicket = new DeleteTicket();
        deleteTicket.setVisible(false);
        deleteTicket.setLocation(0,0);
        add(deleteTicket);

        addTicket = new AddTicket();
        addTicket.setVisible(false);
        addTicket.setLocation(0,0);
        add(addTicket);



        sign = new Sign();
        sign.setVisible(false);
        sign.setLocation(0,0);
        add(sign);

    }
}
