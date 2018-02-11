package task.by.faifly.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/11/2018.
 */
public class CalculatingHolder {
    private static CalculatingHolder holder;
    private List<Calculating> calculatingList;

    private CalculatingHolder() {
        calculatingList = new ArrayList<>();
    }

    public static CalculatingHolder getHolder() {
        if (holder == null) {
            holder = new CalculatingHolder();
            return holder;
        } else {
            return holder;
        }
    }

    public List<Calculating> getCalculatingList() {
        return calculatingList;
    }

    public boolean add(Calculating calculating) {
        return calculatingList.add(calculating);
    }
}
