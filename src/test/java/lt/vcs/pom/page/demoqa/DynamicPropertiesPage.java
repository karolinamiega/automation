package lt.vcs.pom.page.demoqa;

import lt.vcs.pom.page.Common;

import static lt.vcs.pom.page.Locator.DemoQa.DynamicProperties.*;

public class DynamicPropertiesPage {

    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://demoqa.com/dynamic-properties");
    }

    public static void clickOnButtonEnableAfter() {
        Common.waitElementIsClickable(buttonEnableAfter, 7);
        Common.clickOnElement(buttonEnableAfter);
    }

    public static void clickOnButtonVisibleAfter() {
        Common.waitElementIsVisible(buttonVisibleAfter, 7);
        Common.clickOnElement(buttonVisibleAfter);
    }

    public static boolean isEnabledButtonEnableAfter() {
        return Common.isElementEnabled(buttonEnableAfter);
    }

    public static boolean isVisibleAfter() {
        return Common.isElementEnabled(buttonVisibleAfter);
    }

//    public static void getButtonAttributes() {
//        System.out.println("BEFORE:");
//        Common.getElementAllAtributes(buttonColorChange).forEach((k, v) -> System.out.println('\t' + k + ": " + v));
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("AFTER:");
//        Common.getElementAllAtributes(buttonColorChange).forEach((k, v) -> System.out.println('\t' + k + ": " + v));

//    }

    public static void clickOnColorChange(String attributeName, String attributeValueContains) {
        Common.waitElementAttributeContains(
                buttonColorChange, attributeName, attributeValueContains, 10
        );
        Common.clickOnElement(buttonColorChange);
    }

    public static String getAllAttributesButtonColorChange(String attributeName) {
        return Common.getElementAttributeValue(buttonColorChange, attributeName);
    }
}
