package com.shejuti.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class TabUtils {

    public static void switchToNewTabAndVerifyTitle(WebDriver driver, String expectedTitle, int timeoutSeconds) {
        String originalWindow = driver.getWindowHandle();

        // Wait until a new tab is opened
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Wait until title matches
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.titleContains(expectedTitle));

        String actualTitle = driver.getTitle();
        if (!actualTitle.contains(expectedTitle)) {
            throw new AssertionError("Expected title to contain '" + expectedTitle + "' but found '" + actualTitle + "'");
        }

        System.out.println("✅ Switched to tab with title: " + actualTitle);
    }
}
