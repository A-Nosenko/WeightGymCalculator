package task.by.faifly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task.by.faifly.model.Calculating;
import task.by.faifly.model.Constants;
import task.by.faifly.model.Type;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/11/2018.
 */
public class TestCalculating {
    private static final Logger LOG = Logger.getLogger(TestCalculating.class.getName());

    @Before
    public void setUp() throws Exception {
        LOG.info("Test Calculating has started ");
    }

    @Test
    public void test() throws Exception {
        Locale.setDefault(new Locale("ru"));
        calculationTesting();
        Locale.setDefault(Locale.ENGLISH);
        calculationTesting();
    }

    private void calculationTesting() {
        Calculating benchPressing = new Calculating(Type.BenchPressing);
        for (int i = 1; i <= 10; i++) {
            benchPressing.setCount(i);
            for (int j = 0; j < Constants.MAX_WEIGHT; j += 10) {
                benchPressing.setWeight(j);
                LOG.info(benchPressing.toString());
            }

            Calculating deadlift = new Calculating(Type.Deadlift);
            deadlift.setCount(i);
            for (int j = 0; j < Constants.MAX_WEIGHT; j += 10) {
                deadlift.setWeight(j);
                LOG.info(deadlift.toString());
            }

            Calculating squats = new Calculating(Type.Squats);
            squats.setCount(i);
            for (int j = 0; j < Constants.MAX_WEIGHT; j += 10) {
                squats.setWeight(j);
                LOG.info(squats.toString());
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("Test Calculating has finished ");
    }
}
