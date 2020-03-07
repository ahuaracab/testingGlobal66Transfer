package taudemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }

    @Test
    public void openThePageAndCheckTheTitle() {
        String expectedTitle = "Title";
        Assert.assertEquals(expectedTitle,"hola");
        System.out.println(expectedTitle);
    }
}
