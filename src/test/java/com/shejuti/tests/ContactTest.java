package com.shejuti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shejuti.base.BaseTest;
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

	String testingDemoLoginUrl = ConfigReader.get("baseUrl") + "/testingdemologin";
	String testingDemoUrl = ConfigReader.get("baseUrl") + "/testingdemo";
	private By testingDemoHeader = By.xpath("//h2[text()='Testing Demo']");


}
