package Web_Sanity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.*;

public class Provider {

    private static void sendHumanKeys(WebElement element, String text) {
        Random r = new Random();
        for(int i = 0; i < text.length(); i++) {
            try {
                Thread.sleep((int)(r.nextGaussian() * 15 + 100));
            } catch(InterruptedException e) {}
            String s = new StringBuilder().append(text.charAt(i)).toString();
            element.sendKeys(s);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        /* ----------- Chrome option and Webdriver declaration --------*/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("--disable-extensions");

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation", "enable-logging", "disable- notifications"});
//        options.addArguments("user-data-dir=C://C:\\Users\\Ajith\\AppData\\Local\\Google\\Chrome\\User Data"); // Windows Example
//        options.addArguments("user-data-dir=C:/Users/Ajith/AppData/Local/Google/Chrome/User Data");
//        options.addArguments("profile-directory=Default");
        /*------Cache clear----*/
        WebDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        driver.manage().window().maximize();
        /* -------------WebElement Declaration (Object Repository) --------------*/
        /* -------------- LOGIN ---------------*/
        driver.get("https://qa.telepain.md");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//auth-google-login-button")));
        driver.findElement(By.xpath("//auth-google-login-button")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        String winHandleBefore = driver.getWindowHandle();
        System.out.println("Total window number: " + windowHandlesList.size() + "\n");
        driver.switchTo().window(windowHandlesList.get(1));
        //rfranklin@telepain.md
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("qaqc11no2022@gmail.com");
        driver.findElement(By.xpath("//button[@type='button']//descendant::span[text()='Next']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        //Refinedforgodsglory@2025
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("aji08112k");
        driver.findElement(By.id("passwordNext")).click();
        /* ---------- HOME PAGE Validation ---------------*/
//        driver.switchTo().window(winHandleBefore);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='branding']/h2")));
        String actualTitle = driver.findElement(By.xpath("//div[@class='branding']/h2")).getText();
        String expectedTitle = "OPOS";
        System.out.println("Navigated to home page. Page Title:"+actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.findElement(By.xpath("//mat-nav-list[contains(@class,'mat-nav-list')]/descendant::div[@aria-describedby='cdk-describedby-message-5']")).click();

        /*------------------- PROVIDER LIST -------------------*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='PROVIDER LIST']")));
        String actualList =  driver.findElement(By.xpath("//h5[text()='PROVIDER LIST']")).getText();
        String expectedList = "PROVIDER LIST";
        System.out.println("Navigated to Provider List page. Page Title:"+actualList);
        Assert.assertEquals(expectedList,actualList);
        /*-------------Add New Provider---------*/
        driver.findElement(By.xpath("//span[text()='NEW PROVIDER']/parent::button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='ADD NEW PROVIDER']")));
        driver.findElement(By.xpath("//mat-label[text()='Prefix']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("Mr.");
        driver.findElement(By.xpath("//mat-label[text()='Email']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("William2Jamie@gmail.com");
        driver.findElement(By.xpath("//mat-label[text()='First Name']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("Jamie");
        driver.findElement(By.xpath("//mat-label[text()='Last Name']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("William");
        driver.findElement(By.xpath("//mat-label[text()='DEA Number']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("RV3213649");
        driver.findElement(By.xpath("//mat-label[text()='NPI Number']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("4569959856");
        driver.findElement(By.xpath("//mat-label[text()='State Licence Number']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("232982547");
        driver.findElement(By.xpath("//mat-label[text()='Home Phone Number']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("5466123780");
        driver.findElement(By.xpath("//mat-label[text()='Office Phone Number']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("9865416021");
        driver.findElement(By.xpath("//mat-label[text()='Speciality']/ancestor::div[@class='mat-form-field-infix']/input")).sendKeys("General Medicine");
        driver.findElement(By.xpath("//span[text()='ADD']/parent::button")).click();
        /*------Provider List Search-----*/
        driver.switchTo().window(winHandleBefore);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name (active/inactive providers)']")));
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search by name (active/inactive providers)']"));
        sendHumanKeys(searchBox,"Jamie");
        Thread.sleep(2000);
        String actualName = driver.findElement(By.xpath("//tbody/tr/td/a")).getText();
        String expectedName = "Mr. Jamie William";
        System.out.println("Created Provider. Provider Name:"+actualName);
        Assert.assertEquals(expectedName,actualName);
        //driver.quit();
    }
}

