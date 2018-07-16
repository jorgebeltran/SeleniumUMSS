package stepDefinitions;

import browserManager.BrowserManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class LoginStepDef {
    WebDriver driver = BrowserManager.getDriver();

    @Given("^Accedo a la pagina \"([^\"]*)\"$")
    public void accedo_a_la_pagina(String url){
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @When("^Lleno el campo email con \"([^\"]*)\"$")
    public void lleno_el_campo_email_con(String email) {
        emailTextBox().sendKeys(email);
    }

    @When("^Lleno el campo password con \"([^\"]*)\"$")
    public void lleno_el_campo_password_con(String password)  {
        passwordTextBox().sendKeys(password);
    }

    @When("^Hago click en el boton Sing In$")
    public void hago_click_en_el_boton_Sing_In() {
        singInButton().click();
        //p[text()='Signed in successfully.']
        WebElement signedSuccessfullyMessage = driver.findElement(By.xpath("//p[text()='Signed in successfully.']"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOf(signedSuccessfullyMessage));
    }

    @Then("^Debo ver un mensaje de error que dice \"([^\"]*)\"$")
    public void debo_ver_un_mensaje_de_error_que_dice(String mensaje) {
        String actualMensaje = errorLoginMessage().getAttribute("innerText");
        Assert.assertEquals(mensaje,actualMensaje,"El mensaje de error no es correcto");
    }

    @When("^Me logueo en la aplicacion con$")
    public void login(DataTable datos){
        List<List<String>> credenciales = datos.raw();
        lleno_el_campo_email_con(credenciales.get(0).get(1));
        lleno_el_campo_password_con(credenciales.get(1).get(1));
        hago_click_en_el_boton_Sing_In();
    }


    private WebElement emailTextBox(){
        return driver.findElement(By.id("user_email"));
    }

    private WebElement passwordTextBox(){
        return driver.findElement(By.id("user_password"));
    }

    private WebElement singInButton(){
        return driver.findElement(By.id("btn-signin"));
    }

    private WebElement errorLoginMessage(){
        return driver.findElement(By.xpath("//*[@id='notifications-error']/ul/li"));
    }
}
