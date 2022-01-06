package testSuite;

import org.testng.annotations.Test;

import com.practo.FindHospitals;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import home.Home;

public class Regression {
	public static ExtentReports rep1;
	public static ExtentTest test1;
	
	@Test
	public void regressiontesting() throws Exception {
		
		Home h = new Home();
		h.getURL();
		
		FindHospitals fh = new FindHospitals();
		fh.location();
		fh.getHospitalName();
		fh.diagnosticsPage();
		fh.back();
		fh.clickCorporateWellness();
		fh.windowHandling();
		fh.fillDetails();
		fh.closeBrowser();
	}
	
	
}
