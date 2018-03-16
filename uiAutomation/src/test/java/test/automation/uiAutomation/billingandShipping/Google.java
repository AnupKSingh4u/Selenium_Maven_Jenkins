package test.automation.uiAutomation.billingandShipping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {

	
	public static void main(String[] Args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:/Users/ACER/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.cognizant.com");
	}
}