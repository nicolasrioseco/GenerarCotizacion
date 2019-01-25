package Proveedores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaProveedor {
	
	public int buscarProveedor(WebDriver driver, String docProveedor) throws InterruptedException{    
		
		int cantItems;
		
		/*             Búsqueda de Proveedores         */
    
	    //Buscar Atributo QA
	    driver.findElement(By.id("documentoBusquedaProveedores")).sendKeys(docProveedor);
	    driver.findElement(By.id("buscarBusquedaProveedores")).click();
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