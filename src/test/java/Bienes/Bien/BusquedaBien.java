package Bienes.Bien;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BusquedaBien {
	
	public int buscarBien(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException{    
    
		int bienItems;
		
		/*             Búsqueda de Bienes         */
    
	    //Buscar Modelo QA
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreSearch")));
	    driver.findElement(By.id("nombreSearch")).sendKeys(version);
	    driver.findElement(By.id("BuscarBusquedaBienes")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	bienItems = Integer.parseInt(resultadoParcial[0]);
			System.out.println("No se encontraron resultados para la búsqueda realizada");
		}else{
			bienItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    	String estado = driver.findElement(By.xpath("//*[@id=\"rowColumn\"]/td[6]")).getText();
			System.out.println("Se encontró " + bienItems + " ítems con la misma descripción buscada");
	    	System.out.println("El estado del bien buscado es: " + estado);}
	    return bienItems;
	}
}