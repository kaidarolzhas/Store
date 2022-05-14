package Pages;
import Class.Ticket;
import Main.MainFrame;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {
    public static Ticket ticket;
    public static JTextArea textArea;
    public UserMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton ticketsButton = new JButton("Tickets");
        ticketsButton.setBounds(175, 10, 150, 35);
        add(ticketsButton);

        JButton findButton = new JButton("Find");
        findButton.setBounds(175,  60, 150, 35);
        add(findButton);

        JButton myTicketsButton = new JButton("My tickets");
        myTicketsButton.setBounds(175, 110, 150, 35);
        add(myTicketsButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 180, 400, 200);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(175, 400, 150, 35);
        add(backButton);

        ticketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.buyTicket.setVisible(true);

            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.find.setVisible(true);


            }
        });

        myTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.mainMenu.setVisible(true);
            }
        });
    }
}
