package com.testingGlobal66.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    WebDriver supdriver;

    public SignupPage(WebDriver rdriver){
        supdriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id = "signin-go-signup")
    @CacheLookup
    WebElement lnkSignup;

    @FindBy(name = "email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(name = "clave")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "password_confirmation")
    @CacheLookup
    WebElement txtPasswordCorfirm;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div[4]/div/div/div/div")
    @CacheLookup
    WebElement chbxTC;

    @FindBy(id = "signupBtn")
    @CacheLookup
    WebElement btnSignup;

    @FindBy(xpath = "//*[text()=\"¡Revisa tu Email!\"]")
    @CacheLookup
    WebElement msgSignup;

    @FindBy(xpath = "//*[text()=\"Iniciar sesión\"]")
    @CacheLookup
    WebElement btnReturnSignin;

    public void clickLnkSignup() {
        lnkSignup.click();
    }

    public void setTxtEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setTxtPasswordCorfirm(String passwordCorfirm) {
        txtPasswordCorfirm.sendKeys(passwordCorfirm);
    }

    public void clickChbxTC() {
        chbxTC.click();
    }

    public void clickBtnSignup() {
        btnSignup.click();
    }

    public String getMsgSignup(){
        return msgSignup.getText();
    }

    public void clickBtnReturnSingin(){
        btnReturnSignin.click();
    }
}
