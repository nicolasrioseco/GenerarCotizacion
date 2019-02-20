package Producto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AprobarProducto {
	
	public void aprobarProducto(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
	/*             Acceso a la Aprobación de Producto         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(10000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("finishTask")));
	    Select resolucion = new Select(driver.findElement(By.id("taskAction")));
	    waitCuore.repitedCampos(driver, wait, "11", resolucion, "value");
	    driver.findElement(By.id("taskObservacions")).sendKeys("Aprobar Producto Automatizado QA");
	    waitCuore.repited(driver, wait);
	    driver.findElement(By.id("finishTask")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    driver.findElement(By.id("focusElement")).click();
	    //driver.findElement(By.xpath("//div[contains(text(),'Se pudo habilitar el Servicio correctamente')]")).click();
	    System.out.println("Se pudo habilitar el Producto correctamente"); 
	}
}