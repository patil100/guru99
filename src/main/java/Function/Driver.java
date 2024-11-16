package Function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Driver {

	
	
	
	public static WebDriver driverAllocation (String browserName) {
		
		if(browserName.trim().toLowerCase().contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("browser open in chrome ");
			return driver;
		}else if(browserName.trim().toLowerCase().contains("firefox")){
		
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("browser open in firefox ");
			return driver;
		} else {
			System.out.println("Error--- browser not open");
		}
		
		
		return null;
		
	}
}
