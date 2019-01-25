package Servicios;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AprobarServicio {
	
	public void aprobarServicio(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
	/*             Acceso a la Aprobación de Servicio         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("finishTask")));
	    Select resolucion = new Select(driver.findElement(By.id("taskAction")));
	    resolucion.selectByValue("11");
	    driver.findElement(By.id("taskObservacions")).sendKeys("Aprobar Servicio Automatizado QA");
	    driver.findElement(By.id("finishTask")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    Thread.sleep(1000);
	    driver.findElement(By.id("focusElement")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'Se pudo habilitar el Servicio correctamente')]")).getText());
	    //driver.findElement(By.xpath("//div[contains(text(),'Se pudo habilitar el Servicio correctamente')]")).click();
	    System.out.println(mensaje);
	    Thread.sleep(5000);
	}
}