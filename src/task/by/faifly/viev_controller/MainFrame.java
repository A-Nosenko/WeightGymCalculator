package task.by.faifly.viev_controller;

import task.by.faifly.model.Calculating;
import task.by.faifly.model.CalculatingHolder;
import task.by.faifly.model.Constants;
import task.by.faifly.model.Constants.BundleKeys;
import task.by.faifly.viev_controller.handler.Marker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Main frame, contains UI components with their actions.
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public class MainFrame extends JFrame {

    private static final Logger LOG = Logger.getLogger(MainFrame.class.getName());

    private final Dimension dimension = new Dimension(Constants.WIDTH_RESULT_TEXT,
            Constants.HIGHT_RESULT_TEXT);
    private final task.by.faifly.model.Type[] items = new task.by.faifly.model.Type[]{
            task.by.faifly.model.Type.BenchPressing,
            task.by.faifly.model.Type.Deadlift,
            task.by.faifly.model.Type.Squats
    };
    private final JFrame jFrame = this;
    private final CalculatingHolder holder;
    private String imageGym = Constants.IMAGE_GYM;
    private String imageLift = Constants.IMAGE_LIFT;
    private String imageSquat = Constants.IMAGE_SQUAT;
    private JPanel northPanel;
    private JPanel middlePanel;
    private JPanel eastPanel;
    private JPanel southPanel;
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
    private JTextArea jTextArea;
    private JLabel jLabel;
    private Theme theme;
    private Text text;
    private Start start;
    private ImageUpdater imageUpdater;
    private ResourceBundle resourceBundle;
    private Locale locale;
    private Calculating currentCalculating;

    private String path = null;

    public MainFrame() {
        holder = CalculatingHolder.getHolder();
        locale = Locale.getDefault();

        updateTextRecourse();
        theme = new Theme();
        text = new Text();
        start = new Start();
        imageUpdater = new ImageUpdater();
        currentCalculating = new Calculating(task.by.faifly.model.Type.BenchPressing);
        initUI();
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        updateTextRecourse();
    }

    public void updateLight() {
        imageGym = Constants.IMAGE_GYM;
        imageLift = Constants.IMAGE_LIFT;
        imageSquat = Constants.IMAGE_SQUAT;

        updateTheImage(path);
    }

    public void updateDark() {
        imageGym = Constants.IMAGE_GYM_DD;
        imageLift = Constants.IMAGE_LIFT_DD;
        imageSquat = Constants.IMAGE_SQUAT_DD;

        updateTheImage(path);
    }

    private void updateTextRecourse() {
        resourceBundle = ResourceBundle.getBundle(Constants.RES_NAME, locale);
    }

    private void initUI() {
        setSize(Constants.WIDTH, Constants.HIGHT);

        northPanel = new JPanel();
        middlePanel = new JPanel();
        eastPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel.setMaximumSize(dimension);

        lightThemeButton = new JButton();
        lightThemeButton.addActionListener((e) -> {
            reversePath(false);
            theme.light();
        });

        darkThemeButton = new JButton();
        darkThemeButton.addActionListener((e) -> {
            reversePath(true);
            theme.dark();
        });

        engLanguageButton = new JButton();
        engLanguageButton.addActionListener(text::setEngText);

        rusLanguageButton = new JButton();
        rusLanguageButton.addActionListener(text::setRusText);

        northPanel.add(lightThemeButton);
        northPanel.add(darkThemeButton);
        northPanel.add(engLanguageButton);
        northPanel.add(rusLanguageButton);

        jTextTypeMarker = new JTextField();
        jTextTypeMarker.setEditable(false);
        jTextTypeMarker.setBorder(null);
        jTextTypeMarker.setEnabled(false);

        jComboBox = new JComboBox<>(items);
        jComboBox.addActionListener(imageUpdater::updateImage);

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

        JScrollPane result = new JScrollPane(jTextArea);

        startButton = new JButton();
        startButton.addActionListener(start::start);

        middlePanel.add(jTextTypeMarker);
        middlePanel.add(jComboBox);
        middlePanel.add(jTextWeightMarker);
        middlePanel.add(jSpinnerWeight);
        middlePanel.add(jTextCountMarker);
        middlePanel.add(jSpinnerCount);
        middlePanel.add(startButton);

        jLabel = new JLabel();
        imageUpdater.updateImage(null);
        southPanel.add(jLabel);

        Marker.updateText(resourceBundle, jFrame, lightThemeButton, darkThemeButton, engLanguageButton,
                rusLanguageButton, jTextTypeMarker, jTextWeightMarker, jTextCountMarker, startButton);

        eastPanel.setLayout(new BorderLayout());
        updateResult();
        eastPanel.add(result);

        add(northPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        theme.init();
        theme.light();
        text.setEngText(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

    }

    /**
     * Updates calculations results, suitable by language changing.
     */
    private void updateResult() {
        StringBuilder builder = new StringBuilder();
        holder.getCalculatingList().stream().forEach(builder::append);
        jTextArea.setText(builder.toString());
        eastPanel.updateUI();
    }

    private void reversePath(boolean flag) {
        if (flag) {
            switch (path) {
                case Constants.IMAGE_GYM:
                    path = Constants.IMAGE_GYM_DD;
                    break;
                case Constants.IMAGE_LIFT:
                    path = Constants.IMAGE_LIFT_DD;
                    break;
                case Constants.IMAGE_SQUAT:
                    path = Constants.IMAGE_SQUAT_DD;
                    break;
                default:
                    break;
            }
        } else {
            switch (path) {
                case Constants.IMAGE_GYM_DD:
                    path = Constants.IMAGE_GYM;
                    break;
                case Constants.IMAGE_LIFT_DD:
                    path = Constants.IMAGE_LIFT;
                    break;
                case Constants.IMAGE_SQUAT_DD:
                    path = Constants.IMAGE_SQUAT;
                    break;
                default:
                    break;
            }
        }
    }

    private void updateTheImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            ImageIcon imageIcon = new ImageIcon(image);
            jLabel.setIcon(imageIcon);
        } catch (IOException ex) {
            LOG.info(ex.getMessage());
        }
    }

    /**
     * Contains method to switch images.
     */
    private class ImageUpdater {
        private void updateImage(ActionEvent e) {

            if (e == null) {
                path = imageGym;
            } else {
                task.by.faifly.model.Type type = (task.by.faifly.model.Type)
                        ((JComboBox) e.getSource()).getSelectedItem();
                switch (type) {
                    case BenchPressing:
                        path = imageGym;
                        break;
                    case Deadlift:
                        path = imageLift;
                        break;
                    case Squats:
                        path = imageSquat;
                        break;
                }
            }
            updateTheImage(path);
        }
    }

    /**
     * Contains methods to apply light and dark themes and initial UI components state.
     */
    private class Theme {
        private void light() {

            Marker.appendLightTheme(lightThemeButton, darkThemeButton,
                    engLanguageButton, rusLanguageButton, startButton);

            Marker.appendLightTheme(northPanel, middlePanel, eastPanel, northPanel, southPanel);
            Marker.appendLightTheme(jTextTypeMarker, jTextWeightMarker, jTextCountMarker);
            Marker.appendLightTheme(jTextArea);

            lightThemeButton.setBorderPainted(true);
            darkThemeButton.setBorderPainted(false);

            updateLight();
        }

        private void dark() {

            Marker.appendDarkTheme(lightThemeButton, darkThemeButton,
                    engLanguageButton, rusLanguageButton, startButton);

            Marker.appendDarkTheme(northPanel, middlePanel, eastPanel, southPanel);
            Marker.appendDarkTheme(jTextTypeMarker, jTextWeightMarker, jTextCountMarker);
            Marker.appendDarkTheme(jTextArea);

            darkThemeButton.setBorderPainted(true);
            lightThemeButton.setBorderPainted(false);

            updateDark();
        }

        private void init() {
            lightThemeButton.setFocusPainted(false);
            darkThemeButton.setFocusPainted(false);
            engLanguageButton.setFocusPainted(false);
            rusLanguageButton.setFocusPainted(false);
            startButton.setFocusPainted(false);
        }
    }

    /**
     * Contains methods to specify language.
     */
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

    /**
     * Contains method to start calculation.
     */
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
