package lt.vcs.pom.test.ultimateqa;

import lt.vcs.pom.page.ultimateqa.ElementsAutomationPage;
import lt.vcs.pom.test.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollDownTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        ElementsAutomationPage.open();
    }

    @Test
    public void testScrollDownJSExecutor() throws InterruptedException {
    Thread.sleep(2000);
    ElementsAutomationPage.scrollDownJSExecutor();
    Thread.sleep(3000);
    }

    @Test
    public void testScrollDownJSToElement() throws InterruptedException {
        Thread.sleep(2000);
        ElementsAutomationPage.scrollDownJSToElement();
        Thread.sleep(3000);
    }

    @Test
    public void testScrollDownActions() throws InterruptedException {
        Thread.sleep(2000);
        ElementsAutomationPage.scrollDownActions();
        Thread.sleep(3000);
    }
}
