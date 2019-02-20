package Tasas.ABMTasaVariable;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaTasaVar {
	
	public void crearTasaVar(WebDriver driver, WebDriverWait wait, String subtasa, String interes) throws InterruptedException{    
    
		/*             Alta de Tasas         */
    
	    	//espera a que exista y cliquea sobre el boton para generar una nueva Tasa
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			driver.findElement(By.id("addRate")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva tasa
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptar")));
		    Select tipoTasa = new Select(driver.findElement(By.id("subTasaAlta")));
		    waitCuore.repitedCampos(driver, wait, subtasa, tipoTasa, "text");
		    Thread.sleep(1000);
		    driver.findElement(By.id("interesAlta")).sendKeys(interes);
		    driver.findElement(By.id("aceptar")).click();
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
	}
}