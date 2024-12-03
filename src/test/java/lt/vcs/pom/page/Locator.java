package lt.vcs.pom.page;

import org.openqa.selenium.By;

public class Locator {

    public static class DemoQa {
        public static class RadioButton {

            public static final By labelYes = By.xpath("//label[@for='yesRadio']");
            public static final By paragraphSelectedResult = By.xpath("//p[text()='You have selected ']");
            public static final By labelImpressive = By.xpath("//label[@for='impressiveRadio']");
            public static final By inputYes = By.xpath("//input[@id='yesRadio']");
            public static final By inputImpressive = By.xpath("//input[@id='impressiveRadio']");
            public static final By inputNo = By.xpath("//input[@id='noRadio']");

        }
        public static class TextBoxPage {

            public static By inputUserName = By.xpath("//input[@id='userName']");
            public static By buttonSubmit = By.xpath("//button[@id='submit']");

            public static By paragraphName = By.xpath("//p[@id='name']");
            public static By userEmail = By.xpath("//input[@id='userEmail']");
            public static By paragraphEmail = By.xpath("//p[@id='email']");
            public static By textareaCurrentAddress = By.xpath("//textarea[@id='currentAddress']");
            public static By paragraphCurrentAddress = By.xpath("//p[@id='currentAddress']");
            public static By paragraphPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");

        }

        public static class DynamicProperties{
            public static By buttonEnableAfter = By.xpath("//button[@id='enableAfter']");
            public static By buttonColorChange = By.xpath("//button[@id='colorChange']");
            public static By buttonVisibleAfter = By.xpath("//button[@id='visibleAfter']");
        }
    }
    public static class UltimateQa {

        public static class ElementsForAutomation {
            public static final By inputMale = By.xpath("//input[@value='male']");
            public static final By inputFemale = By.xpath("//input[@value='female']");
            public static final By inputOther = By.xpath("//input[@value='other']");

            public static By getRadioButtonGenderLocator(String value){
                return By.xpath("//input[@name='gender' and @value='%s']".formatted(value));
            }
        }
    }
}
