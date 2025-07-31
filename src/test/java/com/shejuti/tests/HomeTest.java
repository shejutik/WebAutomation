package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
import com.shejuti.pages.HomePage;
import com.shejuti.pages.LoginPage;
import com.shejuti.utils.ConfigReader;
import com.shejuti.utils.TestUtils;
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


	@Test(description = "Verify linkedin page launch")
	public void testLinkedInPagelaunch()
	{
		// Create HomePage object
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLinkedIn();
        
        TestUtils.switchToNewTabAndVerifyTitle(getDriver(), "Shejuti Khan | LinkedIn", 10);
        
        // Verify correct linkedin page is displayed
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.linkedin.com/in/shejutikhan/");
        
        getDriver().close(); // close Github tab
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // return to main tab
	}
	
	@Test(description = "Verify github page launch")
	public void testGithubPagelaunch()
	{
		// Create HomePage object
        HomePage homePage = new HomePage(getDriver());
        homePage.clickGithub();
        
        TestUtils.switchToNewTabAndVerifyTitle(getDriver(), "shejutik (Shejuti Khan)", 10);
        
        // Verify correct github page is displayed
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://github.com/shejutik");
        
        getDriver().close(); // close Github tab
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // return to main tab
	}
}
