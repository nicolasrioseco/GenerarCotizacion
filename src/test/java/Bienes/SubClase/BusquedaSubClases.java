package Bienes.SubClase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaSubClases {
	
	public int buscarSubClase(WebDriver driver, WebDriverWait wait, String subclase) throws InterruptedException{    
    
		int subclaseItems;
		
		/*             Búsqueda de SubClase         */
    
	    //Buscar SubClase QA
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreSubclaseBusquedaSubClase")));
	    driver.findElement(By.id("nombreSubclaseBusquedaSubClase")).sendKeys(subclase);
	    driver.findElement(By.id("buscarBusquedaSubClase")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	subclaseItems = Integer.parseInt(resultadoParcial[0]);
		}else
			subclaseItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return subclaseItems;
	}
}