package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.ContactPage;
import com.shejuti.pages.LoginPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.TestData;
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


	@Test(dataProvider = "contactData", dataProviderClass = TestData.class) // using dataProvider for multiple tests
    public void testContactMessageSend(String contactName, String contactEmail, String contactMsg) {
        // Open contact page
		getDriver().get(contactPageUrl); 

        // Create ContactPage object
        ContactPage contactPage = new ContactPage(getDriver());

        // Perform login with valid credentials
        contactPage.sendMessage(contactName, contactEmail, contactMsg);
        Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "❌ Success message not found!");
    }
	
}
