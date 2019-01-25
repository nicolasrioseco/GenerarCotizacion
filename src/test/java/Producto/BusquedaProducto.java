package Producto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaProducto {
	
	public int buscarProducto(WebDriver driver, String producto) throws InterruptedException{    
		
		int cantItems;
		
		/*             Búsqueda de Producto         */
    
	    //Buscar Producto QA
	    driver.findElement(By.id("productName")).sendKeys(producto);
	    driver.findElement(By.id("aceptarBusqueda")).click();
	    Thread.sleep(6000);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	cantItems = Integer.parseInt(resultadoParcial[0]);
		}else
			cantItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return cantItems;
	}
}