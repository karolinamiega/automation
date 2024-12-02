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


    RadioButtonPage.clickOnRadioButtonImpressive();
    actualResult = RadioButtonPage.readSelectedResult();


    Assert.assertTrue(
            actualResult.contains(expectedResult),
            "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
    );
}

@Test
public void getMainCommonElementDetails() throws InterruptedException {

    System.out.println("*** label YES ***");
    RadioButtonPage.getLabelYesDetails();

    System.out.println("\n *** input YES ***");
    RadioButtonPage.getInputYesDetails();

    RadioButtonPage.clickOnRadioButtonYes();
    Thread.sleep(200);

    System.out.println("\n *** input YES ***");
    RadioButtonPage.getInputYesDetails();

    System.out.println("\n *** input Impressive ***");
    RadioButtonPage.getInputImpressiveDetails();

    System.out.println("\n *** input No ***");
    RadioButtonPage.getInputNoDetails();

}

@Test
public void testRadioButtonNoIsDisabled(){
    boolean actualResult = RadioButtonPage.isRadioButtonNoDisabled();


    Assert.assertTrue(
            actualResult,
            "Button is not disabled"
    );
}




    @AfterMethod
    public void tearDown(){
        RadioButtonPage.close();
    }
}
