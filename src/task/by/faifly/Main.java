package task.by.faifly;

import task.by.faifly.viev_controller.MainFrame;

import java.awt.*;

/**
 * Class to start application.
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public class Main {

    /**
     * Entry point.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
