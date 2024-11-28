package lt.vcs.pom.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static void setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--window-position=1000,0");

//      Zoom solution for Windows
//      chromeOptions.addArguments("--force-device-scale-factor=0.7");

        driver = new ChromeDriver(chromeOptions);

        //      Zoom solution for Mac
        driver.get("chrome://settings");
        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.7)");
    }

    public static void setFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        driver = new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }


}
