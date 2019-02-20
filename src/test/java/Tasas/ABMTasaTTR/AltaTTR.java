package Tasas.ABMTasaTTR;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaTTR {
	
	public void crearTTR(WebDriver driver, WebDriverWait wait, String subtasa) throws InterruptedException{    
    
		/*             Alta de TTR         */
   
	    	//espera a que exista y cliquea sobre el boton para generar una nueva Tasa TTR
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			driver.findElement(By.id("addTransferenceRate")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva tasa TTR
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptarAlta")));
		    Select dador = new Select(driver.findElement(By.id("empresaAlta")));
		    waitCuore.repitedCampos(driver, wait, "2", dador, "value");
		    Select tipoTasa = new Select(driver.findElement(By.id("tipoTasaAlta")));
		    waitCuore.repitedCampos(driver, wait, "1", tipoTasa, "value");
		    Select subTasa = new Select(driver.findElement(By.id("subTipoTasaAlta")));
		    waitCuore.repitedCampos(driver, wait, subtasa, subTasa, "text");
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/ttr-search/ttr-modal/div/div/form/div[2]/div/div[2]/field-validator/div/grid-simple-view/div/div/div[1]/div[2]/div/div/span/a")).click();
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/ttr-search/ttr-modal/div/div/form/div[2]/div/div[2]/field-validator/div/grid-simple-view/div/div/div[1]/div[2]/div/div/span/a")).click();
		    driver.findElement(By.id("halfLife0Alta")).sendKeys("1");
		    driver.findElement(By.id("interest0Alta")).sendKeys("1");
		    driver.findElement(By.id("halfLife1Alta")).sendKeys("100");
		    driver.findElement(By.id("interest1Alta")).sendKeys("100");
		    driver.findElement(By.id("aceptarAlta")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
	}
}