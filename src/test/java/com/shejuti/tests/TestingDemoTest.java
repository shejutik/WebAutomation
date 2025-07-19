package com.shejuti.tests;

import org.testng.Assert;
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

	@Test
	public void testFileUpload() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		// Open contact page
        driver.get(testingDemoPageUrl); 
        loginPage.login("admin", "123");

        // Create TestingDemoPage object
        TestingDemoPage TestingDemoPage = new TestingDemoPage(driver);
        
        TestingDemoPage.inputFileLocation("D:\\Work\\Testing Portfolio_Local\\client\\src\\assets\\sample text file.txt");
        
        By fileUploadSuccessMsgLocator = By.xpath("//p[contains(text(),'uploaded successfully')]");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadSuccessMsgLocator));
        
        Assert.assertTrue(TestingDemoPage.isFileUploadSuccessMessageDisplayed("sample text file.txt"), "❌ File upload success message not found!");
	}

}
