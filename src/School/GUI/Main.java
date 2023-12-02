package School.GUI;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SchoolGUI mainWindow = new SchoolGUI();
        mainWindow.pack();
        mainWindow.setSize(500, 1000);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
    }
}