package task.by.faifly.model;

import java.awt.*;

/**
 * Coefficients to calculate are taken from
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 * @see <a href = "http://extrastrong.ru/2010/04/22/max-squats-bench-press-deadlift/"> this </a>
 * site
 */
public class Constants {

    public static final Color LIGHT_THEME_COLOR = new Color(200, 211, 200);
    public static final Color DARK_THEME_COLOR = new Color(31, 51, 71);

    public static final String RES_NAME = "resources";
    public static final String DATE_FORMATTING = "%1$tT %1$tM %1$te,%1$tY";
    public static final String EQUALS = " = ";

    public static final int WIDTH = 700;
    public static final int HIGHT = 700;
    public static final int WIDTH_RESULT_TEXT = 300;

    public static final double MAX_WEIGHT = 1000;

    public static final int KEYS_LENGTH = 11;
    public static final double[] BENCH_PRESSING_KEYS = new double[]{
            0, 1.0, 1.035, 1.08, 1.115, 1.15, 1.18, 1.22, 1.255, 1.29, 1.325
    };
    public static final double[] DEADLIFT_KEYS = new double[]{
            0, 1.0, 1.065, 1.13, 1.147, 1.164, 1.181, 1.198, 1.232, 1.232, 1.24
    };
    public static final double[] SQUATS_KEYS = new double[]{
            0, 1.0, 1.0475, 1.13, 1.1575, 1.2, 1.242, 1.284, 1.326, 1.368, 1.41
    };

    public static class BundleKeys {
        public static final String TITLE = "title";
        public static final String CHOOSE_EXERCISE_TYPE = "choose_exercise_type";
        public static final String BENCH_PRESSING = "bench_pressing";
        public static final String DEADLIFT = "deadlift";
        public static final String SQUATS = "squats";
        public static final String CHOOSE_EXERCISES_COUNT = "choose_exercises_count";
        public static final String ENTER_THE_WEIGTH = "enter_the_weigth";
        public static final String LIGHT_THEME = "light_theme";
        public static final String DARK_THEME = "dark_theme";
        public static final String EN = "en";
        public static final String RU = "ru";
        public static final String RESULT = "result";
        public static final String START = "start";
    }
}
