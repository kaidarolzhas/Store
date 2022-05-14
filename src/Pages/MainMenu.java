package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DBManager;
import Database.Packagedata;
import Main.*;
import Class.User;

import static Database.DBManager.connection;

public class MainMenu extends Container {
    public static User user;
    public MainMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        loginLabel.setBounds(100, 150, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 150, 200, 30);
        add(loginField);


        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordLabel.setBounds(100, 200, 100, 30);
        add(passwordLabel);




        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 200, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setBounds(125, 250, 100, 20);
        add(logInButton);

        JButton singButton = new JButton("Sign up");
        singButton.setBounds(275, 250, 100, 20);
        add(singButton);



        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Packagedata pd = new Packagedata("GET USER",loginField.getText());
                    Start.connect(pd);
                    DBManager dbManager = new DBManager();
                    dbManager.connect();
                    PreparedStatement statement = connection.prepareStatement("" +
                            "SELECT * FROM user WHERE login = '" + loginField.getText() + "'" + "and password = '" + passwordField.getText() + "'");
                    ResultSet resultSet = statement.executeQuery();

                    if(resultSet.next()){
                        loginField.setText(null);
                        passwordField.setText(null);

                        Start.frame.mainMenu.setVisible(false);
                        Start.frame.userMenu.setVisible(true);
                    }else if(loginField.getText().equals("admin") && passwordField.getText().equals("password")){
                        loginField.setText(null);
                        passwordField.setText(null);

                        Start.frame.mainMenu.setVisible(false);
                        Start.frame.adminMenu.setVisible(true);
                    }else{
                        JOptionPane.showInternalMessageDialog(null,"Incorrect login or password");
                    }

                }catch (Exception a){
                    a.printStackTrace();
                }



            }
        });

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mainMenu.setVisible(false);
                MainFrame.sign.setVisible(true);


            }
        });


    }
}

