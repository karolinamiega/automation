package lt.vcs.pom.test.ultimateqa;

import lt.vcs.pom.page.ultimateqa.FillingOutFormsPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FillingOutFormsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        FillingOutFormsPage.open();
    }
    @Test
    public void testPositiveFillingOutFormsExpectedThanksMessage(){
        String name = "Vardenis";
        String message = "dsjkahdjkshajkdhsk";
        String expectedResult = "Thanks for contacting us";
        String actualResult;

        FillingOutFormsPage.enterName(name);
        FillingOutFormsPage.enterMessage(message);
        FillingOutFormsPage.pressSubmitButton();

        actualResult = FillingOutFormsPage.readInput();


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }
    @Test
    public void testNegativeFillingOutFormsEmptyName(){
        String name = "";
        String message = "dsjkahdjkshajkdhsk";

        String actualResult;
        String errorMessageOne;
        String errorMessageTwo;

        FillingOutFormsPage.enterName(name);
        FillingOutFormsPage.enterMessage(message);
        FillingOutFormsPage.pressSubmitButton();
        errorMessageOne = FillingOutFormsPage.readErrorMessageOne();
        errorMessageTwo = FillingOutFormsPage.readErrorMessageTwo();
        actualResult = errorMessageOne + " " + errorMessageTwo;
        String expectedResult = "Please, fill in the following fields: Name";

        if (errorMessageOne.contains("Please, fill in the following fields") && errorMessageTwo.contains("Name")) {
            Assert.assertTrue(
                    actualResult.contains(expectedResult),
                    "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
            );
        }
    }

    @Test
    public void testNegativeFillingOutFormsEmptyMessage(){
        String name = "Vardenis";
        String message = "";

        String actualResult;
        String errorMessageOne;
        String errorMessageTwo;

        FillingOutFormsPage.enterName(name);
        FillingOutFormsPage.enterMessage(message);
        FillingOutFormsPage.pressSubmitButton();
        errorMessageOne = FillingOutFormsPage.readErrorMessageOne();
        errorMessageTwo = FillingOutFormsPage.readErrorMessageTwo();
        actualResult = errorMessageOne + " " + errorMessageTwo;
        String expectedResult = "Please, fill in the following fields: Message";

        if (errorMessageOne.contains("Please, fill in the following fields") && errorMessageTwo.contains("Message")) {
            Assert.assertTrue(
                    actualResult.contains(expectedResult),
                    "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
            );
        }
    }




    @DataProvider(name = "provideDataTestContactForm")
    public Object[][] provideDataForTestContactForm(){
        return new Object[][]{
                {true, "Vardenis", "My message", "Thanks for contacting us", ""},
                {false, "", "Hello there", "Please, fill in the following fields: ", "Name"},
                {false, "Vardenis", "", "Please, fill in the following fields: ", "Message"},

        };
    }
    @Test(dataProvider = "provideDataTestContactForm")
    public void testContactForm(Boolean positive, String name, String message, String expectedMessage, String errorItem){
        FillingOutFormsPage.enterName(name);
        FillingOutFormsPage.enterMessage(message);
        FillingOutFormsPage.pressSubmitButton();

        String actualMessage;
        String actualErrorItem;


        if(positive){
             actualMessage = FillingOutFormsPage.readInput();
            actualErrorItem = "";
        } else {
             actualMessage = FillingOutFormsPage.readErrorMessageOne() + " " + FillingOutFormsPage.readErrorMessageTwo();
            actualErrorItem = FillingOutFormsPage.readErrorMessageField();
            }

        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "\nActual: %s\nExpected contains: %s".formatted(actualMessage, expectedMessage)
        );

        Assert.assertTrue(
                actualMessage.contains(expectedMessage) && actualErrorItem.contains(errorItem),
                "\nActual: %s\nExpected contains: %s".formatted(actualErrorItem, errorItem)
        );
        }


}
