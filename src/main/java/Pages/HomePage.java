package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

   public By OposTextLocator= By.xpath("//*[text()='OPOS']");

    public By PracticeListLocator= By.xpath("(//*[@class='main-menu-icon ng-star-inserted'])[2]");

    public By ProviderListLocator= By.xpath("(//*[@class='main-menu-icon ng-star-inserted'])[3]");


}
