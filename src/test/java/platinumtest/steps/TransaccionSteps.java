package platinumtest.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class TransaccionSteps {
    WebDriver driver;

    @Given("Estoy abriendo la página de la transacción")
    public void iOpenTheTransactionPage() {
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
        driver.get("http://localhost:8080/bancoplatinum/transferenciaexitosa.jsp?rutOrigen=161111111&cuentaDestino=336633&monto=111");
    }

    @When("Estoy viendo el detalle de una transacción")
    public void iEnterTheTransactionDetails() {
        System.out.println("La página muestra detalles de la transacción desde la URL proporcionada.");
    }

    @Then("Estoy guardando la hora de la transacción")
    public void theTransactionShouldBeRecordedWithTheCorrectTime() {
        WebElement transactionTime = driver.findElement(By.id("transactionTime"));
        assertNotNull(transactionTime);
        System.out.println("Hora de la transacción: " + transactionTime.getText());
        driver.quit();
    }
}
