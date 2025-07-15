package com.shejuti.pages; 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import com.shejuti.utils.WaitUtils;

/**
 * Page Object Model for the Home Page 
 * This class contains all the locators and actions related to the Home screen.
 */
public class HomePage {

    private WebDriver driver; // WebDriver reference to interact with the browser

    // ===== Locators for home page elements =====
    private By linkedInLink = By.cssSelector("a[href='https://www.linkedin.com/in/shejutikhan']");
    private By githubLink = By.cssSelector("a[href='https://github.com/shejutik']");
    private By emailLink = By.cssSelector("a[href='mailto:shejutikhan@gmail.com']");
    private By downloadResumeLink = By.cssSelector("a[href='http://localhost:3000/Resume.pdf']");

    // ===== Constructor to initialize WebDriver =====
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods =====

 // Click the linkedIn button
    public void clickLinkedIn() {
    	WaitUtils.waitUntilClickable(driver, linkedInLink, 10);
        driver.findElement(linkedInLink).click();
    }
    
 // Click the github button
    public void clickGithub() {
    	WaitUtils.waitUntilClickable(driver, githubLink, 10);
        driver.findElement(githubLink).click();
    }
    
 // Click the email button
    public void clickEmail() {
    	WaitUtils.waitUntilClickable(driver, emailLink, 10);
        driver.findElement(emailLink).click();
    }
    
 // Click the download resume button
    public void clickDownloadResume() {
    	WaitUtils.waitUntilClickable(driver, downloadResumeLink, 10);
        driver.findElement(downloadResumeLink).click();
    }

}
