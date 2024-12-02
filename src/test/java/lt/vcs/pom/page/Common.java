package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

    public static boolean isElementDisabled(By locator) {
        return getElement(locator).isEnabled();
    }
}
