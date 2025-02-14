package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {


    WebDriver driver;
    WebDriverWait wait;



    public WaitUtility(WebDriver driver){

        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementPresent(By locator){
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
