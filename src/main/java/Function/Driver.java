package Function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

	public static WebDriver driverAllocation(String browserName) {
		WebDriver driver = null;

		if (browserName == null || browserName.trim().isEmpty()) {
			System.out.println("Error: Browser name is empty or null.");
			return null;
		}

		String browser = browserName.trim().toLowerCase();

		try {
			if (browser.contains("chrome")) {
				WebDriverManager.chromedriver().setup();

				// Set Chrome Options
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-blink-features=AutomationControlled"); // Avoid detection
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--remote-allow-origins=*"); // Fix for WebSocket error

				driver = new ChromeDriver(options);
				System.out.println("Browser opened in Chrome");

			} else if (browser.contains("firefox")) {
				WebDriverManager.firefoxdriver().setup();

				// Set Firefox Options
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("dom.webdriver.enabled", false);
				options.addPreference("useAutomationExtension", false);

				driver = new FirefoxDriver(options);
				System.out.println("Browser opened in Firefox");

			} else {
				System.out.println("Error: Unsupported browser - " + browserName);
				return null;
			}

			// Maximize window & return driver
			driver.manage().window().maximize();
			return driver;

		} catch (Exception e) {
			System.out.println("Error initializing WebDriver: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
