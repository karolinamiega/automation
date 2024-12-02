package lt.vcs.pom.test.ultimateqa;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.demoqa.RadioButtonPage;
import lt.vcs.pom.page.ultimateqa.ElementsAutomationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsAutomationTest {
    @BeforeMethod
    public void setUp() {
        ElementsAutomationPage.open();
    }

    @Test
    public void testClickOnRadioButtonMale() throws InterruptedException {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonMale();
        Thread.sleep(500);
        actualResult = ElementsAutomationPage.readSelectedResultMale();


        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }

    @Test
    public void testClickOnRadioButtonFemale() throws InterruptedException {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonFemale();
        Thread.sleep(500);
        actualResult = ElementsAutomationPage.readSelectedResultFemale();


        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );

    }

    @Test
    public void testClickOnRadioButtonOther() throws InterruptedException {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonOther();
        Thread.sleep(500);
        actualResult = ElementsAutomationPage.readSelectedResultOther();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );

    }

    @Test
    public void testRadioButtonGenderMaleSelected() throws InterruptedException {
        boolean actualResult;
        ElementsAutomationPage.clickOnRadioButtonMale();
        actualResult = ElementsAutomationPage.isRadioButtonMaleSelected();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }

    @Test
    public void testRadioButtonGenderFemaleSelected() throws InterruptedException {
        boolean actualResult;
        ElementsAutomationPage.clickOnRadioButtonFemale();
        actualResult = ElementsAutomationPage.isRadioButtonFemaleSelected();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }

    @AfterMethod
    public void tearDown() {
        ElementsAutomationPage.close();
    }
}
