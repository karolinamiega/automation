package lt.vcs.pom.page.webdriveruniversity;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;


public class ContactUsPage {
    public static final By enterFirstName = By.xpath("//input[@name='first_name']");
    public static final By enterLastName = By.xpath("//input[@name='last_name']");
    public static final By enterEmail = By.xpath("//input[@name='email']");
    public static final By enterComments = By.xpath("//textarea[@name='message']");
    public static final By clickOnSubmit = By.xpath("//input[@type='submit']");
    public static final By readThanksMessage = By.xpath("//div[@id='contact_reply']/h1");
    public static final By errorMessage = By.xpath("//body");


    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public static void enterFirstName(String firstName) {
        Common.sendKeysToElement(enterFirstName, firstName);
    }

    public static void enterLastName(String lastName) {
        Common.sendKeysToElement(enterLastName, lastName);

    }

    public static void enterEmail(String email) {
        Common.sendKeysToElement(enterEmail, email);

    }

    public static void enterComments(String comments) {
        Common.sendKeysToElement(enterComments, comments);

    }

    public static void clickOnButtonSubmit() {
        Common.clickOnElement(clickOnSubmit);
    }

    public static String readThanksMessage() {
        Common.waitElementIsVisible(readThanksMessage, 7);
        return Common.getTextFromElement(readThanksMessage);
    }

    public static String readTitle() {
        return Common.getTabTitle();
    }

    public static String readNewUrl() {
        return Common.getCurrentUrl();
    }

    public static String readErrorMessage() {
        Common.waitForPageLoadAndAjaxComplete( 7);
        return Common.getTextFromElement(errorMessage);
    }
}
