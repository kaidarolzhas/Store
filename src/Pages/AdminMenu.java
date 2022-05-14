package Pages;
import Database.Packagedata;
import Main.MainFrame;
import Main.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    public static JTextArea textArea;
    public AdminMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton addTicket = new JButton("Add ticket");
        addTicket.setBounds(50, 20, 400, 25);
        add(addTicket);

        JButton deleteTicket = new JButton("Delete ticket");
        deleteTicket.setBounds(50, 50, 400, 25);
        add(deleteTicket);

        JButton back = new JButton("Back");
        back.setBounds(50, 80, 400, 25);
        add(back);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(50,120,400,200);
        add(textArea);

        JButton list = new JButton("List");
        list.setBounds(175, 325, 150, 25);
        add(list);

        addTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.addTicket.setVisible(true);

            }
        });

        deleteTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.deleteTicket.setVisible(true);

            }
        });



        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mainMenu.setVisible(true);
                MainFrame.adminMenu.setVisible(false);
            }
        });

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("LIST TICKET");
                Start.connect(pd);
            }
        });
    }
}