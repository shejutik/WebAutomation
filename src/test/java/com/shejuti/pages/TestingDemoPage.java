package com.shejuti.pages; 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    

    // ===== Constructor to initialize WebDriver =====
    public TestingDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods =====
    
 // Click the Choose File option
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
    
}