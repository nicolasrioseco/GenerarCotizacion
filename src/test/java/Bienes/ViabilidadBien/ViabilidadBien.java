package Bienes.ViabilidadBien;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class ViabilidadBien {
	
	public void viabilidadBien(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al Viabilidad del Bien         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"router_container\"]/app-analisis-bien/analizar-viabilidad-bien/form/div/div/div/div/button[3]")));
	    Select resolucionViabilidad = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_action')]")));
	    waitCuore.repitedCampos(driver, wait, "3", resolucionViabilidad, "value");
	    driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("Viabilidad Automatizado QA");
	    driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-analisis-bien/analizar-viabilidad-bien/form/div/div/div/div/button[3]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    driver.findElement(By.id("focusElement")).click();
	    //String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).getText());
	    System.out.println("El Bien se habilitó correctamente");
	    //driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).click();
	    
	}
}