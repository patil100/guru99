package Script;

import static Report.AllureReport.SaveTextLog;
import static Report.AllureReport.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Function.Driver;
import io.qameta.allure.*;

public class Portal {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void Driverallocation() {
		driver = Driver.driverAllocation("chrome"); // Fix: Assign WebDriver instance
		if (driver == null) {
			throw new IllegalStateException("WebDriver is null. Check Driver.driverAllocation()");
		}
		wait = new WebDriverWait(driver, 40);
	}

	@Step("Opening URL: {url}")
	public void openurl(String url) {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized. Ensure Driverallocation() is executed correctly.");
		}

		driver.get(url);
		SaveTextLog("Opening URL: " + url);
		Screenshot(driver, "opening url");
	}

	@Test
	public void APortal() {
		driver.get("https://cbuatportal.tourasuae.com/login");

		System.out.println("cross border URL opened ");
		//openurl("https://cbuatportal.tourasuae.com/login");
	}
}
