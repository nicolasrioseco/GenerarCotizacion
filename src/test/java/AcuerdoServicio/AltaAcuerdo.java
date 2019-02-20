package AcuerdoServicio;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaAcuerdo {
	
	public void crearAcuerdo(WebDriver driver, WebDriverWait wait, String docProv, String fechaDesde, 
			String fechaHasta, String clase, String subclase, String acuerdo, String precioAcuerdo, String markUpAcuerdo) throws Exception{    
    
		/*             Alta de Proveedor         */
    
	    	//espera a que exista y cliquea sobre el boton para generar un nuevo Proveedor
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    driver.findElement(By.id("undefined")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Proveedor
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("spplierSearch")));
		    driver.findElement(By.id("supplierDocNumberSearch")).sendKeys(docProv);
		    driver.findElement(By.id("spplierSearch")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'" + docProv + "')]")));
		    driver.findElement(By.xpath("//td[contains(text(),'" + docProv + "')]")).click();
		    driver.findElement(By.id("supplierAccept")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nomberAcuerdoAltaAcuerdos")));
		    driver.findElement(By.id("nomberAcuerdoAltaAcuerdos")).sendKeys(acuerdo);
		    driver.findElement(By.id("vigenciaDesdeAltaAcuerdos_input")).click();
		    driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
		    driver.findElement(By.id("vigenciaHastaAltaAcuerdos_input")).click();
		    driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
		    driver.findElement(By.id("vigenciaHastaAltaAcuerdos_input")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE + "20");
		    driver.findElement(By.xpath("//td[contains(@class, 'active')]")).click();
		    Select periodicidad = new Select(driver.findElement(By.id("periodicidadAltaAcuerdos")));
		    waitCuore.repitedCampos(driver, wait, "2", periodicidad, "value");
		    driver.findElement(By.id("serviceAgreementAddGoods")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchGoodCancelConfirmation")));
		    driver.findElement(By.id("searchGoodDefineGrouper")).click();
		    Thread.sleep(2000);
		    Select claseAgrup = new Select(driver.findElement(By.id("searchGoodClass")));
		    waitCuore.repitedCampos(driver, wait, clase, claseAgrup, "text");
		    Thread.sleep(5000);
			waitCuore.repited(driver, wait);
		    Select subclaseAgrup = new Select(driver.findElement(By.id("searchGoodSubClass")));
		    waitCuore.repitedCampos(driver, wait, subclase, subclaseAgrup, "text");
		    Thread.sleep(5000);
		    driver.findElement(By.id("searchGoodDefineGroupConfirmation")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(4000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("unitaryPriceGoodAltaAcuerdo0")).sendKeys(precioAcuerdo);
		    Thread.sleep(2000);
		    driver.findElement(By.id("facturacionAltaAcuerdos")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("markUpUnificadoAltaAcuerdos")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("valorFijoPrecioUnitarioAltaAcuerdos")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("markUpAltaAcuerdos")).sendKeys(markUpAcuerdo);
		    driver.findElement(By.id("observacionesAltaAcuerdos")).sendKeys("Acuerdo Automatizado QA");
			driver.findElement(By.id("enviarAltaAcuerdos")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
	}
}