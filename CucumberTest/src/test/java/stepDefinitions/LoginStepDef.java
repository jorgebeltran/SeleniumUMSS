package stepDefinitions;

import browserManager.BrowserManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStepDef {
    WebDriver driver = BrowserManager.getDriver();

    @Given("^Accedo a la pagina \"([^\"]*)\"$")
    public void accedo_a_la_pagina(String url){
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
}
