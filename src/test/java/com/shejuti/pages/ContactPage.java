package com.shejuti.pages; 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.shejuti.utils.WaitUtils;

/**
 * Page Object Model for the Contact Page 
 * This class contains all the locators and actions related to the Contact screen.
 */
public class ContactPage {

    private WebDriver driver; // WebDriver reference to interact with the browser

    // ===== Locators for contact page elements =====
    private By contactNameField = By.id("contactFullName");
    private By contactEmailField = By.id("contactEmail");
    private By contactMessageField = By.id("contactMessage");
    private By contactSendBtn = By.id("contactSend");
    private By contactSendSuccessMsg = By.xpath("//p[contains(text(),'Thanks for reaching out!')]");

    // ===== Constructor to initialize WebDriver =====
    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods =====
    public void enterContactName(String contactName) {
        driver.findElement(contactNameField).clear();      // Clear previous value (if any)
        driver.findElement(contactNameField).sendKeys(contactName);
    }
    
    public void enterContactEmail(String contactEmail) {
        driver.findElement(contactEmailField).clear();      // Clear previous value (if any)
        driver.findElement(contactEmailField).sendKeys(contactEmail);
    }
    
    public void enterContactMessage(String contactMessage) {
        driver.findElement(contactMessageField).clear();      // Clear previous value (if any)
        driver.findElement(contactMessageField).sendKeys(contactMessage);
    }
    
    // Click the Send button
    public void clickSend() {
    	WaitUtils.waitUntilClickable(driver, contactSendBtn, 10);
        driver.findElement(contactSendBtn).click();
    }
    
 // Perform full message send in one step
    public void sendMessage(String contactName, String contactEmail, String contactMessage) {
    	enterContactName(contactName);
    	enterContactEmail(contactEmail);
    	enterContactMessage(contactMessage);
    	clickSend();
    }
    
    // Method to check if success message is displayed for contact
    public boolean isSuccessMessageDisplayed() {
	    try {
	        return driver.findElement(By.xpath("//p[text()='Thanks for reaching out!']")).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
    }


}