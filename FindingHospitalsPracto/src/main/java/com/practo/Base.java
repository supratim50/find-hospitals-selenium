package com.practo;



import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Base {



	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	String location;
	String typebox;
	String name;
	String orgname;
	String mail;
	String phno;
	public static ExtentReports rep1;
	public static ExtentTest test1, test2, test3, test4, test5;
	
	@BeforeSuite
	public void reportAnalysis()
	{
		System.out.println("Report Initialized");
		rep1 = new ExtentReports(System.getProperty("user.dir") + "./Report/ExtentReport.html");
		test1 = rep1.startTest("Browser");
		test2 = rep1.startTest("DataDriven");
	}
	
	@BeforeTest
	/***********************READING DATA FROM 'config.properties'*****************************/
	public void readConfigProperties() throws Exception
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		test2.log(LogStatus.PASS, "Browser name is successfully taken from the configuration property.");
		invokeBrowser(browser);
	}
	
	/***********************INVOKING THE BROWSERS*****************************/
	public void invokeBrowser(String browser) throws IOException, InterruptedException, AWTException
	{
		switch(browser)
		{
			case "FireFox":
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				test1.log(LogStatus.PASS, "Successfully opening the browser.");
				break;
			
			case "Edge":
				System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
				test1.log(LogStatus.PASS, "Successfully opening the browser.");
				break;
			
			case "Chrome" :
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				test1.log(LogStatus.PASS, "Successfully opening the browser.");
				break;
		
		}
	}
	
	
	/***********************READING INPUT FROM EXCEL FILE*****************************/
	public void readExcelData() throws IOException, InterruptedException, AWTException
	{
		DataFormatter formatter = new DataFormatter();
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Practo_poi.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet("Inputs");
		
		location =sh.getRow(0).getCell(0).getStringCellValue();
		
		typebox = sh.getRow(0).getCell(1).getStringCellValue();
		name = sh.getRow(0).getCell(2).getStringCellValue();
		orgname = sh.getRow(0).getCell(3).getStringCellValue();
		mail = sh.getRow(0).getCell(4).getStringCellValue();
		phno = formatter.formatCellValue(sh.getRow(0).getCell(5));
		
		test2.log(LogStatus.PASS, "Data is driven successfully from the excel sheet through apache POI concept.");
		wb.close();
	}
	
	
	
	// To submit Data in Corporate Wellness Page
	public void submitData() throws InterruptedException {
		WebElement submit = driver.findElement(PractoPOM.submitbutton);
		submit.click();
	}
	
	// To close the Browser
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() {
		rep1.flush();
	}


}