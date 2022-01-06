package home;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.practo.Base;

public class Home extends Base {
	
	
	public void getURL() throws Exception
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String URL = prop.getProperty("baseURL");
		
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(7000);
	}
}
