package Tasas.ABMTasaVariable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaTasaVar {
	
	public int buscarTasaVar(WebDriver driver, String subtasa, WebDriverWait wait) throws InterruptedException{    
		
		int tasaItems;
		
		/*             Búsqueda de Tasa Variable         */
    
	    //Buscar Atributo QA
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("busqueda")));
		Select estado = new Select(driver.findElement(By.id("estadoBusqueda")));
	    estado.selectByVisibleText("Alta");
	    Thread.sleep(4000);
	    Select subtasaVar = new Select(driver.findElement(By.id("subTipoTasaBusqueda")));
	    subtasaVar.selectByVisibleText(subtasa);
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