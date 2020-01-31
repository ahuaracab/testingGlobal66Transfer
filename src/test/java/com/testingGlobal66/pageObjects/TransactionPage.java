package com.testingGlobal66.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {

    WebDriver ldriver;

    public TransactionPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //  Link a cotizador
    @FindBy(xpath = "//*[text()=\"Enviar dinero\"]")
    @CacheLookup
    WebElement btnSendMoney;

    //  Para cálculos del cotizador
    @FindBy(name = "origin")
    @CacheLookup
    WebElement txtOriginAmount;

    @FindBy(name = "destiny")
    @CacheLookup
    WebElement txtDestinyAmount;

    //  Terminar paso 1

    @FindBy(xpath = "//*[text()=\"CONTINUAR\"]")
    @CacheLookup
    WebElement btnContinue1;

    //  Tipo de cuenta
    @FindBy(xpath = "//label[text()=\"Persona\"]")
    @CacheLookup
    WebElement rbtPersonal;

    @FindBy(xpath = "//label[text()=\"Empresa\"]")
    @CacheLookup
    WebElement rbtCompany;

    //  Común en tipo de cuenta persona o empresa
    @FindBy(name = "nombre")
    @CacheLookup
    WebElement txtName;

    @FindBy(name = "apellido")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(name = "nationality")
    @CacheLookup
    WebElement cbxNationality;

    @FindBy(xpath = "//label[text()=\"Fecha de nacimiento\"]")
    @CacheLookup
    WebElement txtBirthDate;

    @FindBy(name = "country")
    @CacheLookup
    WebElement cbxCountry;

    @FindBy(name = "idType")
    @CacheLookup
    WebElement rbtIdType;

    @FindBy(name = "idNumber")
    @CacheLookup
    WebElement txtIdNumber;

    @FindBy(name = "phoneCode")
    @CacheLookup
    WebElement rbtPhoneCode;

    @FindBy(name ="phoneNumber")
    @CacheLookup
    WebElement txtPhoneNumber;

    @FindBy(name = "sex")
    @CacheLookup
    WebElement cbxSex;

    //  Solo para cuenta tipo persona

    @FindBy(id = "personalAddress")
    @CacheLookup
    WebElement txtPersonalAddress;

    @FindBy(id = "city")
    @CacheLookup
    WebElement txtPersonalCity;

    @FindBy(name = "profession")
    @CacheLookup
    WebElement cbxProfession;

    //  Solo para cuenta tipo Empresa

    @FindBy(name = "companyName")
    @CacheLookup
    WebElement txtCompanyName;

    @FindBy(name = "tradeName")
    @CacheLookup
    WebElement txtTradeName;

    @FindBy(name = "companyIdNumber")
    @CacheLookup
    WebElement txtCompanyIdNumber;

    @FindBy(name = "rubro")
    @CacheLookup
    WebElement cbxItem;

    @FindBy(name = "companyCountry")
    @CacheLookup
    WebElement cbxCompanyCountry;

    @FindBy(name = "companyAddress")
    @CacheLookup
    WebElement txtCompanyAddress;

    @FindBy(name = "companyCity")
    @CacheLookup
    WebElement txtCompanyCity;

    @FindBy(name = "complianceFile")
    @CacheLookup
    WebElement updComplianceFile;

    //  Terminar paso 2

    @FindBy(xpath = "//*[text()=\"Continuar\"]")
    @CacheLookup
    WebElement btnContinue2;

    @FindBy(linkText = " Inicio ")
    @CacheLookup
    WebElement linkHome;

    @FindBy(className = "item profile hide-mobile")
    @CacheLookup
    WebElement cbxProfile;

    @FindBy(linkText = "Cerrar sesión ")
    @CacheLookup
    WebElement linkLogout;

    //Funciones para transacción

    public void clickBtnSendMoney() {
        btnSendMoney.click();
    }

    public void setTxtOriginAmount(String originAmount) {
        txtOriginAmount.sendKeys(originAmount);
    }
    public void setTxtDestinyAmount(String destinyAmount) {
        txtOriginAmount.sendKeys(destinyAmount);
    }

    public void clickBtnContinue1() {
        btnContinue1.click();
    }


    public void clickRbtAccountType(String accountType ) {
        if (accountType.equals("empresa")){
            rbtCompany.click();
        }
    }
    public void setTxtName(String name) {
        txtName.sendKeys(name);
    }
    public void setTxtLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }
//    public void setCbxNationality(String nationality) {
//        cbxNationality.sendKeys(nationality);
//    }
    public void setTxtBirthDate(String birthDate){
        txtBirthDate.sendKeys(birthDate);
    }
//    public void setCbxCountry(String country) {
//        cbxCountry.sendKeys(country);
//    }
//    public void setRbtIdType(String idType) {
//        cbxCountry.sendKeys(idType);
//    }
    public void setTxtIdNumber(String idNumber) {
        txtIdNumber.sendKeys(idNumber);
    }
    public void setTxtPhoneNumber(String phoneNumber) {
        txtPhoneNumber.sendKeys(phoneNumber);
    }
//    public void setCbxGender(String sex) {
//        cbxSex.sendKeys(sex);
//    }

    public void setTxtPersonalAddress(String personalAddress) {
        txtPersonalAddress.sendKeys(personalAddress);
    }
    public void setTxtPersonalCity(String personalCity) {
        txtPersonalCity.sendKeys(personalCity);
    }
//    public void setCbxProfession(String profession) {
//        cbxProfession.sendKeys(profession);
//    }

    public void setTxtCompanyName(String companyName) {
        txtCompanyName.sendKeys(companyName);
    }
    public void setTxtTradeName(String tradeName) {
        txtTradeName.sendKeys(tradeName);
    }
    public void setTxtCompanyIdNumber(String companyIdNumber) {
        txtCompanyIdNumber.sendKeys(companyIdNumber);
    }
//    public void CbxTxtItem(String item) {
//        cbxItem.sendKeys(item);
//    }
//    public void setCbxCompanyCountry(String companyCountry) {
//        cbxCompanyCountry.sendKeys(companyCountry);
//    }
    public void setTxtCompanyAddress(String companyAddress) {
        txtCompanyAddress.sendKeys(companyAddress);
    }
    public void setTxtCompanyCity(String companyCity) {
        txtCompanyCity.sendKeys(companyCity);
    }
//    public void setUpdComplianceFile(String complianceFile) {
//        updComplianceFile.sendKeys(complianceFile);
//    }

    public void clickBtnContinue2() {
        btnContinue2.click();
    }

    public void clickLinkHome(){
        linkHome.click();
    }

    public void clickCbxProfile(){
        cbxProfile.click();
    }

    public void clickLinkLogout(){
        linkLogout.click();
    }

}
