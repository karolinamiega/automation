package lt.vcs.pom.page.seleniumeasy;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

import java.util.List;

public class DropdownDemoPage {
    private static final By selectSingleDemo = By.xpath("//select[@id='select-demo']");
    private static final By paragraphSelectDemo = By.xpath("//select[@id='select-demo']/../p [2]");
    private static final By selectMultipleDemo = By.xpath("//select[@id='multi-select']");
    private static final By paragraphMultipleSelect = By.xpath("//p[@class='getall-selected']");
    private static final By buttonAllSelected = By.xpath("//button[@id='printAll']");

    public static void open() {
        Common.setUpChrome(14);
        Common.openUrl("https://web.archive.org/web/20230608175735/http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    public static void selectDayOfWeek(String value) {
        Common.selectOptionByValue(
                selectSingleDemo,
                value
        );
    }

    public static String readDayOfWeek() {
       return Common.getTextFromElement(paragraphSelectDemo);
    }

    public static String readSelectedOption() {
        return Common.readSelectedOptionValue(selectSingleDemo);
    }

    public static void selectCities(List<String> values) {
        Common.selectMultipleValues(
                selectMultipleDemo,
                values);
    }

    public static String readCities() {
        return Common.getTextFromElement(paragraphMultipleSelect);
    }

    public static void pressSelectButton() {
        Common.clickOnElement(buttonAllSelected);

    }

    public static boolean checkSelectedCities(List<String> selectValues) {
        List<String> selectedValues = Common.getSelectedOptionValues(selectMultipleDemo);

        System.out.println(selectedValues);
        if(selectedValues.size() != selectValues.size()) return false;

//        for (String value : selectedValues) {
//            if (!selectValues.contains(value)) return false;
//        }

//        boolean contains = false;
//
//        for (String valueActual : selectedValues) {
//            for (String valueExpected : selectValues) {
//                if(valueActual == valueExpected){
//                    contains = true;
//                    break;
//                }
//            }
//            if (contains == false) return false;
//            contains = false;
//        }


        return selectValues.containsAll(selectValues);
    }
}
