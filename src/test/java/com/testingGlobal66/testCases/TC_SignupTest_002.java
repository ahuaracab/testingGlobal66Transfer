package com.testingGlobal66.testCases;

import com.testingGlobal66.pageObjects.SignupPage;
import com.testingGlobal66.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TC_SignupTest_002 extends BaseClass {


    @Test(dataProvider = "SignupTestData")
    public void signupTest(String email) throws InterruptedException {

        System.out.println(email);
        String password = "ghlrd2j2.";
        String passwordConfirm = "ghlrd2j2.";

        logger.info("URL abierta");
        SignupPage sup = new SignupPage(driver);
        sup.clickLnkSignup();
        logger.info("Abriendo página de registro");
        Thread.sleep(5000);

        sup.setTxtEmail(email);
        logger.info("se ingresó email");
        sup.setTxtPassword(password);
//        Thread.sleep(3000);
        logger.info("se ingresó password");
        Thread.sleep(3000);
        sup.setTxtPasswordCorfirm(passwordConfirm);
//        Thread.sleep(3000);
        logger.info("se ingresó confirmación de password");
        Thread.sleep(3000);
        sup.clickChbxTC();
        Thread.sleep(3000);
        logger.info("se aceptó TyC");
        sup.clickBtnSignup();
        Thread.sleep(10000);
        logger.info("se confirmó registro");
        String message = sup.getMsgSignup();
        System.out.println(message);

        if (message.equals("¡Revisa tu Email!")){
            System.out.println(message.equals("¡Revisa tu Email!"));
            sup.clickBtnReturnSingin();
            Assert.assertTrue(true);
            logger.info("Prueba exitosa");
        } else {
            Assert.assertTrue(false);
            logger.error("Prueba fallida");
        }
    }

    @DataProvider(name="SignupTestData")
    public Object[] getSignupTestData() throws IOException {
        {
            ArrayList<String> emails = emailGenerator(5);
            System.out.println(emails);
            Object[] emailsObject = (Object[]) emails.toArray();
            for (int i=0;i<5;i++){
                System.out.println(emailsObject[i]);
            }
            return emailsObject;
        }
    }

}
