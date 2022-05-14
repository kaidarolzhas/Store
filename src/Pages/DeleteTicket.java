package Pages;
import Database.Packagedata;
import Main.MainFrame;
import Main.Start;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTicket extends Container {
    public static JTextArea textArea;
    public DeleteTicket(){

        setSize(500, 500);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to delete:");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setBounds(70, 340, 280, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setFont(new Font("Verdana", Font.BOLD , 12));
        numberField.setBounds(360, 340, 70, 25);
        add(numberField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Verdana", Font.BOLD , 12));
        deleteButton.setBounds(70, 375, 175, 25);
        add(deleteButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(255, 375, 175, 25);
        add(backButton);

        JButton listButton = new JButton("List");
        listButton.setFont(new Font("Verdana", Font.BOLD , 12));
        listButton.setBounds(175, 50, 150, 25);
        add(listButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("Delete ticket", Integer.parseInt(numberField.getText()));
                Start.connect(pd);
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
                MainFrame.deleteTicket.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });



    }
}
