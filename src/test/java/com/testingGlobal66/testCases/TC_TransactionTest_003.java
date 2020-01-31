package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.SigninPage;
import com.testingGlobal66.pageObjects.TransactionPage;
import com.testingGlobal66.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_TransactionTest_003 extends BaseClass{


	@Test(dataProvider = "TransactionTestData")
	public void transactionTest(String email, String password, String originAmount, String accountType, String name, String lastName, String birthDate, String idNumber, String phoneNumber, String personalAddress, String personalCity, String companyName, String tradeName, String companyIdNumber, String companyAddress, String companyCity) throws IOException, InterruptedException {
		logger.info("URL abierta");
		SigninPage sip = new SigninPage(driver);
		sip.setTxtEmail(email);
		logger.info("email listo");
		sip.setTxtPassword(password);
		logger.info("password lista");
		sip.clickBtnSignin();
		Thread.sleep(10000);

		TransactionPage tp = new TransactionPage(driver);
		tp.clickBtnSendMoney();
		Thread.sleep(5000);
		logger.info("cotizador abierto");
		tp.setTxtOriginAmount(originAmount);
		logger.info("monto de origen listo");
		tp.clickBtnContinue1();
		Thread.sleep(5000);
		logger.info("datos personales abierto");
		tp.clickRbtAccountType(accountType);
		Thread.sleep(5000);
		logger.info("tipo de cuenta seleccionado");
//		String js = "arguments[0].setAttribute('value','"+name+"')";
//		((JavascriptExecutor) driver).executeScript(js, driver.findElement(By.name("nombre")));
		tp.setTxtName(name);
		logger.info("nombre listo");
		tp.setTxtLastName(lastName);
		logger.info("apellido listo");
		tp.setTxtBirthDate(birthDate);
		logger.info("fecha de nacimiento lista");
		tp.setTxtIdNumber(idNumber);
		logger.info("dni listo");
		tp.setTxtPhoneNumber(phoneNumber);
		logger.info("telefono listo");

		if (accountType.equals("persona")){
			tp.setTxtPersonalAddress(personalAddress);
			logger.info("direccion lista");
			tp.setTxtPersonalCity(personalCity);
			logger.info("ciudad lista");
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

	@DataProvider(name="TransactionTestData")
	public Object [][] getDataTransaction() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testingGlobal66/testData/transactionTestData.xlsx";

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
