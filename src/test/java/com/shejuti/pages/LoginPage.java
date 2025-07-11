package com.shejuti.pages; 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import com.shejuti.utils.WaitUtils;

/**
 * Page Object Model for the Login Page 
 * This class contains all the locators and actions related to the login screen.
 */
public class LoginPage {

    private WebDriver driver; // WebDriver reference to interact with the browser

    // ===== Locators for login page elements =====
    private By usernameInput = By.name("username");     // Assuming input field has name="username"
    private By passwordInput = By.name("password");     // Assuming input field has name="password"
    private By loginButton = By.id("loginButton"); // Login button identified by its id
    private By invalidCredentialErrorMsg = By.xpath("//p[contains(text(),'Invalid credentials')]");

    // ===== Constructor to initialize WebDriver =====
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods =====

    // Set username in username field
    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();      // Clear previous value (if any)
        driver.findElement(usernameInput).sendKeys(username);
    }

    // Set password in password field
    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();      // Clear previous value (if any)
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Click the login button
    public void clickLogin() {
    	WaitUtils.waitUntilClickable(driver, loginButton, 10);
        driver.findElement(loginButton).click();
    }

    // Perform full login in one step
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
 // Method to return error message text
    public String getErrorMessage() {
        try {
            return driver.findElement(invalidCredentialErrorMsg).getText();
        } catch (Exception e) {
            return null;
        }
    }

    // Method to check if error message is displayed
    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(invalidCredentialErrorMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
