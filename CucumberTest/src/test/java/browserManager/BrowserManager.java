package browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
