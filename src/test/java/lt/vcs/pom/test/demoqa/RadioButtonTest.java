package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.demoqa.RadioButtonPage;
import lt.vcs.pom.page.demoqa.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @BeforeMethod
    public void setUp(){
        RadioButtonPage.open();
    }

@Test
public void testRadioButtonYes() throws InterruptedException {
    String expectedResult = "Yes";
    String actualResult;

    Thread.sleep(3000);
    RadioButtonPage.clickOnRadioButtonYes();
    actualResult = RadioButtonPage.readSelectedResult();


    Assert.assertTrue(
            actualResult.contains(expectedResult),
            "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
    );
}
@Test
public void testRadioButtonImpressive() throws InterruptedException {
    String expectedResult = "Impressive";
    String actualResult;

    Thread.sleep(3000);
    RadioButtonPage.clickOnRadioButtonImpressive();
    actualResult = RadioButtonPage.readSelectedResult();


    Assert.assertTrue(
            actualResult.contains(expectedResult),
            "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
    );
}


    @AfterMethod
    public void tearDown(){
        RadioButtonPage.close();
    }
}
