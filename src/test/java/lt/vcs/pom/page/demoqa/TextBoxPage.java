package lt.vcs.pom.page.demoqa;
import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.Locator;
import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;

import java.time.Duration;

public class TextBoxPage {
    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://demoqa.com/text-box");
    }



    public static void close() {
        Common.close();
    }

    public static void enterUserName(String input) {

        Common.sendKeysToElement(
                Locator.DemoQa.TextBoxPage.inputUserName,
                input
        );
    }

    public static void clickOnButtonSubmit() {
        Common.clickOnElement(Locator.DemoQa.TextBoxPage.buttonSubmit);
    }

    public static String readFullName() {
        return Common.getTextFromElement(Locator.DemoQa.TextBoxPage.paragraphName);
    }

    public static void enterUserEmail(String input) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBoxPage.userEmail,
                input
        );
    }

    public static String readUserEmail() {
        return Common.getTextFromElement(Locator.DemoQa.TextBoxPage.paragraphEmail);
    }

    public static void enterCurrentAddress(String input) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBoxPage.textareaCurrentAddress,
                input
        );
    }

    public static String readCurrentAddress() {
        return Common.getTextFromElement(Locator.DemoQa.TextBoxPage.paragraphCurrentAddress);
    }

    public static void enterPermanentAddress(String input) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBoxPage.paragraphPermanentAddress,
                input
        );
    }
    public static String readPermanentAddress() {
        return Common.getTextFromElement(Locator.DemoQa.TextBoxPage.paragraphPermanentAddress);
    }
}
