package lt.vcs.pom.page.demoqa;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class ButtonsPage {
    private static final By buttonClickMe = By.xpath("(//div[@class='mt-4'])[2]//button");
    //OR //button[text()='Click Me']
    private static final By paragraphDynamicText = By.xpath("//p[@id='dynamicClickMessage']");
    private static final By buttonDoubleClickMe = By.xpath("//button[@id='doubleClickBtn']");
    private static final By paragraphDoubleClickText = By.xpath("//p[@id='doubleClickMessage']");
    private static final By buttonRightClickMe = By.xpath("//button[@id='rightClickBtn']");
    private static final By paragraphRightClickText = By.xpath("//p[@id='rightClickMessage']");

    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://demoqa.com/buttons");
    }

    public static void clickOnButtonClickMe() {
        Common.clickOnElementWithActions(buttonClickMe);
    }

    public static String readMessageClickMe() {
        Common.waitElementIsVisible(paragraphDynamicText, 8);
        return Common.getTextFromElement(paragraphDynamicText);
    }

    public static void clickOnButtonDoubleClickMe() {
        Common.clickOnElementDoubleWithActions(buttonDoubleClickMe);
    }

    public static String readMessageDoubleClickMe() {
        Common.waitElementIsVisible(paragraphDoubleClickText, 8);
        return Common.getTextFromElement(paragraphDoubleClickText);
    }

    public static void clickOnButtonRightClickMe() {
        Common.clickOnElementRightWithActions(buttonRightClickMe);
    }

    public static String readMessageRightClickMe() {
        Common.waitElementIsVisible(paragraphRightClickText, 8);
        return Common.getTextFromElement(paragraphRightClickText);
    }
}
