package Interactions.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame implements ActionListener {
    int width = 400, height = 200;
    JLabel label = new JLabel("Password: ");
    JPanel panel = new JPanel();
    Font mainFont = new Font("Arial", Font.BOLD, 14);
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    JPasswordField passwordField = new JPasswordField(10);

    public AdminLoginFrame() throws HeadlessException {
        //label init
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(mainFont);
        //password field
        passwordField.setBorder(border);
        passwordField.setAlignmentX(0);
        passwordField.addActionListener(this);
        //
        panel.add(label, BorderLayout.WEST);
        panel.add(passwordField, BorderLayout.EAST);
        //frame init
        this.setTitle("Log in");
        this.setDefaultCloseOperation(MainMenuGUI.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setVisible(true);
        this.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(passwordField)) {
            StringBuilder buffer = new StringBuilder();
            String password;
            for (int i = 0; i < passwordField.getPassword().length; i++) {
                buffer.append(passwordField.getPassword()[i]);
            }
            password = buffer.toString();
            if(!password.equals("root")) {
                JDialog errorDialog = new JDialog();
                JLabel wrongPassLabel = new JLabel("Wrong password!");
                wrongPassLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                errorDialog.setTitle("Error!");
                errorDialog.setSize(250,100);
                errorDialog.add(wrongPassLabel);
                //errorDialog.setLayout(null);
                errorDialog.setResizable(false);
                errorDialog.setVisible(true);
            } else {
                new AdminPage();
            }
        }
    }
}
