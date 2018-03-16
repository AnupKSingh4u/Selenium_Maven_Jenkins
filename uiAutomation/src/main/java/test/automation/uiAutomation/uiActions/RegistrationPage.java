package test.automation.uiAutomation.uiActions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/nav/div/div[2]/ul/li[2]/a")
	WebElement Register;
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[1]/div[1]/input")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[1]/div[2]/input")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[2]/div/textarea")
	WebElement Address;
	
	@FindBy(xpath="//*[@id='eid']/input")
	WebElement EmailAddress;
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[4]/div/input")
	WebElement Phone;
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[5]/div/label[1]")
	WebElement Gender_Male;
	
	@FindBy(xpath="//*[@id='checkbox1']")
	WebElement Hobbies_Cricket;
	
	@FindBy(xpath="//*[@id='msdd']")
	WebElement Language;
	
	public void drpLanguage() {
		Select drpLanguage= new Select(Language);
		drpLanguage.selectByValue("Arabic");
	}
	
	@FindBy(xpath="//*[@id='Skills']")
	WebElement Skills;
	
	public void drpSkills() {
		Select drpSkills= new Select(Skills);
		drpSkills.selectByVisibleText("C++");
	}
	@FindBy(xpath="//*[@id='countries']")
	WebElement Country;
	
	public void drpCountry() {
		Select drpCountry= new Select(Country);
		drpCountry.selectByVisibleText("India");
	}
	
	@FindBy(xpath="//*[@id='yearbox']")
	WebElement DOB_Yr;
	
	public void drpDOB_Yr() {
		Select drpDOB_yr= new Select(DOB_Yr);
		drpDOB_yr.selectByVisibleText("1987");
	}
	
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[11]/div[2]/select")
	WebElement DOB_Month;
	
	public void drpDOB_Month() {
		Select drpDOB_Month= new Select(DOB_Month);
		drpDOB_Month.selectByVisibleText("9");
	}
		
	@FindBy(xpath="//*[@id='daybox']")
	WebElement DOB_day;
	public void drpDOB_day() {
		Select drpDOB_day= new Select(DOB_day);
		drpDOB_day.selectByVisibleText("9");
	}

	
	@FindBy(xpath="//*[@id='firstpassword']")
	WebElement Password;
	
	@FindBy(xpath="//*[@id='secondpassword']")
	WebElement Confirm_Password;
	
	@FindBy(xpath="//*[@id='submitbtn']")
	WebElement Submit_Btn;
	
	String Addrs= "BC-98, Kestopur, Kol-102";
	String ph ="9999999999";
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void RegisterUser(String firstname, String lastname, String emailId, String pas1, String pas2) {
		Register.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Address.sendKeys(Addrs);
		EmailAddress.sendKeys(emailId);
		Phone.sendKeys(ph);
		Gender_Male.click();
		Hobbies_Cricket.click();
		RegistrationPage Obj= new RegistrationPage(driver);
		//Obj.drpLanguage();
		//Obj.drpCountry();
		Obj.drpSkills();
		Obj.drpDOB_Yr();
		Obj.drpDOB_Month();
		Obj.drpDOB_day();
		Password.sendKeys(pas1);
		Confirm_Password.sendKeys(pas2);
		Submit_Btn.click();
			
	}
}
