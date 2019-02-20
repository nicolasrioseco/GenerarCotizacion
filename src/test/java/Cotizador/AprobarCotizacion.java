package Cotizador;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AprobarCotizacion {
	
	public void aprobarCotizacion(WebDriver driver, WebDriverWait wait, String operacion) throws InterruptedException, IOException{    
    
   
	    /*      Aprobar Operación        */
	    waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, 'Visualizar')]")));
	    driver.findElement(By.xpath("//*[contains(@title, 'Visualizar')]")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Operación")));
	    driver.findElement(By.partialLinkText("Operación")).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"operacionTab\"]/app-evaluar-cotizacion/div/div[3]/div/button")));
	   	driver.findElement(By.className("checkbox-checkmark")).click();
	   	driver.findElement(By.xpath("//*[@id=\"operacionTab\"]/app-evaluar-cotizacion/div/div[2]/div/div/div/div[3]/button[2]")).click();
	   	Thread.sleep(3000);
	}
}