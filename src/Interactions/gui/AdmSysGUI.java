package Interactions.gui;

import Data.LocalEmployeesList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmSysGUI {
    private LocalEmployeesList employeesDB = new LocalEmployeesList();
    String employeesDataBaseFile = "employees.csv";
    String workReportFile = "workReport.txt";
    String adminPassword = "root";

    public JPanel mainPanel;
    private JPanel ButtonsPanel;
    private JButton administratorButton;
    private JButton employeeButton;
    private JButton exitButton;

    public AdmSysGUI() {

        mainPanel.setSize(600, 800);
        ButtonsPanel.setSize(mainPanel.getSize());

        administratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //employeesDB.ImportFromFile(employeesDataBaseFile);
                Frame frame = new JFrame("AdmSys");
                //frame.setResizable(false);
                frame.add(new GUIAdminLogin().passwordLabel);
                frame.setVisible(true);
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
