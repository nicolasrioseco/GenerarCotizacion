package Servicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaServicio {
	
	public int buscarServicio(WebDriver driver, String servicio, WebDriverWait wait) throws InterruptedException{    
		
		int cantItems;
		
		/*             Búsqueda de Servicio         */
    
	    //Buscar Servicio QA
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("inputDefault")));
	    driver.findElement(By.id("inputDefault")).sendKeys(servicio);
	    driver.findElement(By.id("searchService")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	cantItems = Integer.parseInt(resultadoParcial[0]);
		}else
			cantItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return cantItems;
	}
}