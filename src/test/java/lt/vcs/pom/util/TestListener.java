package lt.vcs.pom.util;

import lt.vcs.pom.page.Locator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result.id(), result.getName());
    }

    private void takeScreenshot(String resultId, String testName) {
        if (Driver.getDriver() == null) return;
        if (Driver.getDriver() instanceof TakesScreenshot screenshot) {

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String formatedDateTime = LocalDateTime.now().format(formatter);

            String destFileName =
                    "./screenshots/%s_%s_%s_screenshot.png".formatted(
                            formatedDateTime, resultId, testName
                    );

            File destFile = new File(destFileName);

            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
