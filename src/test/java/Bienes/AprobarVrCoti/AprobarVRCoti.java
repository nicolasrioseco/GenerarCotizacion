package Bienes.AprobarVrCoti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AprobarVRCoti {
	
	public void aprobarVRCoti(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Activos         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseHeaderCotizacion\"]/div/div/div[2]/span/a")));
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select resolucion = new Select(driver.findElement(By.id("taskAction")));
		waitCuore.repitedCampos(driver, wait, "Aprobar", resolucion, "text");
		driver.findElement(By.id("taskObservacions")).sendKeys("Aprobar VR Cotización Automatizado");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("finishTask")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    System.out.println("Se aprobaron correctamente los nuevos VR");
	}
}