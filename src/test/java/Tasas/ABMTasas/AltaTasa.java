package Tasas.ABMTasas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaTasa {
	
	public void crearTasa(WebDriver driver, WebDriverWait wait, String subtasa) throws InterruptedException{    
    
		/*             Alta de Tasas         */
    
	    	//espera a que exista y cliquea sobre el boton para generar una nueva Tasa
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			driver.findElement(By.id("addRate")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva tasa
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptar")));
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    Select tipoTasa = new Select(driver.findElement(By.id("tipoTasaAlta")));
		    waitCuore.repitedCampos(driver, wait, "Fija", tipoTasa, "text");
		    Select moneda = new Select(driver.findElement(By.id("monedaAlta")));
		    waitCuore.repitedCampos(driver, wait, "1000", moneda, "value");
		    Thread.sleep(1000);
		    driver.findElement(By.id("subTasaAlta")).sendKeys(subtasa);
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("aceptar")).click();
			Thread.sleep(3000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
	}
}