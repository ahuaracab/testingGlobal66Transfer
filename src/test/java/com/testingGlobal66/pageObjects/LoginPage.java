package com.testingGlobal66.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
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
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[text()=\"Cerrar sesión \"]")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
}
