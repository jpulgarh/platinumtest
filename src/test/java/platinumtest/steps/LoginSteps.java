package platinumtest.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
	WebDriver driver = null;
	
    @Given("Estoy abriendo la página de inicio")
    public void iOpenTheLoginPage() {
    	System.setProperty("webdriver.chrome.driver", "/home/pi/eclipse-workspace/banco-automation-tests/src/test/resources/drivers/chromedriver");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("headless");
    	options.addArguments("--disable-gpu");
    	options.addArguments("disable-infobars");
    	options.addArguments("--disable-extensions");
    	options.addArguments("window-size=1200x600");
    	options.addArguments("--no-sandbox");
    	System.out.println("####### Ejecutando el navegador Chrome #########");
    	
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bancoplatinum/ingresar.jsp");
    }

    @When("Estoy ingresando el usuario {string} y la clave {string} y el rut {string}")
    public void iEnterTheUsernameAndPassword(String username, String password, String rut) {
        WebElement usernameField = driver.findElement(By.id("usuario"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement rutField = driver.findElement(By.id("rut"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        rutField.sendKeys(rut);
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
    }

    @Then("Estoy viendo la página de bienvenida")
    public void iShouldSeeAWelcomeMessage() {
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assertNotNull(welcomeMessage);
        driver.quit();
    }

    @Then("Estoy viendo el mensaje de error")
    public void iShouldSeeAnErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertNotNull(errorMessage);
        driver.quit();
    }
}
