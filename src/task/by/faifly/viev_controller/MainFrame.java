package task.by.faifly.viev_controller;

import task.by.faifly.model.Calculating;
import task.by.faifly.model.CalculatingHolder;
import task.by.faifly.model.Constants;
import task.by.faifly.model.Constants.BundleKeys;
import task.by.faifly.viev_controller.handler.Marker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public class MainFrame extends JFrame {

    private final task.by.faifly.model.Type[] items = new task.by.faifly.model.Type[]{
            task.by.faifly.model.Type.BenchPressing,
            task.by.faifly.model.Type.Deadlift,
            task.by.faifly.model.Type.Squats
    };
    JFrame jFrame = this;
    ResourceBundle resourceBundle;
    private CalculatingHolder holder;
    private Locale locale;
    private Calculating currentCalculating;
    private JPanel buttonPanel;
    private JPanel middleButtonPanel;
    private JPanel eastButtonPanel;
    private JButton lightThemeButton;
    private JButton darkThemeButton;
    private JButton engLanguageButton;
    private JButton rusLanguageButton;
    private JButton startButton;
    private JSpinner jSpinnerWeight;
    private JSpinner jSpinnerCount;
    private JTextField jTextTypeMarker;
    private JTextField jTextWeightMarker;
    private JComboBox<task.by.faifly.model.Type> jComboBox;
    private JTextField jTextCountMarker;

    private JScrollPane result;
    private JTextArea jTextArea;
    private Theme theme;
    private Text text;
    private Start start;

    private task.by.faifly.model.Type selectedItem;

    public MainFrame() {
        holder = CalculatingHolder.getHolder();
        locale = Locale.getDefault();
        updateTextRecourse();
        theme = new Theme();
        text = new Text();
        start = new Start();
        currentCalculating = new Calculating(task.by.faifly.model.Type.BenchPressing);
        initUI();
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        updateTextRecourse();
    }

    private void updateTextRecourse() {
        resourceBundle = ResourceBundle.getBundle(Constants.RES_NAME, locale);
    }

    private void initUI() {
        setSize(Constants.WIDTH, Constants.HIGHT);
        buttonPanel = new JPanel();
        middleButtonPanel = new JPanel();
        eastButtonPanel = new JPanel();

        lightThemeButton = new JButton();
        lightThemeButton.addActionListener(theme::light);

        darkThemeButton = new JButton();
        darkThemeButton.addActionListener(theme::dark);

        engLanguageButton = new JButton();
        engLanguageButton.addActionListener(text::setEngText);

        rusLanguageButton = new JButton();
        rusLanguageButton.addActionListener(text::setRusText);

        jTextTypeMarker = new JTextField();
        jTextTypeMarker.setEditable(false);
        jTextTypeMarker.setBorder(null);
        jTextTypeMarker.setEnabled(false);

        jComboBox = new JComboBox<>(items);

        jTextWeightMarker = new JTextField();
        jTextWeightMarker.setEditable(false);
        jTextWeightMarker.setBorder(null);
        jTextWeightMarker.setEnabled(false);

        SpinnerNumberModel spinnerWeightModel = new SpinnerNumberModel(0.0, 0.0, Constants.MAX_WEIGHT, 1.0);
        jSpinnerWeight = new JSpinner(spinnerWeightModel);

        jTextCountMarker = new JTextField();
        jTextCountMarker.setEditable(false);
        jTextCountMarker.setBorder(null);
        jTextCountMarker.setEnabled(false);

        SpinnerNumberModel spinnerCountModel = new SpinnerNumberModel(0, 0, Constants.KEYS_LENGTH - 1, 1);
        jSpinnerCount = new JSpinner(spinnerCountModel);

        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setEnabled(false);
        result = new JScrollPane(jTextArea);
        Dimension dimension = new Dimension(Constants.WIDTH_RESULT_TEXT, Constants.HIGHT);
        result.setMinimumSize(dimension);
        result.setMaximumSize(dimension);
        result.setAutoscrolls(true);
        result.setVerticalScrollBar(new JScrollBar());
        result.setBorder(null);
        result.setEnabled(true);
        updateResult();

        startButton = new JButton();
        startButton.addActionListener(start::start);

        theme.init();
        theme.light(null);
        text.setEngText(null);

        Marker.updateText(resourceBundle, jFrame, lightThemeButton, darkThemeButton, engLanguageButton,
                rusLanguageButton, jTextTypeMarker, jTextWeightMarker, jTextCountMarker, startButton);

        buttonPanel.add(lightThemeButton);
        buttonPanel.add(darkThemeButton);
        buttonPanel.add(engLanguageButton);
        buttonPanel.add(rusLanguageButton);

        middleButtonPanel.add(jTextTypeMarker);
        middleButtonPanel.add(jComboBox);

        middleButtonPanel.add(jTextWeightMarker);
        middleButtonPanel.add(jSpinnerWeight);

        middleButtonPanel.add(jTextCountMarker);
        middleButtonPanel.add(jSpinnerCount);
        middleButtonPanel.add(startButton);

        eastButtonPanel.add(result);

        add(buttonPanel, BorderLayout.NORTH);
        add(middleButtonPanel, BorderLayout.CENTER);
        add(eastButtonPanel, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }

    private void updateResult() {
        StringBuilder builder = new StringBuilder();
        holder.getCalculatingList().stream().forEach(builder::append);

        jTextArea.setText(builder.toString());
    }

    private class Theme {
        private void light(ActionEvent e) {

            Marker.appendLightTheme(lightThemeButton, darkThemeButton,
                    engLanguageButton, rusLanguageButton, startButton);

            Marker.appendLightTheme(buttonPanel, middleButtonPanel, eastButtonPanel);
            Marker.appendLightTheme(jTextTypeMarker, jTextWeightMarker, jTextCountMarker);
            Marker.appendLightTheme(jTextArea);

            lightThemeButton.setBorderPainted(true);
            darkThemeButton.setBorderPainted(false);
        }

        private void dark(ActionEvent e) {

            Marker.appendDarkTheme(lightThemeButton, darkThemeButton,
                    engLanguageButton, rusLanguageButton, startButton);

            Marker.appendDarkTheme(buttonPanel, middleButtonPanel, eastButtonPanel);
            Marker.appendDarkTheme(jTextTypeMarker, jTextWeightMarker, jTextCountMarker);
            Marker.appendDarkTheme(jTextArea);

            darkThemeButton.setBorderPainted(true);
            lightThemeButton.setBorderPainted(false);
        }

        private void init() {
            lightThemeButton.setFocusPainted(false);
            darkThemeButton.setFocusPainted(false);
            engLanguageButton.setFocusPainted(false);
            rusLanguageButton.setFocusPainted(false);
            startButton.setFocusPainted(false);
        }
    }

    private class Text {
        private void setEngText(ActionEvent e) {
            Locale.setDefault(Locale.ENGLISH);
            setLocale(Locale.getDefault());
            Marker.updateText(resourceBundle, jFrame, lightThemeButton,
                    darkThemeButton, engLanguageButton, rusLanguageButton, jTextTypeMarker,
                    jTextWeightMarker, jTextCountMarker, startButton);
            engLanguageButton.setBorderPainted(true);
            rusLanguageButton.setBorderPainted(false);
            updateResult();
        }

        private void setRusText(ActionEvent e) {
            Locale.setDefault(new Locale(BundleKeys.RU));
            setLocale(Locale.getDefault());
            Marker.updateText(resourceBundle, jFrame, lightThemeButton,
                    darkThemeButton, engLanguageButton, rusLanguageButton, jTextTypeMarker,
                    jTextWeightMarker, jTextCountMarker, startButton);
            engLanguageButton.setBorderPainted(false);
            rusLanguageButton.setBorderPainted(true);
            updateResult();
        }
    }

    private class Start {
        private void start(ActionEvent e) {
            currentCalculating = new Calculating((task.by.faifly.model.Type) jComboBox.getSelectedItem());
            currentCalculating.setWeight((Double) jSpinnerWeight.getValue());
            currentCalculating.setCount((Integer) jSpinnerCount.getValue());
            holder.add(currentCalculating);
            updateResult();
        }
    }
}
