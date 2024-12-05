package lt.vcs.pom.page.demoqa;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class RadioButtonPage {
    private static final By labelYes = By.xpath("//label[@for='yesRadio']");
    private static final By paragraphSelectedResult = By.xpath("//p[text()='You have selected ']");
    private static final By labelImpressive = By.xpath("//label[@for='impressiveRadio']");
    private static final By inputYes = By.xpath("//input[@id='yesRadio']");
    private static final By inputImpressive = By.xpath("//input[@id='impressiveRadio']");
    private static final By inputNo = By.xpath("//input[@id='noRadio']");

    private static By getRadioButtonLocator(String value){
        return By.xpath("//label[@for='%s']".formatted(value));
    }

    public static void open() {
        Common.setUpChrome(8);
        Common.openUrl("https://demoqa.com/radio-button");
    }

    public static void close() {
        Common.close();
    }

    public static void clickOnRadioButtonYes() {
        Common.clickOnElement(labelYes);
    }

    public static String readSelectedResult() {
        return Common.getTextFromElement(paragraphSelectedResult);
    }

    public static void clickOnRadioButtonImpressive() {
        Common.clickOnElement(labelImpressive);
    }

    public static void getLabelYesDetails() {
        Common.getCommonElementDetails(labelYes).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(
                Common.getElementAttributeValue(labelYes, "class")
        );

        System.out.println("Attributes with values: ");
        Common.getElementAllAtributes(labelYes).forEach((k, v) -> System.out.println('\t' + k + ": " + v));

    }

    public static void getInputYesDetails() {
        Common.getCommonElementDetails(inputYes).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(
                Common.getElementAttributeValue(inputYes, "class")
        );

        System.out.println("Attributes with values: ");
        Common.getElementAllAtributes(inputYes).forEach((k, v) -> System.out.println('\t' + k + ": " + v));
    }

    public static void getInputImpressiveDetails() {
        Common.getCommonElementDetails(inputImpressive).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(
                Common.getElementAttributeValue(inputImpressive, "class")
        );

        System.out.println("Attributes with values: ");
        Common.getElementAllAtributes(inputImpressive).forEach((k, v) -> System.out.println('\t' + k + ": " + v));
    }

    public static void getInputNoDetails() {
        Common.getCommonElementDetails(inputNo).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(
                Common.getElementAttributeValue(inputNo, "class")
        );

        System.out.println("Attributes with values: ");
        Common.getElementAllAtributes(inputNo).forEach((k, v) -> System.out.println('\t' + k + ": " + v));
    }

    public static boolean isRadioButtonNoDisabled() {
        return Common.isElementEnabled(inputNo);
    }

    public static void clickOnRadioButton(String value){
        Common.clickOnElement(
                getRadioButtonLocator(value)
        );
    }
}
