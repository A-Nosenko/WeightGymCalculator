package task.by.faifly.viev_controller.handler;

import task.by.faifly.model.Constants;
import task.by.faifly.model.Constants.BundleKeys;

import javax.swing.*;
import java.util.ResourceBundle;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

/**
 * Class contains methods to update UI components.
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/11/2018.
 */
public class Marker {
    /**
     * Method to apply light theme to buttons.
     *
     * @param buttons Buttons to be updated.
     */
    public static void appendLightTheme(JButton... buttons) {
        for (JButton button : buttons) {
            button.setBackground(Constants.LIGHT_THEME_COLOR);
            button.setForeground(BLACK);
        }
    }

    /**
     * Method to apply dark theme to buttons.
     *
     * @param buttons Buttons to be updated.
     */
    public static void appendDarkTheme(JButton... buttons) {
        for (JButton button : buttons) {
            button.setBackground(Constants.DARK_THEME_COLOR);
            button.setForeground(RED);
        }
    }

    /**
     * Method to apply light theme to panels.
     *
     * @param jPanels Panels to be updated.
     */
    public static void appendLightTheme(JPanel... jPanels) {
        for (JPanel jPanel : jPanels) {
            jPanel.setBackground(Constants.LIGHT_THEME_COLOR);
        }
    }

    /**
     * Method to apply dark theme to panels.
     *
     * @param jPanels Panels to be updated.
     */
    public static void appendDarkTheme(JPanel... jPanels) {
        for (JPanel jPanel : jPanels) {
            jPanel.setBackground(Constants.DARK_THEME_COLOR);
        }
    }

    /**
     * Method to apply light theme to text fields.
     *
     * @param jTextFields Text fields to be updated.
     */
    public static void appendLightTheme(JTextField... jTextFields) {
        for (JTextField jTextField : jTextFields) {
            jTextField.setBackground(Constants.LIGHT_THEME_COLOR);
            jTextField.setDisabledTextColor(BLACK);
        }
    }

    /**
     * Method to apply dark theme to text fields.
     *
     * @param jTextFields Text fields to be updated.
     */
    public static void appendDarkTheme(JTextField... jTextFields) {
        for (JTextField jTextField : jTextFields) {
            jTextField.setBackground(Constants.DARK_THEME_COLOR);
            jTextField.setDisabledTextColor(RED);
        }
    }

    /**
     * Method to apply light theme to text area.
     *
     * @param jTextArea Text area to be updated.
     */
    public static void appendLightTheme(JTextArea jTextArea) {
        jTextArea.setBackground(Constants.LIGHT_THEME_COLOR);
        jTextArea.setDisabledTextColor(BLACK);
    }

    /**
     * Method to apply dark theme to text area.
     *
     * @param jTextArea Text area to be updated.
     */
    public static void appendDarkTheme(JTextArea jTextArea) {
        jTextArea.setBackground(Constants.DARK_THEME_COLOR);
        jTextArea.setDisabledTextColor(RED);
    }

    /**
     * Method updates text in UI components.
     *
     * @param resourceBundle    Bundle to get text source.
     * @param jFrame            The frame, that's title to be updated.
     * @param lightThemeButton  Button to apply light theme.
     * @param darkThemeButton   Button to apply dark theme.
     * @param engLanguageButton Button to change language to english.
     * @param rusLanguageButton Button to change language to russian.
     * @param jTextTypeMarker   Text field marks the exercise type picking.
     * @param jTextWeightMarker Text field marks the weight of the barbell picking.
     * @param jTextCountMarker  Text field marks the number of repetitions picking.
     * @param startButton       Button to start calculating.
     */
    public static void updateText(ResourceBundle resourceBundle, JFrame jFrame, JButton lightThemeButton,
                                  JButton darkThemeButton, JButton engLanguageButton, JButton rusLanguageButton,
                                  JTextField jTextTypeMarker, JTextField jTextWeightMarker,
                                  JTextField jTextCountMarker, JButton startButton) {
        jFrame.setTitle(resourceBundle.getString(BundleKeys.TITLE));
        lightThemeButton.setText(resourceBundle.getString(BundleKeys.LIGHT_THEME));
        darkThemeButton.setText(resourceBundle.getString(BundleKeys.DARK_THEME));
        engLanguageButton.setText(resourceBundle.getString(BundleKeys.EN));
        rusLanguageButton.setText(resourceBundle.getString(BundleKeys.RU));
        jTextTypeMarker.setText(resourceBundle.getString(BundleKeys.CHOOSE_EXERCISE_TYPE));
        jTextWeightMarker.setText(resourceBundle.getString(BundleKeys.ENTER_THE_WEIGTH));
        jTextCountMarker.setText(resourceBundle.getString(BundleKeys.CHOOSE_EXERCISES_COUNT));
        startButton.setText(resourceBundle.getString(BundleKeys.START));
    }
}
