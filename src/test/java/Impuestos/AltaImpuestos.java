package Impuestos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaImpuestos {
	
	public void configImpuesto(WebDriver driver, WebDriverWait wait, String provincia, String porcentajeImpoGral) throws InterruptedException{    
    
		/*             Alta de Atributos         */
    
	    	//espera a que exista y cliquea sobre el boton para generar un Atributo
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
			driver.findElement(By.id("addTax")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo atributo
			Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptarJusrisdiccion")));
		    Select selectProv = new Select(driver.findElement(By.id("provinceItem")));
		    waitCuore.repitedCampos(driver, wait, provincia, selectProv, "text");
			driver.findElement(By.id("aceptarJusrisdiccion")).click();
			Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	    	Select dador = new Select(driver.findElement(By.id("lessorsBusqueda")));
	    	waitCuore.repitedCampos(driver, wait, "COMAFI", dador, "text");
	    	driver.findElement(By.xpath("//a[contains(@title, 'Agregar')]")).click();
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	    	driver.findElement(By.id("checkModal")).click();
	    	driver.findElement(By.id("saveConcepts")).click();
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	    	Select tipoAlicuota = new Select(driver.findElement(By.id("sealTaxTypeAliquot0")));
	    	waitCuore.repitedCampos(driver, wait, "General", tipoAlicuota, "text");
	    	driver.findElement(By.id("sealTaxAliquotIGeneral0")).sendKeys(porcentajeImpoGral);
	    	driver.findElement(By.id("sealTaxAmountperSheet0")).sendKeys("25");
	    	driver.findElement(By.id("sealTaxAliquotIGeneral0")).sendKeys("150");
	    	driver.findElement(By.id("aceptarAlta")).click();
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	    	driver.findElement(By.id("focusElement")).click();
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    System.out.println("Se creó configuró correctamente el impuesto de la provincia de " + provincia);
	}
}