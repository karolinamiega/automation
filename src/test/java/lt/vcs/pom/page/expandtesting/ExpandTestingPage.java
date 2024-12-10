package lt.vcs.pom.page.expandtesting;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static lt.vcs.pom.page.Locator.UltimateQa.ElementsForAutomation.buttonSubmit2;

public class ExpandTestingPage {
    private static final By elementsSelect = By.xpath("//select[@id='elementsPerPageSelect']");
    private static final By countrySelect = By.xpath("//select[@id='country']");
    private static final By countryName = By.xpath("//option[@value='LT']");



    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://practice.expandtesting.com/dropdown");
    }

    public static void clickOnElementsPerPage() {
        Common.clickOnElement(elementsSelect);
    }

    public static void selectElementsPerPage(String value) {
        WebElement selectValue = Common.findElement(elementsSelect);
        Select select = new Select(selectValue);
        select.selectByValue(value);
    }

    public static Integer readSelectedElementsPerPage() {
        WebElement selectElement = Common.findElement(elementsSelect);

        Select select = new Select(selectElement);
        String selectedOptionText = select.getFirstSelectedOption().getText().trim();

        return Integer.parseInt(selectedOptionText);
    }

    public static void clickOnSelectCountry() {
        Common.clickOnElement(countrySelect);
    }

    public static void selectCountry(String value) {
        WebElement selectValue = Common.findElement(countrySelect);
        Select select = new Select(selectValue);
        select.selectByValue(value);
    }

    public static String readSelectedCountry() {
        WebElement countryElement = Common.findElement(countryName);
        return countryElement.getText();
    }
}
