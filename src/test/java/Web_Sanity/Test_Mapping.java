package Web_Sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test_Mapping extends BaseClass{

    @Test
     public void practiceFromProvider() throws InterruptedException {
        //click the practiceList
        WebElement practiceList = waitUtility.waitForElementPresent(homePage.PracticeListLocator);
        practiceList.click();
        Thread.sleep(1000);
        driver.navigate().refresh();

        //search the practice
//        WebElement searchBar = driver.findElement(By.id("mat-input-2"));
//        searchBar.clear();
//        searchBar.sendKeys(practiceProperties.getProperty("practiceName"));

        //view icon(//*[@class='mat-button-ripple mat-ripple mat-button-ripple-round'])[2]
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='colorCustom mat-icon notranslate material-icons mat-icon-no-color'])[2]")).click();
        Thread.sleep(4000);
        WebElement providerList = driver.findElement(By.xpath("(//*[text()='Email Address'])[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", providerList);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn mat-raised-button mat-primary']//span[text()='ADD PROVIDER']")).click();


        waitUtility.waitForElementClickable(By.xpath("//div[@class='mat-select-arrow']")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[text()=' Mr. QA Provider ']")).click();
       try{
          WebElement selectProvider = driver.findElement(By.xpath("//*[contains(text(),'"+providerProperties.getProperty("prefix")+" "+Test_Provider.randomF+"')]"));
          selectProvider.click();
       } catch (Exception e) {
          System.out.println(Test_Provider.randomF+"is not there");
          throw new RuntimeException(e);
       }

        //confirm
//        driver.findElement(By.xpath("//button[@class='btn btnPrimary mat-raised-button']//span")).click();
    }

}
