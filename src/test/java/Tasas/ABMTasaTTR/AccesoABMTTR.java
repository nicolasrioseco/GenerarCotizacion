package Tasas.ABMTasaTTR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccesoABMTTR {
	
	public void abmTTR(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al ABM Tasas         */
    
    
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    Thread.sleep(7000);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Finanzas
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuFinanzas")));
	    driver.findElement(By.id("subMenuFinanzas")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de Tasa TTR
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuTasasTTR")));
	    driver.findElement(By.id("menuTasasTTR")).click();
	    Thread.sleep(5000);
	}
}