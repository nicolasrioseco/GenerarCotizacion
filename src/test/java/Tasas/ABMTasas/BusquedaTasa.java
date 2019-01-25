package Tasas.ABMTasas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaTasa {
	
	public int buscarTasa(WebDriver driver, String subtasa) throws InterruptedException{    
		
		int tasaItems;
		
		/*             Búsqueda de Atributos         */
    
	    //Buscar Atributo QA
	    driver.findElement(By.id("inputDefault")).sendKeys(subtasa);
	    driver.findElement(By.id("busqueda")).click();
	    //new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinnerLayerLoader")));
	    Thread.sleep(18000);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	tasaItems = Integer.parseInt(resultadoParcial[0]);
		}else
			tasaItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return tasaItems;
	}
}