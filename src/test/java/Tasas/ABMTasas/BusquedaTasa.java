package Tasas.ABMTasas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaTasa {
	
	public int buscarTasa(WebDriver driver, String subtasa, WebDriverWait wait) throws InterruptedException{    
		
		int tasaItems;
		
		/*             Búsqueda de Atributos         */
    
	    //Buscar Atributo QA
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("inputDefault")));
	    driver.findElement(By.id("inputDefault")).sendKeys(subtasa);
	    driver.findElement(By.id("busqueda")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	tasaItems = Integer.parseInt(resultadoParcial[0]);
		}else
			tasaItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return tasaItems;
	}
}