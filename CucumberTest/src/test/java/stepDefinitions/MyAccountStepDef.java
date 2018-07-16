package stepDefinitions;

import browserManager.BrowserManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MyAccountStepDef {
    WebDriver driver = BrowserManager.getDriver();
    @Then("^Navego al menu \"([^\"]*)\"$")
    public void seleccionar_menu(String opcion) {
        seleccionarOpcionEnUserDropdown(opcion);
        WebDriverWait wait = new WebDriverWait(driver, 60);
    }

    private void seleccionarOpcionEnUserDropdown(String option){
        userLabel().click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]")));
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]")).click();
        //jsExecutor
    }

    @Then("^Selecciono el tab \"([^\"]*)\"$")
    public void seleccionar_tab(String tab){
        //a[contains(text(),"Profuile")]
        driver.findElement(By.xpath("//a[contains(text(),'"+tab+"')]")).click();
    }

    @Then("^Lleno los siguientes datos en profile form$")
    public void llenarDatosEnProfileForm(DataTable datos){
        List<List<String>> datosProfile = datos.raw();
        for (List<String> dato:datosProfile){
            switch (dato.get(0)){
                case "company":
                    companyTextBox().clear();
                    companyTextBox().sendKeys(dato.get(1));
                    break;
                case "professional title":
                    professionalTitleTextBox().clear();
                    professionalTitleTextBox().sendKeys(dato.get(1));
                    break;
            }
        }
    }

    @Then("^Hago click en el boton Save Changes$")
    public void clickEnSaveButton(){
        saveChangesButton().click();
        WebElement savedSuccessfullyMessage = driver.findElement(By.xpath("//p[text()='Your profile was successfully updated.']"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOf(savedSuccessfullyMessage));
    }

    @Then("^Verifico que los siguientes datos en profile form$")
    public void verificarDatosEnProfileForm(DataTable datos){
        List<List<String>> datosProfile = datos.raw();
        for (List<String> dato:datosProfile){
            switch (dato.get(0)){
                case "company":
                    String actualCompany = companyTextBox().getAttribute("value");
                    Assert.assertEquals(dato.get(1),actualCompany,"El dato del campo company no es igual");
                    break;
                case "professional title":
                    String actualProfessionalTitle = professionalTitleTextBox().getAttribute("value");
                    Assert.assertEquals(dato.get(1),actualProfessionalTitle, "El valor de professional title es incorrecto");
                    break;
            }
        }
    }

    private WebElement userLabel(){
        return driver.findElement(By.xpath("//*[@id='my_account']/span"));
    }

    private WebElement companyTextBox(){
        return driver.findElement(By.id("user_profile_attributes_company"));
    }

    private WebElement professionalTitleTextBox(){
        return driver.findElement(By.id("user_profile_attributes_headline"));
    }

    private  WebElement saveChangesButton(){
        return driver.findElement(By.xpath("//input[@class='btn btn-primary auto']"));
    }
}
