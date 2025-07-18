package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.HomePage;
import com.shejuti.pages.LoginPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.TabUtils;
import com.shejuti.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Contains Test cases on Home screen
 * This class extends the BaseTest class.
 */

public class HomeTest extends BaseTest {

	private By linkedInPage = By.xpath("//h2[text()='Testing Demo']");


	@Test
	public void testLinkedInPagelaunch()
	{
		// Create HomePage object
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkedIn();
        
        TabUtils.switchToNewTabAndVerifyTitle(driver, "Shejuti Khan | LinkedIn", 10);
        
        // Verify correct linkedin page is displayed
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.linkedin.com/in/shejutikhan/");
        
        driver.close(); // close Github tab
        driver.switchTo().window(driver.getWindowHandles().iterator().next()); // return to main tab
	}
	
	@Test
	public void testGithubPagelaunch()
	{
		// Create HomePage object
        HomePage homePage = new HomePage(driver);
        homePage.clickGithub();
        
        TabUtils.switchToNewTabAndVerifyTitle(driver, "shejutik (Shejuti Khan)", 10);
        
        // Verify correct github page is displayed
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://github.com/shejutik");
        
        driver.close(); // close Github tab
        driver.switchTo().window(driver.getWindowHandles().iterator().next()); // return to main tab
	}
}
