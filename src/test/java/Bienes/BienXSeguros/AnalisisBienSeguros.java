package Bienes.BienXSeguros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AnalisisBienSeguros {
	
	public void analisisBienSeguros(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Activos         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("textArea")));
	    Select resolucionSeguros = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_insuranceResolution')]")));
	    waitCuore.repitedCampos(driver, wait, "1", resolucionSeguros, "value");
	    driver.findElement(By.id("textArea")).sendKeys("Analisis Seguros Automatizado QA");
	    driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-analisis-bien/analizar-bien-seguro/form/div/div/div/div/button[3]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    driver.findElement(By.id("focusElement")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    System.out.println("El Análisis por Seguros se ha finalizado correctamente");
	    //driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).click();
	    
	}
}