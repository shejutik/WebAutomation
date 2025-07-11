package com.shejuti.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Wait methods to 
✅ Reusable - No need to duplicate wait logic in every Page class
✅ Clean - Keeps page methods short and readable
✅ Flexible	- Can set different timeouts per action if needed
 */
public class WaitUtils {

    public static void waitUntilVisible(WebDriver driver, By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilClickable(WebDriver driver, By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitAndReturnElement(WebDriver driver, By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
