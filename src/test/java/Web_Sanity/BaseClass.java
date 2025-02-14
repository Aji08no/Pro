package Web_Sanity;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProviderPage;
import Utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    protected  static  WebDriver driver;
    protected LoginPage loginPage;
    protected WaitUtility waitUtility;
    protected WindowUtility windowUtility;
    protected  PropertiesUtility propertiesUtility;
    protected  PropertiesUtility practiceProperties;
    protected  PropertiesUtility providerProperties;
    protected HomePage homePage;
    protected WebDriver_Utility webDriver_utility;
    PracticePage practicePage;
    ProviderPage providerPage;

    @BeforeTest
    public void setUpBrowser() throws IOException {

//        WebDriver driver = DriverUtility.initializeDriver("chrome");
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();

        driver = DriverUtility.initializeDriver("chrome");
        propertiesUtility = new PropertiesUtility("C:\\Users\\Ajith\\IdeaProjects\\Oops Project\\src\\main\\resources\\Data.properties");

        windowUtility = new WindowUtility(driver);

        windowUtility.maximizeWindow();
        driver.get(propertiesUtility.getProperty("URL"));

    }

    @BeforeClass
    public void beforeMethod() throws IOException {
        loginPage =new LoginPage(driver);

        homePage=new HomePage(driver);

        webDriver_utility=new WebDriver_Utility(driver);
        waitUtility=new WaitUtility(driver);
        practiceProperties=new PropertiesUtility("C:\\Users\\Ajith\\IdeaProjects\\Oops Project\\src\\main\\resources\\PracticeDetails.properties");
        providerProperties=new PropertiesUtility("C:\\Users\\Ajith\\IdeaProjects\\Oops Project\\src\\main\\resources\\ProviderDetails.properties");
        practicePage=new PracticePage();
        providerPage=new ProviderPage();
    }

    @AfterTest(enabled = false)
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
        else {
            System.out.println("failed");
        }
    }
}
