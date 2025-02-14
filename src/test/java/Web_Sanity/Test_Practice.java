package Web_Sanity;

import Utility.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Practice extends BaseClass{


    @Test(priority = 0)
    public void createPractice() throws IOException, InterruptedException {

        //click the practiceList
        WebElement practiceList = waitUtility.waitForElementPresent(homePage.PracticeListLocator);
        practiceList.click();

//        driver.findElement(By.xpath("(//*[@class='main-menu-icon ng-star-inserted'])[2]")).click();

        //click the new practice
        String pageHeading = webDriver_utility.getTextValue(practicePage.practiceListTextLocator);
        Assert.assertEquals(pageHeading,"PRACTICE LIST");
        System.out.println(pageHeading);

        Thread.sleep(1000);
        WebElement newPracticeButton = waitUtility.waitForElementClickable(practicePage.addNewPracticeButtonLocator);
        newPracticeButton.click();
//        driver.findElement(By.xpath("//*[text()='ADD NEW PRACTICE']")).click();

        //fill the fields
        WebElement enterName = waitUtility.waitForElementPresent(practicePage.nameInputLocator);
        enterName.sendKeys(practiceProperties.getProperty("practiceName"));

        WebElement enterPracticeLocation = waitUtility.waitForElementPresent(practicePage.locationLocator);
        enterPracticeLocation.sendKeys(practiceProperties.getProperty("practiceLocation"));

        WebElement enterEIN = waitUtility.waitForElementPresent(practicePage.einLocator);
        enterEIN.sendKeys(practiceProperties.getProperty("EIN"));

        WebElement enterAddressLine1 = waitUtility.waitForElementPresent(practicePage.address1Locator);
        enterAddressLine1.sendKeys(practiceProperties.getProperty("addressLine"));

        WebElement enterCity = waitUtility.waitForElementPresent(practicePage.cityLocator);
        enterCity.sendKeys(practiceProperties.getProperty("city"));


        WebElement state = waitUtility.waitForElementPresent(practicePage.stateLocator);
        state.click();
        WebElement selectState = waitUtility.waitForElementPresent(By.xpath("//*[text()='"+practiceProperties.getProperty("state")+"']"));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", selectState);
        //Florida (FL)

        //select the state
//        WebElement selectState = driver.findElement(By.id("mat-select-0"));
//        Select state=new Select(selectState);
//        state.selectByVisibleText("Colorado (CO)");
//        driver.findElement(By.xpath("//*[text()='Colorado (CO)']")).click();

//        Actions a=new Actions(driver);
//        a.moveToElement(selectState).clickAndHold().moveByOffset(0,100).release().perform();

        selectState.click();


        WebElement enterAddressLine2 = waitUtility.waitForElementPresent(practicePage.address2Locator);
        enterAddressLine2.sendKeys(practiceProperties.getProperty("addressLine2"));

        WebElement enterZipCode = waitUtility.waitForElementPresent(practicePage.zipcodeLocator);
        enterZipCode.sendKeys("781-8390");

        WebElement enterPhoneNUmber =waitUtility.waitForElementPresent(practicePage.phoneNumberLocator);
        enterPhoneNUmber.sendKeys(practiceProperties.getProperty("phoneNumber"));

        WebElement enterEmail = waitUtility.waitForElementPresent(practicePage.emailAddressLocator);
        enterEmail.sendKeys(practiceProperties.getProperty("eMail"));

        WebElement enterFaxNUmber = waitUtility.waitForElementPresent(practicePage.faxNumberLocator);
        enterFaxNUmber.sendKeys(practiceProperties.getProperty("faxNUmber"));

        WebElement selectTimeZone = waitUtility.waitForElementPresent(practicePage.timeZoneLocator);
        selectTimeZone.click();
        driver.findElement(By.xpath("//*[text()='"+practiceProperties.getProperty("timeZone")+"']")).click();

//        Select timezone=new Select(selectTimeZone);
//        timezone.selectByVisibleText("America/Los_Angeles");

        //click Add Button
        WebElement addButton = waitUtility.waitForElementPresent(practicePage.addButtonLocator);
        addButton.click();

        waitUtility.waitForElementVisible(practicePage.practicePopUP);

        String success = waitUtility.waitForElementPresent(practicePage.practicePopUP).getText();
        System.out.println(success);


    }

    @Test(priority = 1)
    public void verifyPractice() throws InterruptedException {
        //verify the new practice
        WebElement searchBar = waitUtility.waitForElementPresent(practicePage.practiceSearchBoxLocator);
        searchBar.sendKeys(practiceProperties.getProperty("practiceName"));

        Thread.sleep(2000);
        String practiceName = waitUtility.waitForElementPresent(practicePage.practiceContentLocator).getText();

        Thread.sleep(2000);

        Assert.assertEquals(practiceName,practiceProperties.getProperty("practiceName"));

//        WebElement delete = waitUtility.waitForElementPresent(practicePage.deleteIcon);
//        delete.click();
//
//        WebElement ok = waitUtility.waitForElementPresent(practicePage.popUpOk);
//        ok.click();

    }
}
