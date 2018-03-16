package test.automation.uiAutomation.testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public ThreadLocal<RemoteWebDriver> dr= new ThreadLocal<RemoteWebDriver>();
	
	@Parameters("myBrowser")
	
	public void beforeClass(@Optional("chrome") String myBrowser ) throws MalformedURLException {
		RemoteWebDriver driver= null;
		
		if(myBrowser.equals("chrome")) {
			
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WIN10);
			driver= new RemoteWebDriver(new URL("http://192.168.43.68:5001/wd/hub"), capability);
		}
		
		else {
			System.err.println("Something wrong with BaseClass");
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public RemoteWebDriver getDriver() {
		return dr.get();
	}
	
	@AfterClass()
	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}
	
}
