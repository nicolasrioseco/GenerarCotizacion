package Bienes.Modelo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaModelo {
	
	public int buscarModelo(WebDriver driver, WebDriverWait wait, String modelo) throws InterruptedException{    
    
		int modeloItems;
		
		/*             Búsqueda de Modelos         */
    
	    //Buscar Modelo QA
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreBusquedaModelo")));
	    driver.findElement(By.id("nombreBusquedaModelo")).sendKeys(modelo);
	    driver.findElement(By.id("buscarBusquedaModelo")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
			modeloItems = Integer.parseInt(resultadoParcial[0]);
		}else
			modeloItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return modeloItems;
	}
}