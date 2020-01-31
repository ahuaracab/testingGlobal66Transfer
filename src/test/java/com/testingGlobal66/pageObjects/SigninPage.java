package com.testingGlobal66.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	WebDriver ldriver;
	
	public SigninPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "signin-email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id = "signin-password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id = "signin-submit")
	@CacheLookup
	WebElement btnSignin;
	
//	@FindBy(xpath = "//*[text()=\"Cerrar sesión \"]")
//	@CacheLookup
//	WebElement lnkSignout;
	
	public void setTxtEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTxtPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickBtnSignin() {
		btnSignin.click();
	}

//	public void clickLnkSignout() {
//		lnkSignout.click();
//	}
	
}
