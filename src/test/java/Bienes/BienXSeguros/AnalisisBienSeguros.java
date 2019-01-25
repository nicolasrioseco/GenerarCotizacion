package Bienes.BienXSeguros;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalisisBienSeguros {
	
	public void analisisBienSeguros(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Activos         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    Thread.sleep(4000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("textArea")));
	    Select resolucionSeguros = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_insuranceResolution')]")));
	    resolucionSeguros.selectByValue("1");
	    driver.findElement(By.id("textArea")).sendKeys("Analisis Seguros Automatizado QA");
	    driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-analisis-bien/analizar-bien-seguro/form/div/div/div/div/button[3]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    Thread.sleep(1000);
	    driver.findElement(By.id("focusElement")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).getText());
	    System.out.println(mensaje);
	    Thread.sleep(7000);
	    //driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).click();
	    
	}
}