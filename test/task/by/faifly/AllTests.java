package task.by.faifly;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.logging.Logger;

/**
 * Starts all tests.
 *
 * @author Anatolii Nosenko
 * @version 1.0 2/10/2018.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestTypes.class, TestCalculating.class
})
public class AllTests {
    private static final Logger LOG = Logger.getLogger(AllTests.class.getName());

    @Before
    public void setUp() throws Exception {
        LOG.info("Tests has started... ");
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("Tests has finished... ");
    }
}
