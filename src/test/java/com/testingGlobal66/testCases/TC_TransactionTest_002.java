package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.LoginPage;
import com.testingGlobal66.pageObjects.TransactionPage;
import com.testingGlobal66.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_TransactionTest_002 extends BaseClass{
	
	@Test(dataProvider = "TestDataTransaction")
	public void transactionTest(String email, String password, String originAmount, String accountType, String name, String lastName, String birthDate, String idNumber, String phoneNumber, String personalAddress, String personalCity, String companyName, String tradeName, String companyIdNumber, String companyAddress, String companyCity) throws IOException, InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(email);
		logger.info("Entered email provided");
		lp.setPassword(password);
		logger.info("Entered password provided");
		lp.clickSubmit();		
		Thread.sleep(10000);

		TransactionPage tp = new TransactionPage(driver);
		tp.clickBtnSendMoney();
		Thread.sleep(5000);

		tp.setTxtOriginAmount(originAmount);
		tp.clickBtnContinue1();
		Thread.sleep(5000);

		tp.clickRbtAccountType(accountType);
		Thread.sleep(5000);

//		driver.findElement(By.)
		tp.setTxtName(name);
		logger.info("name provided");
		tp.setTxtLastName(lastName);
		logger.info("lastName provided");
		tp.setTxtBirthDate(birthDate);
		logger.info("birthDate provided");
		tp.setTxtIdNumber(idNumber);
		logger.info("idNumber provided");
		tp.setTxtPhoneNumber(phoneNumber);
		logger.info("phoneNumber provided");

		if (accountType.equals("persona")){
			tp.setTxtPersonalAddress(personalAddress);
			tp.setTxtPersonalCity(personalCity);
		} else if (accountType.equals("empresa")){
			tp.setTxtCompanyName(companyName);
			tp.setTxtTradeName(tradeName);
			tp.setTxtCompanyIdNumber(companyIdNumber);
			tp.setTxtCompanyAddress(companyAddress);
			tp.setTxtCompanyCity(companyCity);

		}
		tp.clickBtnContinue2();
		Thread.sleep(5000);

		tp.clickLinkHome();
		Thread.sleep(3000);

		tp.clickCbxProfile();
		Thread.sleep(3000);

		tp.clickLinkLogout();
		Thread.sleep(10000);



	}

	@DataProvider(name="TestDataTransaction")
	public Object [][] getDataTransaction() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testingGlobal66/testData/testDataTransaction.xlsx";

		int rownum=XLUtils.getRowCount(path, "Hoja 1");
		int colcount=XLUtils.getCellCount(path,"Hoja 1",1);

		Object[][] dataTransaction = new Object[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				dataTransaction[i-1][j]=XLUtils.getCellData(path,"Hoja 1", i,j);//1 0
			}

		}
		return dataTransaction;
	}
}
