package Script;

import static Report.AllureReport.SaveTextLog;
import static Report.AllureReport.Screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Function.Driver;
import io.qameta.allure.*;

public class Portal {

	WebDriver driver;
	WebDriverWait wait;

	@Parameters("browser")
	@BeforeTest
	public void Driverallocation(@Optional("chrome") String browser) {
		driver = Driver.driverAllocation(browser);
		if (driver == null) {
			throw new IllegalStateException("WebDriver is null. Check Driver.driverAllocation().");
		}
		wait = new WebDriverWait(driver, 40);
	}

	@Step("Opening URL: {url}")
	public void openurl(String url) {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized.");
		}

		driver.get(url);
		SaveTextLog("Opening URL: " + url);
		Screenshot(driver, "Opening URL");
	}

	@Test
	public void APortal() {
		String portalUrl = "https://cbuatportal.tourasuae.com/login";
		System.out.println("Opening Portal URL: " + portalUrl);
		openurl(portalUrl);
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed successfully");
		}
	}
}
