package Pages;
import Class.*;
import Database.Packagedata;
import com.sun.tools.javac.Main;
import Main.Start;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign extends Container{
    public Sign(){
        setSize(500, 500);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(100, 30, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 30, 200, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setBounds(100, 80, 100, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(200, 80, 200, 30);
        add(surnameField);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(100, 130, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 130, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 180, 100, 30);
        add(passwordLabel);


        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 180, 200, 30);
        add(passwordField);

        JLabel passwordLabel2 = new JLabel("REPEAT:");
        passwordLabel2.setBounds(100, 230, 200, 30);
        add(passwordLabel2);

        JTextField passwordField2 = new JTextField();
        passwordField2.setBounds(200, 230, 200, 30);
        add(passwordField2);

        JLabel ageLabel = new JLabel("AGE:");
        ageLabel.setBounds(100, 280, 200, 30);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(200, 280, 200, 30);
        add(ageField);

        JButton singButton = new JButton("Sing up");
        singButton.setBounds(100, 350, 140, 20);
        add(singButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 350, 150, 20);
        add(backButton);

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if(!loginField.getText().equals( "" )  && !passwordField.getText().equals( "" ) && !nameField.getText().equals( "" ) && !surnameField.getText().equals( "" ) ) {
                   if(passwordField.getText().equals(passwordField2.getText() )) {
                       User user = new User(null, loginField.getText(),  passwordField.getText(), nameField.getText(), surnameField.getText(), Integer.parseInt(ageField.getText()));
                       Packagedata pd = new Packagedata("ADD USER", user);
                       Start.connect(pd);

                       nameField.setText(null);
                       surnameField.setText(null);
                       loginField.setText(null);
                       passwordField.setText(null);
                       passwordField2.setText(null);

                       JOptionPane.showInternalMessageDialog(null, "SUCCESSFUL");
                   }
                   else
                       JOptionPane.showInternalMessageDialog(null, "Passwords are not same");
                }else{
                    JOptionPane.showInternalMessageDialog(null, "Fields are null or Passwords are not same");
                }


            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.frame.sign.setVisible(false);
                Start.frame.mainMenu.setVisible(true);

            }
        });

    }
}

