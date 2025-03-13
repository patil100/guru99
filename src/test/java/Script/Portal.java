package Script;

import static Report.AllureReport.SaveTextLog;
import static Report.AllureReport.Screenshot;

import Read_Write_File.ReadFromCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Function.Driver;
import io.qameta.allure.*;

import java.io.IOException;

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

	@Step("login ")
	public void login(String username,String password){
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name=\"comfirm_password\"]")).sendKeys(password);

	}

	@Test
	public void APortal() throws Exception {
		String Path = System.getProperty("user.dir") + "//Merchant_Credentails.csv";
		ReadFromCSV csv1 = new ReadFromCSV(Path);
		String [] credentials = csv1.ReadLineNumber(1);
		openurl(credentials[0]);
		login(credentials[1], credentials[2]);
	}

	@Test
	public void Aortal() throws Exception {
		String Path = System.getProperty("user.dir") + "//Merchant_Credentails.csv";
		ReadFromCSV csv1 = new ReadFromCSV(Path);
		String [] credentials = csv1.ReadLineNumber(1);
		openurl(credentials[0]);
		login(credentials[1], credentials[2]);
	}

	//@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed successfully");
		}
	}
}
