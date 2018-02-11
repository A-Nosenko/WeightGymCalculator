package task.by.faifly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task.by.faifly.model.Constants;
import task.by.faifly.model.Type;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
public class TestTypes {
    final static Type benchPressing = Type.BenchPressing;
    final static Type deadlift = Type.Deadlift;
    final static Type squats = Type.Squats;
    private static final Logger LOG = Logger.getLogger(TestTypes.class.getName());

    @Before
    public void setUp() throws Exception {
        LOG.info("Test Types has started ");
        assertNotNull(benchPressing);
        assertNotNull(deadlift);
        assertNotNull(squats);
    }

    @Test
    public void test() throws Exception {
        assertTrue(benchPressing.getKeys().length == Constants.KEYS_LENGTH);
        assertTrue(deadlift.getKeys().length == Constants.KEYS_LENGTH);
        assertTrue(squats.getKeys().length == Constants.KEYS_LENGTH);
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("Test Types has finished ");
    }
}
