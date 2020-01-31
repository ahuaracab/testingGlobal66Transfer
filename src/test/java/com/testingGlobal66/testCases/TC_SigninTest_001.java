package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_SigninTest_001 extends BaseClass{
	
	@Test
	public void signinTest() throws IOException, InterruptedException {
		
		logger.info("URL is opened");
		
		SigninPage sip = new SigninPage(driver);
		sip.setTxtEmail(email);
		logger.info("Entered email");
		sip.setTxtPassword(password);
		logger.info("Entered password");
		sip.clickBtnSignin();
		Thread.sleep(10000);
//		System.out.println(driver.getCurrentUrl());
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
