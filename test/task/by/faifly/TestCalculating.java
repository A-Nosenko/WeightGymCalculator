package task.by.faifly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task.by.faifly.model.Calculating;
import task.by.faifly.model.Constants.BundleKeys;
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
        Locale.setDefault(Locale.ENGLISH);
        LOG.info(new Calculating(Type.BenchPressing, 8, 40).toString());
        LOG.info(new Calculating(Type.Deadlift, 8, 40).toString());
        LOG.info(new Calculating(Type.Squats, 8, 40).toString());
        Locale.setDefault(new Locale(BundleKeys.RU));
        LOG.info(new Calculating(Type.BenchPressing, 8, 40).toString());
        LOG.info(new Calculating(Type.Deadlift, 8, 40).toString());
        LOG.info(new Calculating(Type.Squats, 8, 40).toString());
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("Test Calculating has finished ");
    }
}
