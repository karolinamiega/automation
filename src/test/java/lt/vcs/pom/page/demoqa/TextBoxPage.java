package lt.vcs.pom.page.demoqa;
import lt.vcs.pom.page.Common;
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
                By.xpath("//input[@id='userName']"),
                input
        );
    }

    public static void clickOnButtonSubmit() {
        Common.clickOnElement(By.xpath("//button[@id='submit']"));
    }

    public static String readFullName() {
        return Common.getTextFromElement(By.xpath("//p[@id='name']"));
    }

    public static void enterUserEmail(String input) {
        Common.sendKeysToElement(
                By.xpath("//input[@id='userEmail']"),
                input
        );
    }

    public static String readUserEmail() {
        return Common.getTextFromElement(By.xpath("//p[@id='email']"));
    }

    public static void enterCurrentAddress(String input) {
        Common.sendKeysToElement(
                By.xpath("//textarea[@id='currentAddress']"),
                input
        );
    }

    public static String readCurrentAddress() {
        return Common.getTextFromElement(By.xpath("//p[@id='currentAddress']"));
    }

    public static void enterPermanentAddress(String input) {
        Common.sendKeysToElement(
                By.xpath("//textarea[@id='permanentAddress']"),
                input
        );
    }
    public static String readPermanentAddress() {
        return Common.getTextFromElement(By.xpath("//p[@id='permanentAddress']"));
    }
}
