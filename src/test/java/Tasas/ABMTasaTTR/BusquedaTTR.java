package Tasas.ABMTasaTTR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaTTR {
	
	public int buscarTTR(WebDriver driver, WebDriverWait wait, String subtasa) throws InterruptedException{    
		
		int tasaItems;
		
		/*             Búsqueda de tasa TTR         */
    
	    //Buscar TTR QA
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("busqueda")));
	    Select tipoTasa = new Select(driver.findElement(By.id("tipoTasaBusqueda")));
	    tipoTasa.selectByValue("1");
	    Thread.sleep(7000);
		waitCuore.repited(driver, wait);
	    Select dador = new Select(driver.findElement(By.id("subTipoTasaBusqueda")));
	    dador.selectByVisibleText(subtasa);
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