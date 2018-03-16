package test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class TestBase {

	public static final Logger log= Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	//String url= "http://automationpractice.com/index.php";
	
	
	String email= System.currentTimeMillis()+"@gmail.com";

	
	public void init(String browser, String url) {
		selectBrowser(browser);
		System.out.println(System.getProperty("User.dir"));
		getUrl(url);
		String log4jConfig= "log4j.properties";
		PropertyConfigurator.configure(log4jConfig);
	}

	private void getUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		log.info("Navigating to: "+url);
		//driver.manage().window().maximize();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private void selectBrowser(String browser) {
		// TODO Auto-generated method stub
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/ACER/Downloads/geckodriver.exe");
			log.info("Creating object of: "+browser);
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/ACER/Downloads/chromedriver.exe");
			log.info("Creating object of: "+browser);
			driver= new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:/Users/ACER/Downloads/IEDriverServer.exe");
			log.info("Creating object of: "+browser);
			driver= new InternetExplorerDriver();
		
		}
	}
	
	public static String path = "C:/Users/ACER/Downloads/Screenshots/Screenshot.png";
	
	public static void TakeSnapShots(String name) throws Exception {
		
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String timestamp = formater.format(calendar.getTime());
				
		TakesScreenshot ScrShot = (TakesScreenshot)driver;
		File Source=ScrShot.getScreenshotAs(OutputType.FILE);
		String path1 = "C:/Users/ACER/Downloads/Screenshots/";
		String reportDirectory =new  File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/test/automation/uiAutomation/screenShots/";
		File Destfile = new File((String)reportDirectory + name + "_" + formater.format(calendar.getTime())+".png");
	    File Destination1 = new File(path1 + name + "_" + formater.format(calendar.getTime()) + ".png");
		
		System.out.println("Screenshot captured as: "+Destination1);
		FileUtils.copyFile(Source, Destination1);
		System.out.println("Screenshot captured as: "+Destfile);
		FileUtils.copyFile(Source, Destfile);
		Reporter.log("<a herf='"+Destfile.getAbsolutePath()+"'><img src ='"+Destfile.getAbsolutePath()+"'height='100' width='100'/></a");
		
		
		//Sending Screenshot to TestNG Report as link
		
		Reporter.log("<a herf='"+Destfile.getAbsolutePath()+"'><img src ='"+Destfile.getAbsolutePath()+"'height='100' width ='100'/></a>");
		
	}
	
	
	//Method-1 for reading data from excel-sheet:-
	public String [] [] readexcel ()  throws BiffException, IOException {
		
		File f = new File("D:/Input.xls");
			Workbook w = Workbook.getWorkbook(f);
			Sheet s = w.getSheet("Registration");
			int rows = s.getRows();
			int columns =s.getColumns();
			System.out.println(rows);
			System.out.println(columns);
			String inputdata [] [] = new String [rows] [columns];
			for (int i=1; i<rows; i++) {
				for(int j=0; j<columns; j++) {
					Cell c= s.getCell(j, i);
					inputdata [i-1] [j] = c.getContents();
					System.out.println("Data for row number-" +(i+1)+ " is:  "+inputdata [i-1] [j] );
				
				}
			}
			return inputdata;
			
		}
	
	//Method-2 for reading data from excel sheet:-
	
	

	
	public void	waitForElement(WebElement element, int TimeouinSeconds) {
		
	//	WebElement we = driver.findElement(By.linkText("homepage"));
			WebDriverWait wait = new WebDriverWait(driver, TimeouinSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			Set<String> windows = driver.getWindowHandles();
			}
	
	public void Scandata(){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String url= scan.nextLine();
		driver.get(url);
		
		
	}
	
	

}