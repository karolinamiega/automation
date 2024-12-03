package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.demoqa.DynamicPropertiesPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        DynamicPropertiesPage.open();

    }

    @Test
    public void testButtonEnableAfter(){
        boolean actualResult;

        DynamicPropertiesPage.clickOnButtonEnableAfter();
        actualResult = DynamicPropertiesPage.isEnabledButtonEnableAfter();

        Assert.assertTrue(
                actualResult,
                "Button is not enabled"
        );
    }

    @Test
    public void testButtonColorChange(){
        String attributeName = "class";
        String attributeValueContains = "text-danger";
        String expectedResult = "text-danger";
        String actualResult = "";

//            DynamicPropertiesPage.getButtonAttributes();
            DynamicPropertiesPage.clickOnColorChange(attributeName, attributeValueContains);
            actualResult = DynamicPropertiesPage.getAllAttributesButtonColorChange(attributeName);

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testButtonVisibleAfter(){
        boolean actualResult;

        DynamicPropertiesPage.clickOnButtonVisibleAfter();
        actualResult = DynamicPropertiesPage.isVisibleAfter();

        Assert.assertTrue(
                actualResult,
                "Button is not visible"
        );
    }


}
