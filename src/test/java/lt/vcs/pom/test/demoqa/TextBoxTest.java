package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.demoqa.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {

    @BeforeMethod
    public void setUp(){
        TextBoxPage.open();
    }
    @Test
    public void testFullNameExpectedContainsKarolina() {
        String inputFullName = "Karolina";
        String expectedResult = "Karolina";
        String actualResult;

        TextBoxPage.enterUserName(inputFullName);

        TextBoxPage.clickOnButtonSubmit();

        actualResult = TextBoxPage.readFullName();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );

    }

    @Test
    public void testEmail(){
        String inputEmail = "email@gmail.com";
        String expectedResult = "email@gmail.com";
        String actualResult;

        TextBoxPage.enterUserEmail(inputEmail);

        TextBoxPage.clickOnButtonSubmit();

        actualResult = TextBoxPage.readUserEmail();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @AfterMethod
    public void tearDown(){
        TextBoxPage.close();
    }
}
