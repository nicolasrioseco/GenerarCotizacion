package Cotizador;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BuscarCotizacion {
	
	public String buscarCotizacion(WebDriver driver, WebDriverWait wait, String operacion) throws InterruptedException{    
    
		/*       Buscar Operación        */
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idPricingOperation")));
	    driver.findElement(By.id("idPricingOperation")).sendKeys("200");
	    Thread.sleep(1000);
	    driver.findElement(By.id("idPricingOperation")).sendKeys(operacion);
	    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[4]/div/div/button[2]")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String cotizacion = driver.findElement(By.xpath("//*[@id=\"rowColumn\"]/td[2]")).getText();
	    return cotizacion;
	}
}