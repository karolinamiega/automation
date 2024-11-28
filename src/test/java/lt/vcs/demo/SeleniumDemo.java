package lt.vcs.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--window-position=1000,0");

//      Zoom solution for Windows
//      chromeOptions.addArguments("--force-device-scale-factor=0.7");

        chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        //      Zoom solution for Mac
        chromeDriver.get("chrome://settings");
        ((JavascriptExecutor) chromeDriver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.7)");

    }

    @AfterMethod
    public void tearDown(){
        chromeDriver.quit();
    }

    @Test
    public void demoWebDriver() throws InterruptedException {

        chromeDriver.get("https://www.selenium.dev");
        Thread.sleep(6000);

    }

    @Test
    public void demoChromeOptions() throws InterruptedException {

//        Thread.sleep(3000);

        chromeDriver.get("https://www.selenium.dev");

        System.out.println(chromeDriver.getTitle());
        System.out.println(chromeDriver.manage().logs().getAvailableLogTypes());
        System.out.println(chromeDriver.manage().logs());

        System.out.println(chromeDriver.manage().window().getPosition());
        System.out.println(chromeDriver.manage().window().getSize());

        System.out.println(chromeDriver.manage().timeouts().getScriptTimeout());
        System.out.println(chromeDriver.manage().timeouts().getImplicitWaitTimeout());
        System.out.println(chromeDriver.manage().timeouts().getPageLoadTimeout());


//        chromeDriver.navigate().to("https://peter.sh/experiments/chromium-command-line-switches/");
//
//        chromeDriver.navigate().back();
//        Thread.sleep(3000);
    }

    @Test
    public void testFullNameInDemoQaTextBox() throws InterruptedException {
        String input = "Karolina";
        String expectedResult = "Karolina";
        String actualResult;

        chromeDriver.get("https://demoqa.com/text-box");


        chromeDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys(input);


        WebElement buttonSubmit = chromeDriver.findElement(By.xpath("//button[@id='submit']"));

        buttonSubmit.click();

        WebElement paragraphName = chromeDriver.findElement(By.xpath("//p[@id='name']"));
        actualResult = paragraphName.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
                );

    }
    @Test
    public void testEmailInputInDemoQaTextBox() throws InterruptedException {
        String inputEmail = "email@gmail.com";
        String expectedResult = "email@gmail.com";

        chromeDriver.get("https://demoqa.com/text-box");

        WebElement inputEmailAddress = chromeDriver.findElement(By.xpath("//input[@id='userEmail']"));
        inputEmailAddress.sendKeys(inputEmail);

        WebElement buttonSubmit = chromeDriver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();

        WebElement emailOutput = chromeDriver.findElement(By.xpath("//p[@id='email']"));
        String actualResult = emailOutput.getText();

                Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testInputCurrentAddressInDemoQaTextBox(){
        String inputCurrentAddress = "Adresas 01, Vilnius";
        String expectedResult = "Adresas 01, Vilnius";

        chromeDriver.get("https://demoqa.com/text-box");

        WebElement textAreaCurrentAddress = chromeDriver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        textAreaCurrentAddress.sendKeys(inputCurrentAddress);

        WebElement buttonSubmit = chromeDriver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();

        WebElement emailOutput = chromeDriver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualResult = emailOutput.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );

    }

    @Test
    public void testInputPermanentAddressInDemoQaTextBox(){
        String inputPermanentAddress = "Adresas 02, Vilnius";
        String expectedResult = "Adresas 02, Vilnius";

        chromeDriver.get("https://demoqa.com/text-box");

        WebElement textAreaPermanentAddress = chromeDriver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        textAreaPermanentAddress.sendKeys(inputPermanentAddress);

        WebElement buttonSubmit = chromeDriver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();

        WebElement emailOutput = chromeDriver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualResult = emailOutput.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );

    }

}
