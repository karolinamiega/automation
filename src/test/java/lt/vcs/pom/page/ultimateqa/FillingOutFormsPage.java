package lt.vcs.pom.page.ultimateqa;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class FillingOutFormsPage {
    public static final By inputName = By.xpath("//input[@id='et_pb_contact_name_0']");
    public static final By inputEmail = By.xpath("//textarea[@id='et_pb_contact_message_0']");
    public static final By clickOnSubmit = By.xpath("(//button[@name='et_builder_submit_button'])[1]");
    public static final By readThanksMessage = By.xpath("//div[@id='et_pb_contact_form_0']/div/p");
    public static final By errorMessageOne = By.xpath("(//div[@id='et_pb_contact_form_0']//p[contains(text(), 'fill in')])");
    public static final By errorMessageTwo = By.xpath("//div[@id='et_pb_contact_form_0']//ul/li");


    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://ultimateqa.com/filling-out-forms/");
    }

    public static void enterName(String name) {
        Common.sendKeysToElement(inputName, name);
    }

    public static void enterMessage(String email) {
        Common.sendKeysToElement(inputEmail, email);
    }

    public static void pressSubmitButton() {
        Common.clickOnElement(clickOnSubmit);
    }

    public static String readInput() {
        Common.waitElementIsVisible(readThanksMessage, 7);
        return Common.getTextFromElement(readThanksMessage);
    }
    public static String readErrorMessageOne() {
        Common.waitForPageLoadAndAjaxComplete( 7);
        return Common.getTextFromElement(errorMessageOne);
    }
    public static String readErrorMessageTwo() {
        Common.waitForPageLoadAndAjaxComplete( 7);
        return Common.getTextFromElement(errorMessageTwo);
    }
}
