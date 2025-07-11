package com.shejuti.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.shejuti.utils.ConfigReader;

import org.testng.annotations.AfterMethod;
import java.time.Duration;  // For setting implicit wait timeout

/**
 * BaseTest is an abstract class that contains setup and teardown logic
 * for Selenium WebDriver. All test classes should extend this class.
 */

public abstract class BaseTest {

    protected WebDriver driver; // WebDriver object that will be shared with all test classes

    /**
     * This method runs before each @Test method.
     * It initializes the ChromeDriver and opens the browser.
     */
    @BeforeMethod
    public void setUp() {
        // Optional: Set the path to your ChromeDriver manually (uncomment and update if needed)
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver(); // Launches a new Chrome browser instance
        driver.manage().window().maximize(); // Maximizes the browser window

        // Sets a global implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Loads your locally hosted testing website (React frontend)
        driver.get(ConfigReader.get("baseUrl"));
    }

    /**
     * This method runs after each @Test method.
     * It closes the browser and cleans up the driver instance.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Properly closes the browser and ends the session
        }
    }
}