package Impuestos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AccesoImpuestos {
	
	public void accesoImpuesto(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
	    
		/*             Acceso al ABM Impuestos         */
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    waitCuore.repited(driver, wait);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Finanzas
	    waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuFinanzas")));
	    driver.findElement(By.id("subMenuFinanzas")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de Impuestos
	    waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuImpuestos")));
	    driver.findElement(By.id("menuImpuestos")).click();
	}
}