package stepDefinitions;

import browserManager.BrowserManager;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeStepDef {
    WebDriver driver = BrowserManager.getDriver();
    @Then("^En la pagina home debo ver el usuario \"([^\"]*)\"$")
    public void en_la_pagina_home_debo_ver_el_usuario(String user) {
        String actualUser = userLabel().getAttribute("innerText");
        Assert.assertTrue(actualUser.contains(user),"El usuario no esta logueado");
    }

    @Then("^Cierro session$")
    public void cerrar_session() {
        seleccionarOpcionEnUserDropdown("Sign Out");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Sign In')]")));
    }

    private void seleccionarOpcionEnUserDropdown(String option){
        userLabel().click();
        //ul[@class='dropdown-menu']/li/a[contains(text(),'My Account')]
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]")));
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]"));
        //jsExecutor
    }

    private WebElement userLabel(){
        return driver.findElement(By.xpath("//*[@id='my_account']/span"));
    }
}
