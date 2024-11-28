package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;

import java.time.Duration;

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
}
