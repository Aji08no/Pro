package Utility;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowUtility {

    WebDriver driver;
    public WindowUtility(WebDriver driver){

        this.driver=driver;
    }

    public void switchToWindow(int windowIndex){

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        if (windowHandlesList.size() > windowIndex) {
            driver.switchTo().window(windowHandlesList.get(windowIndex));
//            System.out.println("Switched to window with index: " + windowIndex);
        } else {
            System.out.println("Window index " + windowIndex + " is out of bounds. Available windows: " + windowHandlesList.size());
        }
    }

    public void switchToMainWindow(){
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void maximizeWindow(){
            driver.manage().window().maximize();


    }

}
