package lt.vcs.pom.test.seleniumeasy;

import lt.vcs.pom.page.seleniumeasy.DropdownDemoPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownDemoTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        DropdownDemoPage.open();

    }

    @Test
    public void testSingleDropdownList() throws InterruptedException {
        String selectDay = "Monday";
        String expectedMessage = "Monday";
        String expectedSelectedOption = "Monday";
        String actualMessage = "";
        String actualSelectedOption;

        DropdownDemoPage.selectDayOfWeek(selectDay);
        actualMessage = DropdownDemoPage.readDayOfWeek();

        actualSelectedOption = DropdownDemoPage.readSelectedOption();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "\nActual: %s\nExpected contains: %s".formatted(actualMessage, expectedMessage)
        );
        Assert.assertTrue(
                actualSelectedOption.contains(expectedSelectedOption),
                "\nActual: %s\nExpected contains: %s".formatted(actualSelectedOption, expectedSelectedOption)
        );
    }
    @Test
    public void testMultipleSelectDropdownList(){
        List<String> selectValues = List.of("California", "New Jersey", "Ohio", "Pennsylvania");
        boolean actualResult;

        DropdownDemoPage.selectCities(selectValues);
        DropdownDemoPage.pressSelectButton();

        actualResult = DropdownDemoPage.checkSelectedCities(selectValues);

        Assert.assertTrue(actualResult);
    }
}
