package Bienes.Atributo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaAtributos {
	
	public int buscarAtributo(WebDriver driver, WebDriverWait wait, String atributo) throws InterruptedException{    
		
		int atributoItems;
		
		/*             Búsqueda de Atributos         */
    
	    //Buscar Atributo QA
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreAtributoBusquedaAtributos")));
		driver.findElement(By.id("nombreAtributoBusquedaAtributos")).sendKeys(atributo);
	    driver.findElement(By.id("buscarBusquedaAtributos")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	atributoItems = Integer.parseInt(resultadoParcial[0]);
		}else
			atributoItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return atributoItems;
	}
}