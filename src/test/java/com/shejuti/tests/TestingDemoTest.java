package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.ContactPage;
import com.shejuti.pages.LoginPage;
import com.shejuti.pages.TestingDemoPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Contains Test cases on Testing Demo screen
 * This class extends the BaseTest class.
 */

public class TestingDemoTest extends BaseTest {

	String testingDemoPageUrl = ConfigReader.get("baseUrl") + "/testingdemo";
	
	@Test(description = "Verify File Upload")
	@Parameters({"username", "password"})
	public void testFileUpload(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);

        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        TestingDemoPage.inputFileLocation("D:\\Work\\Testing Portfolio_Local\\client\\src\\assets\\sample text file.txt");
        
        By fileUploadSuccessMsgLocator = By.xpath("//p[contains(text(),'uploaded successfully')]");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadSuccessMsgLocator));
        
        Assert.assertTrue(TestingDemoPage.isFileUploadSuccessMessageDisplayed("sample text file.txt"), "❌ File upload success message not found!");
	}
	
	@Test(description = "Verify Form Validation")
	@Parameters({"username", "password"})
	public void testFormValidation(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);

        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        TestingDemoPage.performFormValidation("admin", "123");
        Assert.assertTrue(TestingDemoPage.isFormValidationSuccessMessageDisplayed(), "❌ Form validation Success message not found!");
        
       	}
	
	@Test(description = "Verify Drop Down Selection")
	@Parameters({"username", "password"})
	public void testDropDownSelection(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);
       
        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(
    	    By.cssSelector("div.dropdown-section select")));
    	
        TestingDemoPage.selectDropDownValue("QA");
        Assert.assertTrue(TestingDemoPage.isDropDownSelectionSuccessMessageDisplayed("QA"), "❌ Drop Down selection Success message not found!");
        
       	}
	
	@Test(description = "Verify Dynamic Item Add")
	@Parameters({"username", "password"})
	public void testDynamicItemAdd(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);
       
        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
    	
        TestingDemoPage.typeItemForDynamicList("Item 4");
        TestingDemoPage.clickAddForDynamicListItem();
        Assert.assertTrue(TestingDemoPage.isDynamicItemFoundInList("Item 4"), "❌ Dynamic item was not added!");
        
       	}
	
	@Test(description = "Verify Dynamic Item Remove")
	@Parameters({"username", "password"})
	public void testDynamicItemRemove(String username, String password) throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);
       
        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//li[contains(., 'Item 1') and .//button[text()='Remove']]")));
    	
        TestingDemoPage.clickRemoveAndConfirmForDynamicItem("Item 1");
        
        Assert.assertTrue(TestingDemoPage.isItemRemovalConfirmationDisplayed("Item 1"), "❌ Dynamic item was not removed!");
        
       	}
	
	@Test(description = "Verify Logout from Testing Demo page")
	@Parameters({"username", "password"})
	public void testLogout(String username, String password){
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open testing demo page
        driver.get(testingDemoPageUrl); 
        loginPage.login(username, password);
       
        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        TestingDemoPage.clickLogoutButton();
        
        Assert.assertTrue(TestingDemoPage.isUsernameInputVisible(), "❌ Username input field is not visible!");

        Assert.assertTrue(TestingDemoPage.isPasswordInputVisible(), "❌ Password input field is not visible!");
       	}

}
