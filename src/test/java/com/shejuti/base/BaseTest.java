package com.shejuti.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.shejuti.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import java.time.Duration;  // For setting implicit wait timeout

/**
 * BaseTest is an abstract class that contains setup and teardown logic
 * for Selenium WebDriver. All test classes should extend this class.
 */

public abstract class BaseTest {

	// Thread-local WebDriver for parallel tests
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }
    //protected WebDriver driver; // WebDriver object that will be shared with all test classes

    /**
     * This method runs before each @Test method.
     * It initializes the browser driver and opens the browser.
     */
    @Parameters("browser")
    @BeforeMethod
    public void setUpDriver(@Optional("chrome") String browser) {
        // Optional: Set the path to the ChromeDriver manually (uncomment and update if needed)
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

    	 WebDriver driver;
	    	switch (browser.toLowerCase()) {
	        case "chrome":
	        	WebDriverManager.chromedriver().setup();
	            //driver = new ChromeDriver();
	        	ChromeOptions options = new ChromeOptions();

	            // Run headless when in CI/prod
	            String env = System.getProperty("env", "local");
	            if ("prod".equalsIgnoreCase(env) || "ci".equalsIgnoreCase(env)) {
	                options.addArguments(
	                        "--headless=new",
	                        "--no-sandbox",
	                        "--disable-dev-shm-usage",
	                        "--window-size=1920,1080"
	                );
	            }

	            driver = new ChromeDriver(options);
	            break;
	        case "firefox":
	        	WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	        	System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	        	driver = new EdgeDriver();
	            break;
	        default:
	            throw new IllegalArgumentException("Browser not supported: " + browser);
	    }
	    	System.out.println("✅ Launching browser: " + browser + " on thread: " + Thread.currentThread().getId());
        driver.manage().window().maximize(); // Maximizes the browser window

        // Sets a global implicit wait of 10 seconds for all findElement and findElements calls before throwing a NoSuchElementException
        // Not using implicit wait as using explicit wait where needed from WaitUtils.java class
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Loads the locally/remotely hosted testing website (React frontend)
        driver.get(ConfigReader.get("baseUrl"));
        
        // Store driver in ThreadLocal
        driverThreadLocal.set(driver);
    }

    /**
     * This method runs after each @Test method.
     * It closes the browser and cleans up the driver instance.
     */
    @AfterMethod
    public void tearDown() {
    	getDriver().quit();
        driverThreadLocal.remove();
    }
}