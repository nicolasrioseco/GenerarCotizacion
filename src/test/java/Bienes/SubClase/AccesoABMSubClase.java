package Bienes.SubClase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccesoABMSubClase {
	
	public void abmSubClase(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al ABM SubClases         */
    
    
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    Thread.sleep(7000);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Bienes
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuBienes")));
	    driver.findElement(By.id("subMenuBienes")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de SubClases
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuSubCalses")));
	    driver.findElement(By.id("menuSubCalses")).click();
	    Thread.sleep(5000);
	}
}