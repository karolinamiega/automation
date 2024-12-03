package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Common {
    public static void setUpChrome(){
        Driver.setChromeDriver();
    }
    public static void setUpChrome(int sec){
        Driver.setChromeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void close() {
        Driver.quitDriver();
    }

    private static JavascriptExecutor getJsExecutor(){
        return (JavascriptExecutor) Driver.getDriver();
    }

    private static WebElement getElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator){
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static Map<String, Object> getCommonElementDetails(By locator) {
        Map<String, Object> elementDetails = new LinkedHashMap<>();
        WebElement element = getElement(locator);

        elementDetails.put("tagName", element.getTagName());
        elementDetails.put("isDisplayed", element.isDisplayed());
        elementDetails.put("isEnabled", element.isEnabled());
        elementDetails.put("isSelected", element.isSelected());
        elementDetails.put("location", element.getLocation());

        return elementDetails;
    }


    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public static Map<String, String> getElementAllAtributes(By locator) {
        String script =
                "var items = {}; " +
                        "for (index = 0; index < arguments[0].attributes.length; ++index) { " +
                        "   items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value; " +
                        "}; " +
                        "return items;";

        return (Map<String, String>) getJsExecutor().executeScript(script, getElement(locator));
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static boolean waitCustomisedElementSelected(By locator, int seconds){
        WebElement element = getElement(locator);

            for (int i = 0; i < seconds * 2; i++) {
                try {
                if(element.isSelected()) return true;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }
    public static WebDriverWait getWebDriverWait(int seconds){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public static void waitElementSelected(By locator, int seconds){
        getWebDriverWait(seconds).until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitElementIsClickable(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitElementAttributeContains(
            By locator, String attributeName, String attributeValueContains, int seconds
    ) {
    getWebDriverWait(seconds)
            .until(ExpectedConditions.attributeContains(locator, attributeName, attributeValueContains));
    }

    public static void waitElementIsVisible(By locator, int seconds) {
         getWebDriverWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
