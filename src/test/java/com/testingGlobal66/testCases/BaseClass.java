package com.testingGlobal66.testCases;

import com.testingGlobal66.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.ArrayList;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getBaseURL();
    public String email = readconfig.getEmail();
    public String password = readconfig.getPassword();

//	public String customerName = readconfig.getCustomerName();
//	public String gender = readconfig.getGender();
//	public String month = readconfig.getMonth();
//	public String day = readconfig.getDay();
//	public String year = readconfig.getYear();
//	public String city = readconfig.getCity();
//	public String address = readconfig.getAddress();
//	public String state = readconfig.getState();
//	public String pin = readconfig.getPIN();
//	public String phone = readconfig.getPhone();
//	public String email = randomString()+"@gmail.com";
//	public String passNewCustomer = readconfig.getPassNewCustomer();

    public static WebDriver driver;

	public static Logger logger;



    //	@Parameters("browser")
    @BeforeClass
    public void setup() {

        logger = Logger.getLogger("global66TransferLogin");
        PropertyConfigurator.configure("log4j.properties");

//		if (br.equals("chrome")) {
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
        driver = new ChromeDriver();
//		} else if (br.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
//			driver = new FirefoxDriver();
//		}
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public int getEmailCount() throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/java/com/testingGlobal66/testData/testEmailCount.txt");
        BufferedReader br = new BufferedReader(file);
        int count = 0;
        String emailCount = br.readLine();
        System.out.println("emailCount: " + emailCount);
        try {
            count = Integer.parseInt(emailCount);
            System.out.println("count:" + count);
//			fr.close();

        } catch (NumberFormatException nfe) {
            System.out.println("error de formato numerico");
        }
        br.close();
        file.close();
        return count;
    }

    public void setEmailCount(int emailCount) throws IOException {
        FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/test/java/com/testingGlobal66/testData/testEmailCount.txt");
        BufferedWriter bw = new BufferedWriter(file);
        bw.write(String.valueOf(emailCount));
        bw.close();
        file.close();

    }

    public ArrayList<String> emailGenerator(int cant) throws IOException {
        int emailCount = getEmailCount();
        System.out.println("emailCount: " + emailCount);
        ArrayList<String> emails = new ArrayList<String>();
        String email = null;

        for (int i = 0; i < cant; i++) {

            email = "testglobal" + String.valueOf(emailCount) + "@mailinator.com";
            System.out.println("email: " + email);
            emails.add(email);
            emailCount++;
        }

        System.out.println("emailCount final: " + emailCount);
        System.out.println("emails: " + email);

        setEmailCount(emailCount);
        return (emails);
    }
}

	

