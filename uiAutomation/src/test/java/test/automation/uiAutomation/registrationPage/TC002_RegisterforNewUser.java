package test.automation.uiAutomation.registrationPage;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import test.automation.uiAutomation.testBase.TestBase;
import test.automation.uiAutomation.uiActions.HomePage;

public class TC002_RegisterforNewUser extends TestBase{

	HomePage homepage;
	

	

	@DataProvider(name="regdata")
	public String [][] readdata() throws BiffException, IOException{
		String [] [] testrecords= readexcel();
		return testrecords;
	}
	
	@BeforeTest
	public void setUp() {
		init("ie", "www.google.com");
		
	}
	
	
	
	@Test(dataProvider="regdata")
	public void VerifyTheRegistration(String firstname, String lastname, String email, String createpass) throws Exception {
		//log.info("================Starting Test================");
		//driver = new  FirefoxDriver();
		driver.switchTo().frame(driver.findElement(By.id("PreviewFrame")));
		homepage = new HomePage(driver);
		homepage.RegisterForNewUser(firstname, lastname, email, createpass);
		//homepage.registrationMessage();
		TestBase.TakeSnapShots("Register_"+firstname);
		//Assert.assertEquals(true, homepage.registrationMessage());
		driver.switchTo().defaultContent();
		log.info("================Finished Test================");
	}
	
	@AfterTest
    public void endTest() {
		driver.close();
	}
	
	
}
