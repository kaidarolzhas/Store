package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Class.Ticket;
import Main.Start;
import Database.Packagedata;
import Main.MainFrame;

public class AddTicket extends Container {
    public AddTicket(){
        setSize(500, 500);
        setLayout(null);

        String[] genre= {"feature film", "action ",  "adventure","comedy", "drama", "horror", "romance" };

        String[] typeMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        JLabel NameLabel = new JLabel("Name");
        NameLabel.setBounds(50, 50, 95, 30);
        add(NameLabel);

        JLabel genreLabel = new JLabel("Genre");
        genreLabel.setBounds(150, 50, 95, 30);
        add(genreLabel);

        JLabel timeLabel = new JLabel("Time");
        timeLabel.setBounds(250, 50, 95, 30);
        add(timeLabel);

        JLabel dayLabel = new JLabel("Day");
        dayLabel.setBounds(350, 50, 95, 30);
        add(dayLabel);

        JLabel monthLabel = new JLabel("Month");
        monthLabel.setBounds(50, 150, 95, 30);
        add(monthLabel);

        JTextField NameField = new JTextField();
        NameField.setBounds(50, 100, 95, 30);
        add(NameField);

        JComboBox genreField = new JComboBox(genre);
        genreField.setBounds(150, 100, 95, 30);
        add(genreField);

        JTextField timeField = new JTextField();
        timeField.setBounds(250, 100, 95, 30);
        add(timeField);



        JTextField dayField = new JTextField();
        dayField.setBounds(350, 100, 95, 30);
        add(dayField);

        JComboBox monthBox = new JComboBox(typeMonth);
        monthBox.setBounds(50, 200, 95, 30);
        add(monthBox);

        JLabel LuggageLabel = new JLabel("Price:");
        LuggageLabel.setBounds(150, 150, 95, 30);
        add(LuggageLabel);

        JTextField pField = new JTextField();
        pField.setBounds(150, 200, 95, 30);
        add(pField);

        JLabel placeLabel = new JLabel("Place:");
        placeLabel.setBounds(250, 150, 95, 30);
        add(placeLabel);

        JTextField placeField = new JTextField();
        placeField.setBounds(250, 200, 95, 30);
        add(placeField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(350, 150, 95, 30);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(350, 200, 95, 30);
        add(ageField);


        JButton findButton = new JButton("Add");
        findButton.setBounds(150, 300, 95, 30);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 300, 150, 30);
        add(backButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Ticket ticket = new Ticket(null, NameField.getText(), (String)genreField.getSelectedItem(), timeField.getText(), Integer.parseInt(pField.getText()),Integer.parseInt(dayField.getText()),(String)monthBox.getSelectedItem(),Integer.parseInt(placeField.getText()), Integer.parseInt(ageField.getText()));


                Packagedata pd = new Packagedata("ADD TICKET", ticket);
                Start.connect(pd);
                JOptionPane.showInternalMessageDialog(null,"Ticket added");

                NameField.setText(null);
                timeField.setText(null);
                dayField.setText(null);
                ageField.setText(null);
                pField.setText(null);
                dayField.setText(null);
                placeField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addTicket.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}


