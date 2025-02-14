package Web_Sanity;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Test_Provider extends BaseClass{

    public static String randomF="";

    @Test(enabled = true,priority = 0)
    public void createProvider() throws InterruptedException {

    //click the providerList(//*[@class='main-menu-icon ng-star-inserted'])[3]

        WebElement providerList = webDriver_utility.waitForElementPresent(homePage.ProviderListLocator);
        providerList.click();

        String pageHeading = webDriver_utility.getTextValue(providerPage.providerListTextLocator);
        Assert.assertEquals(pageHeading,"PROVIDER LIST");
        System.out.println(pageHeading);

        Thread.sleep(1000);
        WebElement newProviderButton = waitUtility.waitForElementPresent(providerPage.newProviderButtonLocator);
        newProviderButton.click();

        //fill the fields
//        waitUtility.waitForElementPresent(providerPage.enterPrefix);


         WebElement enterPrefix = waitUtility.waitForElementPresent(providerPage.enterPrefixLocator);
         enterPrefix.sendKeys(providerProperties.getProperty("prefix"));


        WebElement enterEmail = waitUtility.waitForElementPresent(providerPage.enterEmailLocator);
        enterEmail.sendKeys(providerProperties.getProperty("providerEmail"));

        WebElement enterFirstName = waitUtility.waitForElementPresent(providerPage.enterFirstNameLocator);
        enterFirstName.sendKeys(providerProperties.getProperty("firstName"));

        WebElement enterLastName = waitUtility.waitForElementPresent(providerPage.enterLastNameLocator);
        enterLastName.sendKeys(providerProperties.getProperty("lastName"));

        WebElement enterDEANumber = waitUtility.waitForElementPresent(providerPage.enterDEANumberLocator);
        enterDEANumber.sendKeys(providerProperties.getProperty("DEANumber"));

        WebElement enterNPINumber = waitUtility.waitForElementPresent(providerPage.enterNPINumberLocator);
        enterNPINumber.sendKeys(providerProperties.getProperty("NPINumber"));

        WebElement enterStateLicense = waitUtility.waitForElementPresent(providerPage.enterStateLicenseNumberLocator);
        enterStateLicense.sendKeys(providerProperties.getProperty("stateLicenseNumber"));

        WebElement enterHomeNumber = waitUtility.waitForElementPresent(providerPage.enterHomePhoneNumberLocator);
        enterHomeNumber.sendKeys(providerProperties.getProperty("homeNumber"));

        WebElement enterOfficePhoneNumber = waitUtility.waitForElementPresent(providerPage.enterOfficePhoneNumberLocator);
        enterOfficePhoneNumber.sendKeys(providerProperties.getProperty("officePhoneNumber"));

        WebElement enterSpecialty = waitUtility.waitForElementPresent(providerPage.enterSpecialtyLocator);
        enterSpecialty.sendKeys(providerProperties.getProperty("specialty"));

        //click Add Button
        waitUtility.waitForElementPresent(providerPage.addButtonLocator).click();

        try {
            // Wait for the provider pop-up to appear
            WebElement success = waitUtility.waitForElementPresent(providerPage.providerPopUP);
            System.out.println("Popup found: " + success);
        } catch (Exception e) {

            System.out.println("Popup not found, entering catch block...");

            boolean addCondition = true;
            Random r = new Random();

            while (addCondition) {
                int randomNum = r.nextInt(100); // Generate a random number (0 to 99)

                try {
                    //need for extra wait - issue reason
                    // Locate and modify the email field
                    WebElement reEnterEmail = waitUtility.waitForElementClickable(providerPage.enterEmailLocator);
                    reEnterEmail.clear();
                    String randomEmail = "qa" + randomNum + "provider@gmail.com";
                    reEnterEmail.sendKeys(randomEmail);

                    // Locate and modify the first name field
                    WebElement reEnterFirstName = waitUtility.waitForElementVisible(providerPage.enterFirstNameLocator);
                    reEnterFirstName.clear();
                    String randomFirstName = providerProperties.getProperty("firstName") + randomNum;
                    reEnterFirstName.sendKeys(randomFirstName);

                    // Click the "ADD" button
                    waitUtility.waitForElementClickable(providerPage.addButtonLocator).click();

                    // Check if the "Account already exists as admin" message appears
                    try {
                        Thread.sleep(1000);
                        WebElement errorMsg = waitUtility.waitForElementVisible(By.xpath("//*[text()='Account already exists as admin']"));
                        System.out.println("Account already exists, retrying...");
                    } catch (Exception e2) {
                        randomF=randomFirstName+" "+providerProperties.getProperty("lastName");
                        System.out.println(randomF);
                        System.out.println("Successfully added provider: " + randomFirstName + " (" + randomEmail + ")");
                        addCondition = false; // Exit the loop when the account does not already exist
                    }

                } catch (Exception loopException) {
                    System.out.println("Error inside while loop: " + loopException.getMessage());
                    addCondition = false; // Exit loop to prevent infinite execution
                }
            }
        }


//        waitUtility.waitForElementVisible(providerPage.providerPopUP);

    }

    @Test(priority = 1,enabled = true)
    public void verifyProvider() throws InterruptedException {
        Thread.sleep(5000);
        //verify the new provider
        waitUtility.waitForElementPresent(providerPage.providerSearchBoxLocator).sendKeys(randomF);

        Thread.sleep(2000);
        String provideContentName = waitUtility.waitForElementPresent(providerPage.providerContentLocator).getText();

        Thread.sleep(4000);
        Assert.assertEquals(provideContentName,providerProperties.getProperty("prefix")+" "+randomF);

    }

    @Test(enabled = false)
    public void bestWay() throws InterruptedException {

        WebElement providerList = webDriver_utility.waitForElementPresent(homePage.ProviderListLocator);
        providerList.click();

        String pageHeading = webDriver_utility.getTextValue(providerPage.providerListTextLocator);
        Assert.assertEquals(pageHeading,"PROVIDER LIST");
        System.out.println(pageHeading);

        Thread.sleep(1000);
        WebElement newProviderButton = waitUtility.waitForElementPresent(providerPage.newProviderButtonLocator);
        newProviderButton.click();

        WebElement enterPrefix = driver.findElement(By.xpath("(//*[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid'])[1]"));
        enterPrefix.sendKeys(providerProperties.getProperty("prefix"),
                Keys.TAB,providerProperties.getProperty("providerEmail"));
        driver.findElement(By.xpath("//*[@ng-reflect-name='firstName']")).sendKeys(providerProperties.getProperty("firstName"),
//                Keys.TAB,providerProperties.getProperty("firstName"),
                Keys.TAB,providerProperties.getProperty("lastName"),
                Keys.TAB,providerProperties.getProperty("DEANumber"),
                Keys.TAB,providerProperties.getProperty("NPINumber"),
                Keys.TAB,providerProperties.getProperty("stateLicenseNumber"),
                Keys.TAB,providerProperties.getProperty("homeNumber"),
                Keys.TAB,providerProperties.getProperty("officePhoneNumber"),
                Keys.TAB,providerProperties.getProperty("specialty"));

        //click Add Button
//        driver.findElement(By.xpath("//*[text()='ADD']")).click();

//        waitUtility.waitForElementVisible(providerPage.providerPopUP);

        //verify the new provider
        driver.findElement(By.id("mat-input-2")).sendKeys(providerProperties.getProperty("prefix")+providerProperties.getProperty("firstName")+providerProperties.getProperty("lastName"));
    }
}
