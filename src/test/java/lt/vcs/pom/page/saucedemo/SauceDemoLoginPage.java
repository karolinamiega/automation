package lt.vcs.pom.page.saucedemo;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class SauceDemoLoginPage {

   public static final By userName = By.xpath("//input[@id='user-name']");
   public static final By passWord = By.xpath("//input[@id='password']");
   public static final By login = By.xpath("//input[@id='login-button']");


    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://www.saucedemo.com/");
    }

    public static void inputUserName(String username){
        Common.sendKeysToElement(userName, username);
    }

    public static void inputPassword(String password) {
        Common.sendKeysToElement(passWord, password);
    }

    public static void clickLoginButton() {
        Common.clickOnElement(login);
    }


    public static void login(String userName, String password) {
        open();
        inputUserName(userName);
        inputPassword(password);
        clickLoginButton();
        Common.waitForPageLoadAndAjaxComplete(10);
    }

}
