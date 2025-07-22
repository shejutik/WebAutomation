package com.shejuti.pages; 

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.shejuti.utils.WaitUtils;

/**
 * Page Object Model for the Testing Demo Page 
 * This class contains all the locators and actions related to the Testing Demo screen.
 */
public class TestingDemoPage {

    private WebDriver driver; // WebDriver reference to interact with the browser

    // ===== Locators for testing demo page elements =====
    private By chooseFileBtn = By.cssSelector("input[type='file']"); 
    private By usernameInput = By.name("username");     // input field has name="username"
    private By passwordInput = By.name("password"); 
    private By loginButton = By.id("loginButton"); 
    private By dropDownItem = By.cssSelector("div.dropdown-section select"); 
    private By itemNameInput = By.xpath("//input[@placeholder='Add item']");
    private By dynamicItemAddButton = By.xpath("//button[text()='Add']");
    private By logoutButton = By.xpath("//button[text()='Logout']");
    
    // ===== Constructor to initialize WebDriver =====
    public TestingDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods =====
    
    // Input File location
    public void inputFileLocation(String filePath) {

	    // Upload the file using sendKeys
    	WebElement uploadInput = driver.findElement(chooseFileBtn);
    	uploadInput.sendKeys(filePath);
    }
    
    // Method to check if success message is displayed for file upload
    public boolean isFileUploadSuccessMessageDisplayed(String fileName) {
    	
    	String successMessage = "File \"" + fileName + "\" uploaded successfully!";
    	
	    try {
	        return driver.findElement(By.xpath("//p[text()='" + successMessage + "']")).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
    }
    
    // Verify username input visible
    public boolean isUsernameInputVisible() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    // Verify password input visible
    public boolean isPasswordInputVisible() {
        try {
            return driver.findElement(passwordInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    // Set username in form validation
    public void enterUsernameForFormValidation(String username) {
        driver.findElement(usernameInput).clear();      // Clear previous value (if any)
        driver.findElement(usernameInput).sendKeys(username);
    }
    
    // Set password in form validation
    public void enterPasswordForFormValidation(String password) {
        driver.findElement(passwordInput).clear();      // Clear previous value (if any)
        driver.findElement(passwordInput).sendKeys(password);
    }
    
    // Click the login button for form validation
    public void clickFormValidationLogin() {
    	WaitUtils.waitUntilClickable(driver, loginButton, 10);
        driver.findElement(loginButton).click();
    }
    
    // Perform full form validation in one step
    public void performFormValidation(String username, String password) {
    	enterUsernameForFormValidation(username);
    	enterPasswordForFormValidation(password);
    	clickFormValidationLogin();
    }
    
    // Method to check if success message is displayed for form validation
    public boolean isFormValidationSuccessMessageDisplayed() {
	    try {
	        return driver.findElement(By.xpath("//p[text()='Form submitted successfully!']")).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
    }
    
    // Select a value from drop down
    public void selectDropDownValue(String valueToSelect) {
    	
    	WebElement dropdown = driver.findElement(dropDownItem);
    	Select select = new Select(dropdown);
    	select.selectByValue(valueToSelect);
    }
    
 // Method to check if success message is displayed for drop down selection
    public boolean isDropDownSelectionSuccessMessageDisplayed(String optionName) {
    	
    	String selectedMessage = "Selected: " + optionName;

	    try {
	    	WebElement selectedTextElement = driver.findElement(By.xpath("//p[contains(text(),'Selected:')]"));
	    	String actualText = selectedTextElement.getText().trim();
	        return actualText.equals(selectedMessage);
	    } catch (Exception e) {
	        return false;
	    }
    }
    
    // Fill up item name in Dynamic list
    public void typeItemForDynamicList(String itemName) {
        driver.findElement(itemNameInput).clear();      // Clear previous value (if any)
        driver.findElement(itemNameInput).sendKeys(itemName);
    }
    
    // Click the Add button for Dynamic List item add
    public void clickAddForDynamicListItem() {
    	WaitUtils.waitUntilClickable(driver, dynamicItemAddButton, 10);
        driver.findElement(dynamicItemAddButton).click();
    }
    
    public boolean isDynamicItemFoundInList(String itemText) {
        try {
            WebElement item = driver.findElement(By.xpath("//li[contains(., '" + itemText + "') and .//button[text()='Remove']]"));
            return item.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void clickRemoveAndConfirmForDynamicItem(String itemText) throws InterruptedException {
        WebElement removeButton = driver.findElement(
            By.xpath("//li[contains(., '" + itemText + "')]//button[text()='Remove']")
        );
        removeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public void clickRemoveAndCancelForDynamicItem(String itemText) {
        WebElement removeButton = driver.findElement(
            By.xpath("//li[contains(., '" + itemText + "')]//button[text()='Remove']")
        );
        removeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    public boolean isItemRemovalConfirmationDisplayed(String itemText) {

        String expectedMessage = "Removed: " + itemText;

        try {
            WebElement removalMessageElement = driver.findElement(
                By.xpath("//span[contains(text(),'Removed:') and .//strong]")
            );

            String actualText = removalMessageElement.getText().trim();
            return actualText.equals(expectedMessage);
        } catch (Exception e) {
            return false;
        }
    }
    
    // Click the Logout button
    public void clickLogoutButton() {
    	WaitUtils.waitUntilClickable(driver, logoutButton, 10);
        driver.findElement(logoutButton).click();
    }
}

