import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fillOutForm {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ultimateqa.com/filling-out-forms/");
    }
    @Test
    public void fillFirstForm(){
        WebElement name1TextBox = driver.findElement(By.id("et_pb_contact_name_1"));
        name1TextBox.sendKeys("Name Text Box 1");

        WebElement message1TextBox = driver.findElement(By.id("et_pb_contact_message_1"));
        message1TextBox.sendKeys("Message Text Box 1");

        WebElement submitButton1 = driver.findElement(By.cssSelector(
                "#et_pb_contact_form_0 > div.et_pb_contact > form > div > button"));
        submitButton1.click();
        //Verificacion
        WebElement confirmationMessage1 = driver.findElement(
                By.xpath("//div[@class='et-pb-contact-message']/p"));
        String actualMessage = confirmationMessage1.getAttribute("innerText");
        Assert.assertEquals("Form filled out successfully",actualMessage,
                "The confirmation message is incorrect");
    }

    @Test
    public void fillSecondForm(){
        WebElement name2TextBox = driver.findElement(By.xpath(
                "//p[@class='et_pb_contact_field et_pb_contact_field_2 et_pb_contact_field_half']/input[@id='et_pb_contact_name_1']"));
        name2TextBox.sendKeys("Name Text Box 2");

        WebElement message2TextBox = driver.findElement(By.xpath(
                "//p[@class='et_pb_contact_field et_pb_contact_field_3 et_pb_contact_field_last']/textarea"));
        message2TextBox.sendKeys("Message Text Box 1");

        WebElement captchaTextBox = driver.findElement(By.name("et_pb_contact_captcha_1"));
        captchaTextBox.sendKeys("15");

        WebElement submitButton2 = driver.findElement(By.xpath(
                "//*[@id='et_pb_contact_form_1']/div/form/div/button"));
        submitButton2.click();
        //Verificacion
        WebElement confirmationMessage2 = driver.findElement(
                By.xpath("//*[@id='et_pb_contact_form_1']/div/p"));
        String actualMessage = confirmationMessage2.getAttribute("innerText");
        Assert.assertEquals("Success",actualMessage,
                "The confirmation message is incorrect");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
