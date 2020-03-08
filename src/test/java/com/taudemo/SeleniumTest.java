package com.taudemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void openTheComPageAndCheckTheTitle() {
        String expectedComTitle = "Example Domain";
        driver.get("https://www.example.com");
        Assert.assertEquals(driver.getTitle(), expectedComTitle);
    }

    @Test
    public void openTheOrgPageAndCheckTheTitle() {
        String expectedOrgTitle = "Example Domain";
        driver.get("https://www.example.org");
        Assert.assertEquals(driver.getTitle(), expectedOrgTitle);
    }
}
