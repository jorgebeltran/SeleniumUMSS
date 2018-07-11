package stepDefinitions;

import browserManager.BrowserManager;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeStepDef {
    WebDriver driver = BrowserManager.getDriver();
    @Then("^En la pagina home debo ver el usuario \"([^\"]*)\"$")
    public void en_la_pagina_home_debo_ver_el_usuario(String user) {
        String actualUser = userLabel().getAttribute("innerText");
        Assert.assertTrue(actualUser.contains(user),"El usuario no esta logueado");
    }

    private WebElement userLabel(){
        return driver.findElement(By.xpath("//*[@id='my_account']/span"));
    }
}
