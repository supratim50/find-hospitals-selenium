package testSuite;

import org.testng.annotations.Test;

import com.practo.Base;

import home.Home;




public class SmokeTest {
	@Test
	public void smoketesting() throws Exception
	{

		Home h = new Home();
		h.getURL();
		

	}
}
