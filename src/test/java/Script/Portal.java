package Script;

import static Report.AllureReport.SaveTextLog;
import static Report.AllureReport.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Function.Driver;
import io.qameta.allure.*;
import Read_Write_File.ReadFromCSV;
import Report.AllureReport;
public class Portal {

	
	WebDriver driver;
	 static WebDriverWait wait;
	
	 @BeforeTest
	public void Driverallocation() {
		Driver.driverAllocation("chrome");
		
		  wait = new WebDriverWait(driver, 40);	
	 }
	
	@Step
	public void openurl(String url) {
		String URL=url;
		driver.get(URL);
		SaveTextLog("Opening URL: " + URL); 
		Screenshot(driver,"opening url");
		
	}
	
	@Test
	public void APortal() {
		
	}
	

}