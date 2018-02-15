package task.by.faifly;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import task.by.faifly.viev_controller.MainFrame;

import java.awt.*;
import java.util.logging.Logger;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/12/2018.
 */
public class AbstractUiTest extends AssertJSwingTestCaseTemplate {
    private static final Logger LOG = Logger.getLogger(AbstractUiTest.class.getName());

    /**
     * The main entry point for any tests: the wrapped MainWindow.
     */
    protected FrameFixture frame;

    @BeforeClass
    public static void setUpOnce() {
        LOG.info("UI testing started");
        // avoid UI test execution in a headless environment (e.g. when building in CI environment like Jenkins or TravisCI)
        Assume.assumeFalse("Automated UI Test cannot be executed in headless environment", GraphicsEnvironment.isHeadless());
        FailOnThreadViolationRepaintManager.install();
    }


    @Before
    public final void setUp() {
        // call provided AssertJSwingTestCaseTemplate.setUpRobot()
        this.setUpRobot();
        // initialize the graphical user interface
        MainFrame mainWindow = GuiActionRunner.execute(new GuiQuery<MainFrame>() {

            @Override
            protected MainFrame executeInEDT() throws Throwable {
                return new MainFrame();
            }
        });
        this.frame = new FrameFixture(this.robot(), mainWindow);
        this.frame.show();
        onSetUp();
    }

    /**
     * Subclasses that need to set up their own test fixtures in this method. Called as <strong>last action</strong> during {@link #setUp()}.
     */
    protected void onSetUp() {
        // default: everything is already set up
    }

    /*****************************************************************************************
     * Here you could insert further helper methods, e.g. frequently used component matchers *
     *****************************************************************************************/

    /**
     * Cleans up any resources used in this test. After calling <code>{@link #onTearDown()}</code>,
     * this method cleans up resources used by this
     * test <code>{@link Robot}</code>.
     *
     * @see #cleanUp()
     * @see #onTearDown()
     */
    @After
    public final void tearDown() {
        try {
            onTearDown();
            this.frame = null;
        } finally {
            cleanUp();
        }
        LOG.info("UI testing finished");
    }

    /**
     * Subclasses that need to clean up resources can do so in this method.
     * Called as <strong>first action</strong> during {@link #tearDown()}.
     */
    protected void onTearDown() {
        // default: nothing more to tear down
    }
}
