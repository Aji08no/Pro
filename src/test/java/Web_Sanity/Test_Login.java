package Web_Sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test_Login extends BaseClass{

        @Test()
        public void login() throws InterruptedException, IOException {
                WebElement siginButton1 = waitUtility.waitForElementVisible(loginPage.siginButtonLocator);
        siginButton1.click();

        //switchToAnotherWindow
        windowUtility.switchToWindow(1);

        //Email
        WebElement enterEmail = waitUtility.waitForElementPresent(loginPage.mailLocator);
        enterEmail.sendKeys(propertiesUtility.getProperty("loginEmail"));

        //Next
        WebElement mailNextButton = waitUtility.waitForElementClickable(loginPage.nextButtonLocator);
        mailNextButton.click();
        //Password
        WebElement enterPassword = waitUtility.waitForElementPresent(loginPage.passwordLocator);
        Thread.sleep(1000);
        enterPassword.sendKeys(propertiesUtility.getProperty("loginPassword"));

        //Next
        Thread.sleep(800);
        WebElement passwordNextButton = waitUtility.waitForElementClickable(loginPage.nextButtonLocator);
        passwordNextButton.click();

        windowUtility.switchToMainWindow();
        Thread.sleep(10000);


            waitUtility.waitForElementVisible(By.xpath("//div[@class='branding']"));
            String title=driver.getTitle();

            Thread.sleep(2000);
            Assert.assertEquals(title,"Home");

                System.out.println("Successfully logged in.");
           webDriver_utility.DisplayText(homePage.OposTextLocator);
    }

}
