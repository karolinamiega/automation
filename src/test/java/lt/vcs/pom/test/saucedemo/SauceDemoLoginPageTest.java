package lt.vcs.pom.test.saucedemo;

import lt.vcs.pom.page.saucedemo.SauceDemoAfterLoginPage;
import lt.vcs.pom.page.saucedemo.SauceDemoLoginPage;
import lt.vcs.pom.page.webdriveruniversity.ContactUsPage;
import lt.vcs.pom.test.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoLoginPageTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        SauceDemoLoginPage.open();
    }

    @DataProvider(name = "provideDataForTestPositiveExpectedAfterLoginPageOpened")
    public Object[][] dataProvidedForTestPositiveExpectedAfterLoginPageOpened(){
        return new Object[][] {
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
        };
    }

    @Test (dataProvider = "provideDataForTestPositiveExpectedAfterLoginPageOpened")
    public void testPositiveExpectedAfterLoginPageOpened(
            String username,
            String password,
            String expectedUrl,
            String expectedLogo
    ){

        SauceDemoLoginPage.inputUserName(username);
        SauceDemoLoginPage.inputPassword(password);
        SauceDemoLoginPage.clickLoginButton();

        String actualUrl = SauceDemoAfterLoginPage.readUrl();
        String actualLogo = SauceDemoAfterLoginPage.readLogo();


        Assert.assertTrue(
                actualUrl.contains(expectedUrl),
                "\nActual: %s\nExpected contains: %s".formatted(actualUrl, expectedUrl)
        );

        Assert.assertTrue(
                actualLogo.contains(expectedLogo),
                "\nActual: %s\nExpected contains: %s".formatted(actualLogo, expectedLogo)
        );


    }

}
