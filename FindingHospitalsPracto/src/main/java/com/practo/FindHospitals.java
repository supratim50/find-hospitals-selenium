package com.practo;



import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;



public class FindHospitals extends Base {
	
	public void takeScreenShot(String name) throws Exception {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("target\\" + name + ".png"));
	}
	
	public void location() throws Exception {
	// To find location and select bangalore
		
		test1 = rep1.startTest("Location");
		
		try {
				WebElement city = driver.findElement(PractoPOM.location);
				city.clear();
				readExcelData();
				city.sendKeys(location);
				wait = new WebDriverWait(driver, 15);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(PractoPOM.cityname));
				Thread.sleep(5000);
				driver.findElement(PractoPOM.cityname).click();
				test1.log(LogStatus.PASS, "Location selected");
				System.out.println("Location Bangalore selected successfully");
		}catch(Exception e) {
				System.out.println("Location not selected");
				takeScreenShot("Location Failed");
				test1.log(LogStatus.FAIL, "Location not selected");
		}
	
		// To select Hospital
		try {
				WebElement type = driver.findElement(PractoPOM.hospital);
				type.sendKeys(typebox);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(PractoPOM.hospitalname));
				Thread.sleep(5000);
				driver.findElement(PractoPOM.hospitalname).click();
				//reportPass("Hospital is selected Successfully");
				test1.log(LogStatus.PASS, "Hospital is selected Successfully");
				System.out.println("Hospital selected successfully");
		} catch (Exception e)
		{
				e.printStackTrace();
				System.out.println("Hospital not clicked");
				takeScreenShot("Select Type Failed");
				test1.log(LogStatus.FAIL, "Hospital is selected Successfully");
		}
		
		Thread.sleep(5000);
		}


	//@Test(priority=2)
	public void getHospitalName() throws Exception {
		
		test2 = rep1.startTest("Hospitals");
		
		// CheckBox 24*7
		try {
				WebElement checkBox = driver.findElement(PractoPOM.c24x7);
				checkBox.click();
				Thread.sleep(7000);
				test1.log(LogStatus.PASS, "Checkbox is selected Successfully");
				System.out.println("Checkbox is selected Successfully");
		} catch (InterruptedException e) {
				e.printStackTrace();
				takeScreenShot("24*7 Check Box Not Clicked");
				test1.log(LogStatus.PASS, "24*7 Check Box Not Clicked");
		}

// Clicking on has parking filter
		try {
				WebElement allFilters = driver.findElement(PractoPOM.allfilters);
				allFilters.click();
				Thread.sleep(3000);
				
				
				WebElement hasParking = driver.findElement(PractoPOM.hasparking);
				hasParking.click();
				test2.log(LogStatus.PASS, "Has parking is selected");
				//reportPass("Has parking is selected");
				System.out.println("Has parking is selected");
				Thread.sleep(10000);
		} catch (InterruptedException e) {
				e.printStackTrace();
				takeScreenShot("Parking Filter Not Clicked");
				test2.log(LogStatus.FAIL, "Parking Filter Not Clicked");
		}
		
		// Checking the ratings and display hospital names
		try {
				System.out.println("*************************************************************");
				System.out.println(" Hospital Names with ratings > 3.5 :");
				System.out.println("*************************************************************");
				int totalresults = Integer.parseInt(driver.findElement(PractoPOM.totalhospitals).getText());
				int pages = (totalresults / 10) + 1;
				for (int p = 1; p <= pages; p++) {
					List<WebElement> ratings = driver.findElements(PractoPOM.ratings);
					List<WebElement> hnames = driver.findElements(PractoPOM.hnames);
					for (int i = 0; i < ratings.size(); i++) {
						float rate = Float.parseFloat(ratings.get(i).getText());
						if (rate > 3.5) {
							System.out.println(ratings.get(i).getText() + " - "+ hnames.get(i).getText());
						}
					}
		
					System.out.println();
				}
		
				test2.log(LogStatus.PASS, "All hospital names printed with ratings > 3.5");
		} catch (NumberFormatException e) {
				e.printStackTrace();
				takeScreenShot("Getting Hospital Failed");
				test2.log(LogStatus.FAIL, "Getting Hospital Failed");		
		}
		Thread.sleep(10000);
		}

	
	public void diagnosticsPage() throws Exception {
	
		test3 = rep1.startTest("Cities");
			
		try {
				WebElement diagnostic = driver.findElement(PractoPOM.diagnosticpage);
				diagnostic.click();
				
				//wait.until(ExpectedConditions.visibilityOfElementLocated(PractoPOM.topcities));
				Thread.sleep(7000);
				
				takeScreenShot("Top Cities");
				
				List<WebElement> cities = driver.findElements(PractoPOM.topcities);
				System.out.println("*************************************************************");
				System.out.println("Top Cities");
				System.out.println("*************************************************************");
				for(WebElement c:cities) {
					System.out.println(c.getText());
				}
				test3.log(LogStatus.PASS, "All top cities are obtained successfully");
				System.out.println("All top cities are obtained successfully");
		} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("Top City Name Not Printed");
				test3.log(LogStatus.FAIL, "Top City Name Not Printed");
		}
		
	}
		
		// Navigating Back
		//@Test(priority=4)
	public void back() throws Exception {
		// driver.findElement(By.xpath("/html/body/div[3]/div")).click();
		
		test4 = rep1.startTest("Cities");
		
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	//@Test(priority=5)
	public void clickCorporateWellness() throws Exception {
		try {
				WebElement providers = driver.findElement(PractoPOM.providersdropdown);
				providers.click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(PractoPOM.corporatewellness));
				Thread.sleep(5000);
				WebElement cWellness = driver.findElement(PractoPOM.corporatewellness);
				cWellness.click();
				test4.log(LogStatus.PASS, "Providers dropdown clicked.");
				Thread.sleep(5000);
		} catch (InterruptedException e) {
				e.printStackTrace();
				takeScreenShot("Corporate Wellness Not Click");
				test4.log(LogStatus.FAIL, "Corporate Wellness Not Click");
		}
	}
	
	//@Test(priority=6)
	public void windowHandling() {
		try {
				Set<String> currentHandle = driver.getWindowHandles();
				Iterator<String> itr = currentHandle.iterator();
				itr.next();
				String corporate = itr.next();
				driver.switchTo().window(corporate);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	//@Test(priority=7)
	public void fillDetails() throws Exception {
	
		test5 = rep1.startTest("Submit");
		
		try {
				WebElement nameBox = driver.findElement(PractoPOM.name);
				WebElement organisationBox = driver.findElement(PractoPOM.organisation);
				WebElement emailBox = driver.findElement(PractoPOM.mailbox);
				WebElement phoneBox = driver.findElement(PractoPOM.contactno);
				Select organizationSize = new Select(driver.findElement(PractoPOM.orgsize));
				
				
				
				// Give the valid data
				nameBox.sendKeys(name);
				organisationBox.sendKeys(orgname);
				emailBox.sendKeys(mail);
				phoneBox.sendKeys(phno);
				organizationSize.selectByVisibleText("<=500");
				//scheduleBtn.click();
				submitData();
				test5.log(LogStatus.PASS, "Submitting Data.");
				Thread.sleep(5000);
				//printAlert();
				Thread.sleep(5000);
				takeScreenShot("Scheduled A Demo");
		
		
		} catch (InterruptedException e) {
				e.printStackTrace();
				takeScreenShot("Details Not Filled");
		}
		
	
	}



}