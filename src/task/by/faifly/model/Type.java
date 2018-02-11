package task.by.faifly.model;

import task.by.faifly.model.Constants.BundleKeys;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Contains three exercises.
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public enum Type {
    BenchPressing(Constants.BENCH_PRESSING_KEYS),
    Deadlift(Constants.DEADLIFT_KEYS),
    Squats(Constants.SQUATS_KEYS);

    private double[] keys;
    private Locale locale = Locale.getDefault();
    private Type(double[] keys) {
        this.keys = keys;
    }

    public double[] getKeys() {
        return keys;
    }


    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);
        switch (Type.this) {
            case BenchPressing:
                return resourceBundle.getString(BundleKeys.BENCH_PRESSING);
            case Deadlift:
                return resourceBundle.getString(BundleKeys.DEADLIFT);
            case Squats:
                return resourceBundle.getString(BundleKeys.SQUATS);
            default:
                return null;
        }
    }
}
