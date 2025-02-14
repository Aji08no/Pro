package Pages;

import org.openqa.selenium.By;

public class ProviderPage {


    //provider page
    public By providerListTextLocator = By.xpath("(//*[text()='PROVIDER LIST'])[2]");

    public By newProviderButtonLocator= By.xpath("//*[text()='NEW PROVIDER']");

    //provider details
    public By enterPrefixLocator =By.xpath("(//*[@ng-reflect-name='title'])[2]");

    public By enterEmailLocator =By.xpath("//*[@ng-reflect-name='email']");

    public By enterFirstNameLocator =By.xpath("//*[@ng-reflect-name='firstName']");

    public By enterLastNameLocator =By.xpath("//*[@ng-reflect-name='lastName']");

    public By enterDEANumberLocator =By.xpath("//*[@ng-reflect-name='dea']");

    public By enterNPINumberLocator =By.xpath("//*[@ng-reflect-name='npi']");

    public By enterStateLicenseNumberLocator =By.xpath("//*[@ng-reflect-name='stateLicence']");

    public By enterHomePhoneNumberLocator =By.xpath("//*[@ng-reflect-name='homePhone']");

    public By enterOfficePhoneNumberLocator =By.xpath("//*[@ng-reflect-name='officePhone']");

    public By enterSpecialtyLocator =By.xpath("//*[@ng-reflect-name='speciality']");

    public By addButtonLocator = By.xpath("//*[text()='ADD']");

    //success message
    public By providerPopUP = By.xpath("//*[contains(text(),'Practitioner Created Succesfully')]");

    //verify the provider
    public By providerSearchBoxLocator = By.xpath("//*[contains(@placeholder,'Search by name')]");

    public By providerContentLocator = By.xpath("//*[@class='pointer mat-cell cdk-column-name mat-column-name ng-star-inserted']");



}
