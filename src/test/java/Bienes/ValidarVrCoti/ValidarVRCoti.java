package Bienes.ValidarVrCoti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class ValidarVRCoti {
	
	public void validarVRCoti(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso a la tarea Validar VR Cotización        */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseHeaderCotizacion\"]/div/div/div[2]/span/a")));
	    driver.findElement(By.id("vrQuoteVRValue0")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("vrQuoteVRValue0")).sendKeys("40");
	    Thread.sleep(1000);
	    driver.findElement(By.id("vrQuoteVRValue1")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("vrQuoteVRValue1")).sendKeys("40");
	    waitCuore.repited(driver, wait);
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select resolucion = new Select(driver.findElement(By.id("taskAction")));
		waitCuore.repitedCampos(driver, wait, "Aprobar", resolucion, "text");
		driver.findElement(By.id("taskObservacions")).sendKeys("Validar VR Cotización Automatizado");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("finishTask")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    System.out.println("Se asignaron correctamente los nuevos VR");
	}
}