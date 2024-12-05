package lt.vcs.pom.test.ultimateqa;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.Locator;
import lt.vcs.pom.page.demoqa.RadioButtonPage;
import lt.vcs.pom.page.ultimateqa.ElementsAutomationPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsAutomationTest extends TestBase {
    @Override
    @BeforeMethod
    public void setUp() {
        ElementsAutomationPage.open();
    }

    @Test
    public void testClickOnRadioButtonMale() {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonMale();

        actualResult = ElementsAutomationPage.isRadioButtonMaleSelected();


        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }

    @Test
    public void testClickOnRadioButtonFemale()  {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonFemale();

        actualResult = ElementsAutomationPage.isRadioButtonFemaleSelected();


        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );

    }

    @Test
    public void testClickOnRadioButtonOther() {
        boolean actualResult;

        ElementsAutomationPage.clickOnRadioButtonOther();

        actualResult = ElementsAutomationPage.isRadioButtonOtherSelected();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );

    }

    @Test
    public void testRadioButtonGenderMaleSelected() {
        boolean actualResult;
        ElementsAutomationPage.clickOnRadioButtonMale();
        actualResult = ElementsAutomationPage.isRadioButtonMaleSelected();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }

    @Test
    public void testRadioButtonGenderFemaleSelected() {
        boolean actualResult;
        ElementsAutomationPage.clickOnRadioButtonFemale();
        actualResult = ElementsAutomationPage.isRadioButtonFemaleSelected();

        Assert.assertTrue(
                actualResult,
                "\nButton is not disabled"
        );
    }
    @Test
    public void testFormEmailMe_NameVardenisAndValidEmail(){
        String userName = "Vardenis";
        String email = "demo@demo.com";
        String expectedResult = "Thanks for contacting us";
        String actualResult;

        ElementsAutomationPage.enterUserName(userName);
        ElementsAutomationPage.enterEmail(email);
        ElementsAutomationPage.clickOnButtonEmailMe();
        actualResult = ElementsAutomationPage.readThanksMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }


}
