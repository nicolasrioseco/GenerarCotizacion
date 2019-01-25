package Cotizador;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscarCotizacion {
	
	public void buscarCotizacion(WebDriver driver, WebDriverWait wait, String operacion) throws InterruptedException{    
    
		/*       Buscar Operación y acceder         */
	    driver.findElement(By.id("idPricingOperation")).sendKeys("200");
	    Thread.sleep(1000);
	    driver.findElement(By.id("idPricingOperation")).sendKeys(operacion);
	    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[4]/div/div/button[2]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, 'Visualizar')]")));
	    driver.findElement(By.xpath("//*[contains(@title, 'Visualizar')]")).click();
	}
}