package Web_Sanity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SampleLogin extends BaseClass {


    @Test(enabled = false)
    public void OpenBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.telepain.md/");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));


        WebElement siginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gbtn")));
        siginButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        String winHandleBefore = driver.getWindowHandle();
//        System.out.println("Total window number: " + windowHandlesList.size() + "\n");
        driver.switchTo().window(windowHandlesList.get(1));
        //Email
        WebElement enterEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        enterEmail.sendKeys("infosec@telepain.md");
        //Next
        WebElement mailNextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
        mailNextButton.click();
        //Password
        WebElement enterPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Passwd")));
        enterPassword.sendKeys("Pro17secPro17@OPOS");
        //Next
        Thread.sleep(800);
        WebElement passwordNextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
        passwordNextButton.click();
//        driver.findElement(By.id("")).click();
    }

    @Test(dataProvider = "loginData",enabled = false)
    public void login(String eMail,String password) throws InterruptedException {


//        WebElement siginButton =wait.until(ExpectedConditions.elementToBeClickable(LP.siginButtonLocator));
//        siginButton.click();


        WebElement siginButton1 = waitUtility.waitForElementVisible(loginPage.siginButtonLocator);
        siginButton1.click();


        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(1));


        //Email
//        WebElement enterEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
//        enterEmail.sendKeys(eMail);
//
//        //Next
//        WebElement mailNextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
//        mailNextButton.click();
//        //Password
//        WebElement enterPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Passwd")));
//        enterPassword.sendKeys(password);
//        //Next
//        Thread.sleep(800);
//        WebElement passwordNextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")));
//        passwordNextButton.click();


    }

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{
                {"infosec@telepain.md", "Pro17secPro17@OPOS"}
        };
    }
}
