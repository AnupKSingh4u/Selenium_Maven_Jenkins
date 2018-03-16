package test.automation.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	public static final Logger log= Logger.getLogger(HomePage.class.getName());
	static WebDriver driver;
	
	//Home Page for Automationpractices.com=====================================================================================
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignInLnk;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement UserName;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement SignInBtn;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement AuthenticationMsg;
	
	public HomePage(WebDriver driver) {
		HomePage.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void Login(String username, String password) {
		
		SignInLnk.click();
		log.info("Clicked on SignIn Link and object is: "+SignInLnk.toString());		
		
		UserName.sendKeys(username);
		log.info("Entered '" +username+  "' in username and object is: "+UserName.toString());
		
		Password.sendKeys(password);
		log.info("Entered '"+password+  "' in password and object is: "+Password.toString());
		
		SignInBtn.click();
		log.info("Clicked on SignIn button and object is: "+SignInBtn.toString());	
	}
	
	public String getInvalidLoginMsg() {
		log.info("Authentication message is: "+AuthenticationMsg.getText());
		return AuthenticationMsg.getText();
	}
	
		//Registration Page for https://themes.shopify.com/themes/simple/styles/light/preview=======================================
	
	@FindBy(id="customer_register_link") WebElement SignUpLnk;
	
	@FindBy(id="FirstName")	WebElement FirstName;
	
	@FindBy(id="LastName")	WebElement LastName;
	
	@FindBy(id="Email")	WebElement Email;
	
	@FindBy(id="CreatePassword") WebElement CreatePassword;
	
	@FindBy(xpath= ".//*[@id='create_customer']/p/input")	WebElement CreateBtn;
	
	
	
	//@FindBy(id="PreviewFrame")
	//	WebElement frame1;
			
	
	
	public void RegisterForNewUser(String firstname, String lastname, String email, String createpass) {
		//driver= new FirefoxDriver(); 
		
		//driver.switchTo().frame(driver.findElement(By.id("PreviewFrame")));
		
		waitForElement(SignUpLnk, 10);
		SignUpLnk.click();
		log.info("Clicked on SignUp link and object is: "+SignUpLnk.toString());
		
		FirstName.sendKeys(firstname);
		log.info("Entered first name and object is: "+FirstName.toString());
		
		LastName.sendKeys(lastname);
		log.info("Entered last name and object is: "+LastName.toString());
		
		Email.sendKeys(email);
		log.info("Entered email and object is: "+Email.toString());
		
		CreatePassword.sendKeys(createpass);
		log.info("Entered password and object is: "+CreatePassword.toString());
		
		CreateBtn.click();
		log.info("Clicked on Create button and object is: "+CreateBtn.toString());
		
	}
	
	public boolean registrationMessage() {
		
		 try {
			driver.findElement(By.xpath("//*[@id='MainContent']/div/p")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		 public void ClickOnLogout() {
			 
		 }
		 
		 public String AssociatedIdmsg() {
			 
			String msg= driver.findElement(By.xpath(".//*[@id='create_customer']/div/ul/li")).getText();
			return msg;
		 }
	
	}
	

