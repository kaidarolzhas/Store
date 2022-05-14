package Pages;
import Database.Packagedata;
import Main.MainFrame;
import Main.Start;
import Class.Ticket;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyTicket extends Container {
    public static JTextArea textArea;
    public static Ticket ticket;
    public BuyTicket(){

        setSize(500, 500);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy:");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setBounds(70, 340, 280, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setFont(new Font("Verdana", Font.BOLD , 12));
        numberField.setBounds(360, 340, 70, 25);
        add(numberField);

        JButton BuyButton = new JButton("Buy");
        BuyButton.setFont(new Font("Verdana", Font.BOLD , 12));
        BuyButton.setBounds(70, 375, 175, 25);
        add(BuyButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(255, 375, 175, 25);
        add(backButton);

        JButton listButton = new JButton("List");
        listButton.setFont(new Font("Verdana", Font.BOLD , 12));
        listButton.setBounds(175, 50, 150, 25);
        add(listButton);

        BuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("GET TICKET", Integer.parseInt(numberField.getText()));
                Start.connect(pd);
                Packagedata pd1 = new Packagedata("ADD CARD",BuyTicket.ticket, MainMenu.user.getId());
                Start.connect(pd1);
                Packagedata pd2 = new Packagedata("Delete ticket",Integer.parseInt(numberField.getText()));
                Start.connect(pd2);
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("LIST TICKET");
                Start.connect(pd);

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.buyTicket.setVisible(false);
                MainFrame.userMenu.setVisible(true);
            }
        });



    }
}
