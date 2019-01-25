package Bienes.Clase;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaClase {
	
	public void crearClase(WebDriver driver, WebDriverWait wait, int claseItems, String clase) throws InterruptedException{    
    
		/*             Alta de Clase         */
    
		if (claseItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar una Clase
		    driver.findElement(By.id("addClass")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva Clase
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreAltaClase")));
		    driver.findElement(By.id("nombreAltaClase")).sendKeys(clase);
		    driver.findElement(By.id("descripcionAltaClase")).sendKeys("Descripción" + clase);
		    driver.findElement(By.id("guardarSalirAltaClase")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    String claseCreada = new String (driver.findElement(By.xpath("//div[contains(text(),'Se ha creado correctamente la Clase')]")).getText());
		    assertEquals("Se ha creado correctamente la Clase", claseCreada);
		    System.out.println("Se creó correctamente la clase " + clase);
		}else
			System.out.println("Ya existía la clase " + clase);
	}
}