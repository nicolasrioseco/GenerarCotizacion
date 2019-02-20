package Tasas.ABMTasaTTR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AccesoABMTTR {
	
	public void abmTTR(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al ABM Tasas TTR        */
    
    
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Thread.sleep(5000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    waitCuore.repited(driver, wait);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Finanzas
	    waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuFinanzas")));
	    driver.findElement(By.id("subMenuFinanzas")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de Tasa TTR
	    waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuTasasTTR")));
	    driver.findElement(By.id("menuTasasTTR")).click();
	}
}