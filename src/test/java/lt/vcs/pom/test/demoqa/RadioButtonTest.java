package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.Locator;
import lt.vcs.pom.page.demoqa.RadioButtonPage;
import lt.vcs.pom.page.demoqa.TextBoxPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class RadioButtonTest extends TestBase {
    @Override
    @BeforeMethod
    public void setUp(){
        RadioButtonPage.open();
    }

@Test
public void testRadioButtonYes(){
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

//@DataProvider(name = "dataProviderTestRadioButton")
//public Object[][] provideDataForTestRadioButton(){
//    Object[][] objects = new Object[2][];
//    objects[0] = new Object[]{"yesRadio", "Yes"};
//    objects[1] = new Object[]{"impresiveRadio", "Impressive"};
//
//    return objects;
//    }

    @DataProvider(name = "dataProviderTestRadioButton")
    public Object[][] provideDataForTestRadioButton(){
        return new Object[][]{
                {"yesRadio", "Yes"},
                {"impressiveRadio", "Impressive"}
        };
    }

    @Test(dataProvider = "dataProviderTestRadioButton")
    public void testRadioButton(String radioButtonValue, String expectedResult) {
//        String radioButtonValue = "yesRadio"; // yesRadio, impressiveRadio
//        String expectedResult = "Yes"; // Yes, Impressive;
        String actualResult;


        RadioButtonPage.clickOnRadioButton(radioButtonValue);
        actualResult = RadioButtonPage.readSelectedResult();


        Assert.assertEquals(actualResult, expectedResult);
    }

}
