package lt.vcs.pom.test;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.demoqa.RadioButtonPage;
import lt.vcs.pom.util.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class TestBase {

    @BeforeMethod
    public void setUp(){
        RadioButtonPage.open();
    };

    @AfterMethod
    public void tearDown(){
        Common.close();
    }
}
