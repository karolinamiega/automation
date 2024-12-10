package lt.vcs.pom.page.ultimateqa;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.Locator;
import lt.vcs.pom.test.TestBase;
import org.openqa.selenium.By;

import static lt.vcs.pom.page.Locator.UltimateQa.ElementsForAutomation.*;

public class ElementsAutomationPage {


//"//input[@name='gender' and @value='male']"



    public static void open(){
        Common.setUpChrome(8);
        Common.openUrl("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    public static void close() {
        Common.close();
    }

    public static void clickOnRadioButtonMale() {
        Common.clickOnElement(getRadioButtonGenderLocator("male"));
    }
    public static void clickOnRadioButtonFemale() {
        Common.clickOnElement(getRadioButtonGenderLocator("female"));
    }

    public static boolean isRadioButtonMaleSelected() {
        return Common.waitCustomisedElementSelected(getRadioButtonGenderLocator("male"), 6);

    }

    public static boolean isRadioButtonFemaleSelected() {
        Common.waitElementSelected(getRadioButtonGenderLocator("female"), 6);
        return Common.isElementSelected(getRadioButtonGenderLocator("female"));
    }

    public static void clickOnRadioButtonOther() {
        Common.clickOnElement(getRadioButtonGenderLocator("other"));
    }

    public static boolean readSelectedResultMale() {
        return Common.isElementSelected(getRadioButtonGenderLocator("male"));
    }

    public static boolean readSelectedResultFemale() {
        return Common.isElementSelected(getRadioButtonGenderLocator("female"));
    }

    public static boolean readSelectedResultOther() {
        return Common.isElementSelected(getRadioButtonGenderLocator("other"));
    }

    public static boolean isRadioButtonOtherSelected() {
        Common.waitElementSelected(getRadioButtonGenderLocator("other"), 6);
        return Common.isElementSelected(getRadioButtonGenderLocator("other"));
    }

    public static void enterUserName(String userName) {
        Common.sendKeysToElement(inputUserName, userName);

    }

    public static void enterEmail(String email) {
        Common.sendKeysToElement(inputEmail, email);
    }

    public static void clickOnButtonEmailMe() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Common.clickOnElement(buttonEmailMe);

        Common.waitElementIsClickable(buttonEmailMe, 10);
        Common.clickOnElement(buttonEmailMe);
    }

    public static String readThanksMessage() {
        Common.waitElementIsVisible(paragraphThanksMessage, 10);
        return Common.getTextFromElement(paragraphThanksMessage);
    }

    public static void scrollDownJSExecutor() {
        Common.scrollDownWithJSExecutor();
    }

    public static void scrollDownJSToElement() {
        Common.scrollDownWithJSExecutorToElement(buttonSubmit2);

    }

    public static void scrollDownActions() {
        Common.scrollDownWithActions();
    }
}
