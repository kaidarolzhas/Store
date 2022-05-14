package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Class.Ticket;
import Main.Start;
import Database.Packagedata;
import Main.MainFrame;

public class Find extends Container {

    public static JTextArea textArea;
    public Find(){
        setSize(500, 500);
        setLayout(null);

        String[] genre= {"feature film", "action ",  "adventure","comedy", "drama", "horror", "romance" };
        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel genreLabel = new JLabel("Genre");
        genreLabel.setBounds(75, 50, 100, 30);
        add(genreLabel);

        JComboBox genreBox = new JComboBox(genre);
        genreBox.setBounds(175,50,100,30);
        add(genreBox);

        JTextField numberField = new JTextField();
        numberField.setBounds(200, 350, 70, 25);
        add(numberField);

        JButton BuyButton = new JButton("Buy");
        BuyButton.setBounds(70, 350, 100, 25);
        add(BuyButton);


        JButton findButton = new JButton("Find");
        findButton.setBounds(300, 50, 100, 30);
        add(findButton);

        JButton backButton = new JButton("Back ");
        backButton.setBounds(175, 400, 150, 30);
        add(backButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("FIND TICKET",(String)genreBox.getSelectedItem());
                Start.connect(pd);

            }
        });

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.find.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}


