package lt.vcs.pom.page.demoqa;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class RadioButtonPage {
    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://demoqa.com/radio-button");
    }

    public static void close() {
        Common.close();
    }

    public static void clickOnRadioButtonYes() {
        Common.clickOnElement(By.xpath("//label[@for='yesRadio']"));
    }

    public static String readSelectedResult() {
        return Common.getTextFromElement(By.xpath("//p[text()='You have selected ']"));
    }

    public static void clickOnRadioButtonImpressive() {
        Common.clickOnElement(By.xpath("//label[@for='impressiveRadio']"));
    }

}
