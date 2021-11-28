package Interactions.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdminLogin {
    public JLabel passwordLabel;
    String password;
    private JPasswordField enterAdminPasswordPasswordField;
    private JButton okButton;

    public GUIAdminLogin() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password.equals("root")) {
                    System.out.println("you logged in!");
                }
            }
        });
        enterAdminPasswordPasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder buffer = new StringBuilder();
                for (int i = 0; i < enterAdminPasswordPasswordField.getPassword().length; i++) {
                    buffer.append(enterAdminPasswordPasswordField.getPassword()[i]);
                }
                password = buffer.toString();
            }
        });
    }
}
