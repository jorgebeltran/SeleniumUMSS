import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com/");
    }

    @Test
    public void primeraPruebaSelenium(){
        //System.setProperty("webdriver.gecko.driver","C:\\GeckoDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
        searchTextBox.sendKeys("Selenium");
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Buscar con Google']"));
        searchButton.click();
    }

    @Test
    public void segundaPruebaSelenium(){
        //System.setProperty("webdriver.gecko.driver","C:\\GeckoDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
        searchTextBox.sendKeys("Digital Harbor");
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Buscar con Google']"));
        searchButton.click();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
