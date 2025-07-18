package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.ContactPage;
import com.shejuti.pages.LoginPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Contains Test cases on Contact screen
 * This class extends the BaseTest class.
 */

public class ContactTest extends BaseTest {

	String contactPageUrl = ConfigReader.get("baseUrl") + "/contact";


	@Test
    public void testContactMessageSend() {
        // Open contact page
        driver.get(contactPageUrl); 

        // Create ContactPage object
        ContactPage contactPage = new ContactPage(driver);

        // Perform login with valid credentials
        contactPage.sendMessage("Daniel Lewis", "shejutikhan+1@gmail.com", "This is a test contact message");
        Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "❌ Success message not found!");
    }
	
}
