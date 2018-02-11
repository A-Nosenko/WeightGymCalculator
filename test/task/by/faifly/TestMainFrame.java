package task.by.faifly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task.by.faifly.viev_controller.MainFrame;
import static org.junit.Assert.*;

import java.util.logging.Logger;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/12/2018.
 */
public class TestMainFrame {
    private static final Logger LOG = Logger.getLogger(TestMainFrame.class.getName());

    private MainFrame mainFrame;

    @Before
    public void setUp() throws Exception {
        LOG.info("Test MainFrame has started ");
        mainFrame = new MainFrame();
    }

    @Test
    public void test() throws Exception {
        assertNotNull(mainFrame);

    }

    @After
    public void tearDown() throws Exception {
        mainFrame = null;
        LOG.info("Test MainFrame has finished ");
    }
}
