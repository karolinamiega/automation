package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.demoqa.ButtonsPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        ButtonsPage.open();
    }

    @Test
    public void testButtonClickActions(){
        String expectedResult = "dynamic click";
        String actualResult;

        ButtonsPage.clickOnButtonClickMe();
        actualResult = ButtonsPage.readMessageClickMe();


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testButtonDoubleClickActions(){
        String expectedResult = "double click";
        String actualResult;

        ButtonsPage.clickOnButtonDoubleClickMe();
        actualResult = ButtonsPage.readMessageDoubleClickMe();


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testButtonRightClickActions(){
        String expectedResult = "right click";
        String actualResult;

        ButtonsPage.clickOnButtonRightClickMe();
        actualResult = ButtonsPage.readMessageRightClickMe();


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }
}
