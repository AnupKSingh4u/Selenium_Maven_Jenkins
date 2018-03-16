package test.automation.uiAutomation.homepage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import test.automation.uiAutomation.testBase.TestBase;
import test.automation.uiAutomation.uiActions.HomePage;

public class TC001_VerifyWithInvalidCredentials extends TestBase {
	HomePage homepage;
	public static final Logger log= Logger.getLogger(TC001_VerifyWithInvalidCredentials.class.getName());
	
	
	
	@Test(priority=1)
	public void setUp() {
		init("chrome","http://automationpractice.com/index.php");
	}
	
	@Test(priority=2)
	public void VerifyWithInvalidCredentials() throws Exception {
		
		log.info("================Starting Test================");
		homepage= new HomePage(driver);
homepage.RegisterForNewUser("Anup", "Singh", "anupahinaura@gmail.com", "pass@1233");

TestBase.TakeSnapShots("VerifyWithInvalidCredentials");
		Assert.assertEquals(homepage.getInvalidLoginMsg(), "Authentication failed.");
		log.info("================Finished Test================");
	}
	
	@Test(priority=3)
    public void endTest() {
		driver.close();
	}
	
}
