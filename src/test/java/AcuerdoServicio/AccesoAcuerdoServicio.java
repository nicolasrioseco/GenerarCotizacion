package AcuerdoServicio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccesoAcuerdoServicio {
	
	public void abmAcuerdoServicio(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al ABM de Acuerdos de Servicios         */
    
    
	    //espera a que exista y cliquea sobre el boton de la sección de Configuraciones
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuConfiguracion")));
	    Thread.sleep(9000);
	    driver.findElement(By.id("mainMenuConfiguracion")).click();
	    //espera a que exista y cliquea sobre el boton para desplegar las opciones de Proveedores
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("subMenuProveedores")));
	    driver.findElement(By.id("subMenuProveedores")).click();
	    Thread.sleep(1000);
	    //espera a que exista y cliquea sobre el boton para acceder al ABM de Acuerdo de Servicios
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuAcuerdos")));
	    driver.findElement(By.id("menuAcuerdos")).click();
	    Thread.sleep(5000);
	}
}