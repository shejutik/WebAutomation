package com.shejuti.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class TestUtils {

	/**
	 * Switches the WebDriver context to a newly opened browser tab and verifies the page title.
	 * <p>
	 * This utility waits for a second browser tab to open, switches control to it,
	 * and asserts that the new page's title contains the expected text.
	 * It throws an AssertionError if the expected title is not found within the specified timeout.
	 * </p>
	 *
	 * @param driver WebDriver instance
	 * @param expectedTitle Partial or full title text expected in the new tab
	 * @param timeoutSeconds Maximum wait time in seconds for the new tab and title to appear
	 * @throws AssertionError if the actual title does not contain the expected text within the timeout
	 */
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
    
    /**
     * Returns the browser's native HTML5 validation message for a given field.
     *
     * @param driver WebDriver instance
     * @param fieldElement WebElement representing the form input
     * @return validation message string or empty string if none
     */
    public static String getValidationMessage(WebDriver driver, WebElement fieldElement) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript("return arguments[0].validationMessage;", fieldElement);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Checks whether a validation message is shown (not necessarily its exact wording).
     *
     * @param driver WebDriver instance
     * @param fieldElement WebElement representing the form input
     * @return true if a message is present, false otherwise
     */
    public static boolean isValidationMessagePresent(WebDriver driver, WebElement fieldElement) {
        String message = getValidationMessage(driver, fieldElement);
        return message != null && !message.trim().isEmpty();
    }

    /**
     * Checks if the message contains general keywords for required field validation.
     * Cross-browser-friendly but not language/locale-independent.
     *
     * @param driver WebDriver instance
     * @param fieldElement WebElement representing the form input
     * @return true if the message contains expected keywords
     */
    public static boolean isValidationMessageForRequiredField(WebDriver driver, WebElement fieldElement) {
        String message = getValidationMessage(driver, fieldElement).toLowerCase();
        return message.contains("fill") && message.contains("field");
    }
}
