package lt.vcs.pom.test.expandtesting;

import lt.vcs.pom.page.expandtesting.ExpandTestingPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ExpandTestingTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        ExpandTestingPage.open();
    }

    @Test
    public void testElementsPerPage(){
        Integer expectedResult = 20;
        Integer actualResult;

        ExpandTestingPage.clickOnElementsPerPage();
        ExpandTestingPage.selectElementsPerPage(String.valueOf(expectedResult));
        actualResult = ExpandTestingPage.readSelectedElementsPerPage();


        Assert.assertEquals(expectedResult, actualResult, "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult));
    }

    @Test
    public void testCountrySelection(){
        String expectedOption = "LT";
        String expectedResult = "Lithuania";
        String actualResult;

        ExpandTestingPage.clickOnSelectCountry();
        ExpandTestingPage.selectCountry(expectedOption);
        actualResult = ExpandTestingPage.readSelectedCountry();


        Assert.assertEquals(actualResult, expectedResult);
    }

}
