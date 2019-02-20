package Bienes.Clase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaClase {
	
	public void crearClase(WebDriver driver, WebDriverWait wait, String clase) throws InterruptedException{    
    
		/*             Alta de Clase         */
    
	    	//espera a que exista y cliquea sobre el boton para generar una Clase
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("addClass")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva Clase
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreAltaClase")));
		    driver.findElement(By.id("nombreAltaClase")).sendKeys(clase);
		    driver.findElement(By.id("descripcionAltaClase")).sendKeys("Descripción" + clase);
		    driver.findElement(By.id("guardarSalirAltaClase")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    System.out.println("Se creó correctamente la clase " + clase);
	}
}