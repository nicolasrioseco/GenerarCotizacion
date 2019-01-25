package Servicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaServicio {
	
	public int buscarServicio(WebDriver driver, String servicio) throws InterruptedException{    
		
		int cantItems;
		
		/*             Búsqueda de Servicio         */
    
	    //Buscar Servicio QA
	    driver.findElement(By.id("inputDefault")).sendKeys(servicio);
	    driver.findElement(By.id("searchService")).click();
	    Thread.sleep(6000);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	cantItems = Integer.parseInt(resultadoParcial[0]);
		}else
			cantItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return cantItems;
	}
}