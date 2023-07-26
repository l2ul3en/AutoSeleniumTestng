package org.store.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.store.pages.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private FileReader reader;
    private Properties props;
    private String BASE_URL;
    protected WebDriver driver;
    protected HomePage homePage;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected CreateOrderPage orderPage;
    protected NewAddressPage newAddressPage;

    @BeforeTest
    public void loadSettings() throws IOException {
        reader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        props = new Properties();
        props.load(reader);
        BASE_URL = props.getProperty("url");
    }

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        homePage =new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        orderPage = new CreateOrderPage(driver);
        newAddressPage = new NewAddressPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(source, new File("./screenshots/" + result.getName() + ".png"));
            }catch (Exception e){
                System.out.println("Screen while run test " + e.getMessage());
            }
        }
        driver.quit();
    }

}
