package com.inetbanking.testCase;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseTest {

	
	@Test
	public void loginTest() throws IOException {
		logger.info("URL is opened");
		//Reporting.extentlog.log(Status.PASS, "The Url get opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("enter username");
		lp.setPassword(password);
		logger.info("enter password");
		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePage111")) {
			Assert.assertTrue(true);
			System.out.println("the title of the page is matched  ---Passed");
			logger.info("login test passed...");
			logger.info("I am happy");
			
		} else {
			Assert.assertTrue(false);
			System.out.println("the title of the page is not matched ---failed");
			logger.info("login test failed...");
			
		}

	}

}
