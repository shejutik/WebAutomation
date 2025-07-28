package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.LoginPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Contains Test cases on Login screen
 * This class extends the BaseTest class.
 */

public class LoginTest extends BaseTest {

	String testingDemoLoginUrl = ConfigReader.get("baseUrl") + "/testingdemologin";
	String testingDemoUrl = ConfigReader.get("baseUrl") + "/testingdemo";
	private By testingDemoHeader = By.xpath("//h2[text()='Testing Demo']");

    @Test
    public void testInvalidLoginShowsErrorMessage() {
        // Open login page
        driver.get(testingDemoLoginUrl);

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Use invalid credentials
        loginPage.login("wronguser", "wrongpass");

        // Define locator for error message
        By errorMsgLocator = By.xpath("//p[contains(text(),'Invalid credentials')]");

        // Use explicit wait to wait until message is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));

        // Assert message is displayed
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid login.");
    }
    
    @Test
    @Parameters({"username", "password"})
    public void testValidLogin(String username, String password) {
        // Open testing demo login page
        driver.get(testingDemoLoginUrl); 

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with valid credentials
        loginPage.login(username, password);

        // Validate navigation or presence of some element after login
        WaitUtils.waitUntilVisible(driver, testingDemoHeader, 10);
        Assert.assertEquals(driver.getCurrentUrl(), testingDemoUrl, "Login failed or redirection incorrect.");
    }
}
