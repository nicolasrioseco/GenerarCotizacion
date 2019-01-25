package Producto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccesoProducto {
	
	public void abmProducto(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al ABM de Productos         */
    
    
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    Thread.sleep(7000);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Productos
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuProductos")));
	    driver.findElement(By.id("subMenuProductos")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de Productos
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuProductos")));
	    driver.findElement(By.id("menuProductos")).click();
	    Thread.sleep(5000);
	}
}