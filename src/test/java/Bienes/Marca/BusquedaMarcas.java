package Bienes.Marca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaMarcas {
	
	public int buscarMarca(WebDriver driver, WebDriverWait wait, String marca) throws InterruptedException{    
    
		int marcaItems;
		
		/*             Búsqueda de Marca         */
    
	    //Buscar Marca QA
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("buscarBusquedaMarca")));
	    driver.findElement(By.id("nombreMarcaBusquedaMarca")).sendKeys(marca);
	    driver.findElement(By.id("buscarBusquedaMarca")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	marcaItems = Integer.parseInt(resultadoParcial[0]);
		}else
			marcaItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return marcaItems;
	}
}