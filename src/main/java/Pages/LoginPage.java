package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    WebDriver driver;
    public LoginPage(WebDriver driver){

        this.driver=driver;
//        PageFactory.initElements(driver,this);
    }

//    @FindBy(id = "gbtn")
//    public WebElement siginButton;

//    public void clickSiginButton(){
//        siginButton.click();
//    }

    public By siginButtonLocator = By.id("gbtn");

    public By mailLocator =By.id("identifierId");

    public By nextButtonLocator = By.xpath("//*[text()='Next']");

    public By passwordLocator = By.name("Passwd");



}
