package lt.vcs.pom.page.demoqa;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

import java.util.List;

import static lt.vcs.pom.page.Locator.DemoQa.Checkbox.buttonExpandAll;
import static lt.vcs.pom.page.Locator.DemoQa.Checkbox.getCheckboxLocator;

public class CheckBoxPage {

    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://demoqa.com/checkbox");
    }

    public static By getCheckboxLabelLocator(String value){
        return By.xpath(
                "//label[@for='tree-node-%s']".formatted(value)
        );
    }

    public static void expandAll() {
        Common.clickOnElement(buttonExpandAll);
    }

    public static void clickOnCheckBoxHome(String value) {
        Common.clickOnElement(getCheckboxLabelLocator(value));
    }


    public static boolean isAllCheckboxesSelected(String value) {
        return !Common.getListAllElementsSelected(getCheckboxLocator(value)).contains(false);
    }


}
