package Bienes.Clase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaClases {
	
	public int buscarClase(WebDriver driver, WebDriverWait wait, String clase) throws InterruptedException{    
    
		int claseItems;
		
		/*             Búsqueda de Clases         */
    
	    //Buscar Clase QA
	    driver.findElement(By.id("NombreBusquedaClase")).sendKeys(clase);
	    driver.findElement(By.id("buscarBusquedaClase")).click();
	    Thread.sleep(6000);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
			claseItems = Integer.parseInt(resultadoParcial[0]);
		}else
    		claseItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return claseItems;
	}
}