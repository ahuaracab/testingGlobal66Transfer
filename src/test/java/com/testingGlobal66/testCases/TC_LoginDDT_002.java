package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.LoginPage;
import com.testingGlobal66.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{
	
//	@Test(dataProvider = "LoginData")
	@Test
//	public void loginDDT(String email, String password) throws IOException, InterruptedException {
	public void loginDDT() throws IOException, InterruptedException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(email);
		logger.info("Entered email provided");
		lp.setPassword(password);
		logger.info("Entered password provided");
		lp.clickSubmit();		
		Thread.sleep(10000);

		System.out.println(isAlertPresent());

//		if (isAlertPresent()) {
//
//
////			driver.switchTo().alert().accept();
////			driver.switchTo().defaultContent();
////			logger.warn("Login failed");
			Assert.assertTrue(false);
//
//		} else {
//
//			lp.clickLogout();
//			Thread.sleep(3000);
//
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//			logger.info("Login passed");
//			Assert.assertTrue(true);
//
//		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ae) {
			return false;
		}
	}
	
//	@DataProvider(name="LoginData")
//	String [][] getData() throws IOException{
//		String path= System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
//
//		int rownum = XLUtils.getRowCount(path, "Sheet1");
//		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
//
//		String logindata[][] = new String [rownum][colcount];
//
//		for (int i = 1; i <= rownum; i++) {
//			for (int j = 0; j < colcount; j++) {
//				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
//			}
//		}
//
//		return logindata;
//
//	}
}
