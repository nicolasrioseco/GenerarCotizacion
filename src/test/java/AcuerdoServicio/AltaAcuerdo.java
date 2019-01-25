package AcuerdoServicio;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaAcuerdo {
	
	public void crearAcuerdo(WebDriver driver, WebDriverWait wait, String docProv, String fechaDesde, 
			String fechaHasta, String version, String acuerdo, String precioAcuerdo, String markUpAcuerdo) throws InterruptedException{    
    
		/*             Alta de Proveedor         */
    
	    	//espera a que exista y cliquea sobre el boton para generar un nuevo Proveedor
		    driver.findElement(By.id("undefined")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Proveedor
		    Thread.sleep(2000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("spplierSearch")));
		    driver.findElement(By.id("supplierDocNumberSearch")).sendKeys(docProv);
		    driver.findElement(By.id("spplierSearch")).click();
		    Thread.sleep(6000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'" + docProv + "')]")));
		    driver.findElement(By.xpath("//td[contains(text(),'" + docProv + "')]")).click();
		    driver.findElement(By.id("supplierAccept")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nomberAcuerdoAltaAcuerdos")));
		    driver.findElement(By.id("nomberAcuerdoAltaAcuerdos")).sendKeys(acuerdo);
		    driver.findElement(By.id("vigenciaDesdeAltaAcuerdos_input")).sendKeys(fechaDesde);
		    driver.findElement(By.id("vigenciaHastaAltaAcuerdos_input")).sendKeys(fechaHasta + "/2020");
		    Select periodicidad = new Select(driver.findElement(By.id("periodicidadAltaAcuerdos")));
		    periodicidad.selectByValue("2");
		    driver.findElement(By.id("serviceAgreementAddGoods")).click();
		    Thread.sleep(4000);
		    driver.findElement(By.id("searchGoodAddGood")).click();
		    driver.findElement(By.id("nombreSearch")).sendKeys(version);
		    driver.findElement(By.id("searchGood")).click();
		    Thread.sleep(4000);
		    driver.findElement(By.id("checkall")).click();
		    driver.findElement(By.id("searchGoodDefineGoodConfirmation")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(4000);
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
		    Thread.sleep(4000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(5000);			
	}
}