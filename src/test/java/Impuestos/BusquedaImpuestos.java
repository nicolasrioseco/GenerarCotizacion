package Impuestos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaImpuestos {
	
	public int buscarImpuesto(WebDriver driver, WebDriverWait wait, String provincia) throws InterruptedException{    
		
		int impuestoItems;
		
		/*             Búsqueda de Impuestos         */
    
	    //Buscar Atributo QA
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("busqueda")));
		Select selectProv = new Select(driver.findElement(By.id("provinceBusqueda")));
		selectProv.selectByVisibleText(provincia);
	    Select estado = new Select(driver.findElement(By.id("statusBusqueda")));
	    estado.selectByVisibleText("Alta");
	    driver.findElement(By.id("busqueda")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	impuestoItems = Integer.parseInt(resultadoParcial[0]);
		}else
			impuestoItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return impuestoItems;
	}
}