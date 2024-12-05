package lt.vcs.pom.test.webdriveruniversity;

import lt.vcs.pom.page.webdriveruniversity.ContactUsPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        ContactUsPage.open();
    }
    @Test
    public void testPositiveContactUsExpectedThanksMessage(){
        String firstName = "Vardenis";
        String lastName = "Pavardenis";
        String email = "demo@demo.com";
        String comments = "My special comments, 987437819, %^$@^*&";
        String expectedResult = "Thank You for your Message!";
        String expectedTitle = "Gianni Bruno - Designer";
        String expectedUrl = "https://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html";
        String actualResult;
        String actualTitle;
        String actualUrl;

        ContactUsPage.enterFirstName(firstName);
        ContactUsPage.enterLastName(lastName);
        ContactUsPage.enterEmail(email);
        ContactUsPage.enterComments(comments);
        ContactUsPage.clickOnButtonSubmit();
        actualResult = ContactUsPage.readThanksMessage();
        actualTitle = ContactUsPage.readTitle();
        actualUrl = ContactUsPage.readNewUrl();



        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testNegativeEmptyFirstName(){
        String firstName = "";
        String lastName = "Pavardenis";
        String email = "demo@demo.com";
        String comments = "My special comments, 987437819, %^$@^*&";
        String expectedResult = "Error: all fields are required";
        String actualResult;

        ContactUsPage.enterFirstName(firstName);
        ContactUsPage.enterLastName(lastName);
        ContactUsPage.enterEmail(email);
        ContactUsPage.enterComments(comments);
        ContactUsPage.clickOnButtonSubmit();
        actualResult = ContactUsPage.readErrorMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testNegativeEmptyLastName(){
        String firstName = "Vardenis";
        String lastName = "";
        String email = "demo@demo.com";
        String comments = "My special comments, 987437819, %^$@^*&";
        String expectedResult = "Error: all fields are required";
        String actualResult;

        ContactUsPage.enterFirstName(firstName);
        ContactUsPage.enterLastName(lastName);
        ContactUsPage.enterEmail(email);
        ContactUsPage.enterComments(comments);
        ContactUsPage.clickOnButtonSubmit();
        actualResult = ContactUsPage.readErrorMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testNegativeEmptyEmail(){
        String firstName = "Vardenis";
        String lastName = "Pavardenis";
        String email = "";
        String comments = "My special comments, 987437819, %^$@^*&";
        String expectedResult = "Error: all fields are required\nError: Invalid email address";
        String actualResult;

        ContactUsPage.enterFirstName(firstName);
        ContactUsPage.enterLastName(lastName);
        ContactUsPage.enterEmail(email);
        ContactUsPage.enterComments(comments);
        ContactUsPage.clickOnButtonSubmit();
        actualResult = ContactUsPage.readErrorMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testNegativeEmptyComments(){
        String firstName = "Vardenis";
        String lastName = "Pavardenis";
        String email = "demo@demo.com";
        String comments = "";
        String expectedResult = "Error: all fields are required";
        String actualResult;

        ContactUsPage.enterFirstName(firstName);
        ContactUsPage.enterLastName(lastName);
        ContactUsPage.enterEmail(email);
        ContactUsPage.enterComments(comments);
        ContactUsPage.clickOnButtonSubmit();
        actualResult = ContactUsPage.readErrorMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }
}
