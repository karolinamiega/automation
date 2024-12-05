package lt.vcs.pom.page.saucedemo;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoAfterLoginPage {

    private static final By divAppLogo = By.xpath("//div[@class='app_logo']");

    public static String readUrl() {
        Common.waitForPageLoadAndAjaxComplete(10);
        return Common.getCurrentUrl();
    }

    public static String readLogo() {
        Common.waitElementIsVisible(divAppLogo, 7);
        return Common.getCurrentLogo();
    }

}
