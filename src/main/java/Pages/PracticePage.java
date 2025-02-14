package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage {


//    WebDriver driver;
//    public PracticePage(WebDriver driver){
//        this.driver=driver;
//    }

    //Practice page
    public By practiceListTextLocator = By.xpath("(//*[text()='PRACTICE LIST'])[2]");

    public By addNewPracticeButtonLocator = By.xpath("//*[text()='ADD NEW PRACTICE']");

    //Practice details
    public By nameInputLocator = By.id("mat-input-3");

    public By locationLocator = By.id("mat-input-4");

    public By einLocator = By.id("mat-input-5");

    public By address1Locator = By.id("mat-input-6");

    public By cityLocator = By.id("mat-input-7");

    public By stateLocator = By.id("mat-select-0");
    //dropdown values
    public By stateDropDownLocator = By.xpath("//*[@class='ng-tns-c38-12 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary']");

    public By address2Locator = By.id("mat-input-8");

    public By zipcodeLocator = By.xpath("//*[@formcontrolname='pinCode']");

    public By phoneNumberLocator = By.id("mat-input-10");

    public By emailAddressLocator = By.id("email");

    public By faxNumberLocator = By.id("mat-input-12");

    public By timeZoneLocator = By.id("mat-select-1");
    //dropDown values
    public By timeZoneDropDownLocator = By.xpath("//*[@class='ng-tns-c38-19 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary']");

    public By addButtonLocator = By.xpath("//*[text()='ADD']");

    //success message
    public By practicePopUP = By.xpath("//*[contains(text(),'Added')]");

    //verify the practice
    public By practiceSearchBoxLocator = By.id("mat-input-2");

    public By practiceContentLocator = By.xpath("//*[@class='pointer mat-cell cdk-column-name mat-column-name ng-star-inserted']");


    public void verifyPractice(String name){

        By ensurePractice = By.xpath("//*[text()=' "+name+" ']");
    }

    //delete
    public By deleteIcon=By.xpath("(//*[@class='colorCustom mat-icon notranslate material-icons mat-icon-no-color'])[3]");

    public By popUpOk=By.xpath("//*[text()='OK']");

}
