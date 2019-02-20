package Cotizador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AccesoCotizador {
	
	public void abmCotizador(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
    /*             Acceso al Cotizador         */
    
    
    //espera a que exista y cliquea sobre el boton de la sección Cotizacion
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuComercial")));
		waitCuore.repited(driver, wait);
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.cssSelector(".img-comercial.menu-icon")).click();
		//espera a que exista y cliquea sobre el boton para acceder a la sección Cotizacion
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCotizaciones")));
		driver.findElement(By.id("menuCotizaciones")).click();
		Thread.sleep(2000);
	}
}