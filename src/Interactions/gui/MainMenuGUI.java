package Interactions.gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener {
    int width = 800, height = 300;
    Font mainFont = new Font("Arial", Font.BOLD, 25);
    Border border = BorderFactory.createLineBorder(Color.YELLOW, 3);
    JLabel label = new JLabel();
    JButton administrationButton = new JButton("Administrator");
    JButton employeeButton = new JButton("Employee");

    public MainMenuGUI() throws HeadlessException {
        //label part
        label.setText("Choose an authorization method");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.NORTH);
        label.setForeground(Color.YELLOW);
        label.setFont(mainFont);
        label.setBounds(0,0,width,height);
        //button part
        administrationButton.setBounds(200, 100, 180, 40);
        employeeButton.setBounds(420, 100, 180, 40);
        administrationButton.addActionListener(this);
        employeeButton.addActionListener(this);
        //init part
        this.setTitle("AdmSys");
        this.setDefaultCloseOperation(MainMenuGUI.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.add(label);
        this.add(administrationButton);
        this.add(employeeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(administrationButton)) {
            System.out.println("ADMINISTRATION");
        }
        if(e.getSource().equals(employeeButton)) {
            System.out.println("EMPLOYEE");
        }
    }
}
