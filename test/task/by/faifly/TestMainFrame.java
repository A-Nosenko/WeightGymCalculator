package task.by.faifly;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anatolii Nosenko
 * @version 1.0 2/13/2018.
 */
public class TestMainFrame extends AbstractUiTest {

    private JButtonFixture lightThemeButtonFixture;
    private JButtonFixture darkThemeButtonFixture;
    private JButtonFixture engLanguageButtonFixture;
    private JButtonFixture rusLanguageButtonFixture;
    private JButtonFixture startButtonFixture;

    @Override
    @Before
    public void onSetUp() {
        super.onSetUp();
        this.lightThemeButtonFixture = this.frame.button(JButtonMatcher.withText("Light theme"));
        this.darkThemeButtonFixture = this.frame.button(JButtonMatcher.withText("Dark theme"));
        this.engLanguageButtonFixture = this.frame.button(JButtonMatcher.withText("En"));
        this.rusLanguageButtonFixture = this.frame.button(JButtonMatcher.withText("Рус"));
        this.startButtonFixture = this.frame.button(JButtonMatcher.withText("Start!"));
    }

    @Test
    public void testButtons() throws Exception {
        lightThemeButtonFixture.requireVisible().requireEnabled().click();
        darkThemeButtonFixture.requireVisible().requireEnabled().click();
        engLanguageButtonFixture.requireVisible().requireEnabled().click();
        rusLanguageButtonFixture.requireVisible().requireEnabled().click();
        startButtonFixture.requireVisible().requireEnabled().click();
    }

    @Override
    @After
    public void onTearDown() {
        super.onTearDown();
    }
}
