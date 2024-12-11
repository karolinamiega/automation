package lt.vcs.pom.test.demoqa;

import lt.vcs.pom.page.demoqa.CheckBoxPage;
import lt.vcs.pom.test.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static lt.vcs.pom.page.demoqa.CheckBoxPage.getCheckboxLabelLocator;

public class CheckBoxTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        CheckBoxPage.open();
    }

    @Test
    public void provideDataSelectHomeCheckbox() throws InterruptedException {

        CheckBoxPage.expandAll();
        CheckBoxPage.clickOnCheckBoxHome("home");

        Assert.assertTrue(CheckBoxPage.isAllCheckboxesSelected("home"));
    }

    @DataProvider(name = "provideDataSelectCheckboxGroup")
    public Object[][] provideDataForSelectCheckboxGroup() {
        return new Object[][]{
                {"home", "home"},
                {"desktop", "desktop"},
                {"documents", "documents"},
                {"workspace", "workspace"},
                {"office", "office"},
                {"downloads", "downloads"}

        };
    }

    @Test(dataProvider = "provideDataSelectCheckboxGroup")
    public void testSelectedCheckboxGroups(String valueSelect, String valueCheck) {

        CheckBoxPage.expandAll();
        CheckBoxPage.clickOnCheckBoxHome(valueSelect);

        Assert.assertTrue(CheckBoxPage.isAllCheckboxesSelected(valueCheck));



    }
}
