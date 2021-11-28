package com.company;
import Interactions.gui.AdmSysGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        ConsoleMenu menu = new ConsoleMenu();
//        menu.MainMenu();
        JFrame frame = new JFrame("AdmSys");
        //frame.setResizable(false);
        frame.setContentPane(new AdmSysGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
