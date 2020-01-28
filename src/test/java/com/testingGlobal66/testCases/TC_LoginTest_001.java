package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(email);
		logger.info("Entered email");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(10000);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("https://transfer-test.global66.com/dashboard")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");

		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");

		}
	}
}
