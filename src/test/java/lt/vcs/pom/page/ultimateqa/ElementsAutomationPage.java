package lt.vcs.pom.page.ultimateqa;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.Locator;
import org.openqa.selenium.By;

public class ElementsAutomationPage {


//"//input[@name='gender' and @value='male']"



    public static void open(){
        Common.setUpChrome(8);
        Common.openUrl("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    public static void close() {
        Common.close();
    }

    public static void clickOnRadioButtonMale() {
        Common.clickOnElement(Locator.UltimateQa.ElementsForAutomation.inputMale);
    }
    public static void clickOnRadioButtonFemale() {
        Common.clickOnElement(Locator.UltimateQa.ElementsForAutomation.inputFemale);
    }

    public static boolean isRadioButtonMaleSelected() {
        return Common.waitCustomisedElementSelected(Locator.UltimateQa.ElementsForAutomation.inputMale, 6);

    }

    public static boolean isRadioButtonFemaleSelected() {
        Common.waitElementSelected(Locator.UltimateQa.ElementsForAutomation.inputFemale, 6);
        return Common.isElementSelected(Locator.UltimateQa.ElementsForAutomation.inputFemale);
    }

    public static void clickOnRadioButtonOther() {
        Common.clickOnElement(Locator.UltimateQa.ElementsForAutomation.inputOther);
    }

    public static boolean readSelectedResultMale() {
        return Common.isElementSelected(Locator.UltimateQa.ElementsForAutomation.inputMale);
    }

    public static boolean readSelectedResultFemale() {
        return Common.isElementSelected(Locator.UltimateQa.ElementsForAutomation.inputFemale);
    }

    public static boolean readSelectedResultOther() {
        return Common.isElementSelected(Locator.UltimateQa.ElementsForAutomation.inputOther);
    }
}
