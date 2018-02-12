package task.by.faifly.model;

import task.by.faifly.model.Constants.BundleKeys;

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public class Calculating {
    private Type type;
    private int count;
    private double weight;

    public Calculating(Type type) {
        this.type = type;
    }

    public Calculating(Type type, int count, double weight) {
        this.type = type;
        this.count = count;
        this.weight = weight;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public String getMaximum() {
        double result = weight * type.getKeys()[count];
        return String.format("%.1f", result);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(Constants.RES_NAME, locale);

        String date = new Formatter().format(
                locale, Constants.DATE_FORMATTING, new Date()).toString();
        builder.append(date);
        builder.append(System.lineSeparator());

        String report = resourceBundle.getString(BundleKeys.RESULT) + type + Constants.EQUALS
                + getMaximum() + resourceBundle.getString(BundleKeys.KG);
        builder.append(report);
        builder.append(System.lineSeparator());
        builder.append(System.lineSeparator());

        return builder.toString();
    }
}
