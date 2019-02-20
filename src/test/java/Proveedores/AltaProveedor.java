package Proveedores;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaProveedor {
	
	public void crearProveedor(WebDriver driver, WebDriverWait wait, String nombreProv, String docProv) throws InterruptedException{    
    
		/*             Alta de Proveedor         */
 
	    	//espera a que exista y cliquea sobre el boton para generar un nuevo Proveedor
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("addProvider")));
			driver.findElement(By.id("addProvider")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Proveedor
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("guardadrSalirAltaProveedor")));
		    driver.findElement(By.id("nombreAltaProveedor")).sendKeys(nombreProv);
		    Select tipoDocProv = new Select(driver.findElement(By.id("tipoDocumentoAltaProveedor")));
		    waitCuore.repitedCampos(driver, wait, "12", tipoDocProv, "value");
		    driver.findElement(By.id("numeroDocumentoCuilCuitAltaProveedor")).sendKeys(docProv);
		    driver.findElement(By.id("actividadAltaProveedor")).sendKeys("Fabricación de Bienes QA");
		    driver.findElement(By.id("serviciosAltaProveedor")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("bienesAltaProveedor")).click();
		    Thread.sleep(2000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("importacionAltaProveedor")).click();
			Select ranking = new Select(driver.findElement(By.id("rankingAltaProveedor")));
			waitCuore.repitedCampos(driver, wait, "1", ranking, "value");
			driver.findElement(By.id("ingresosAltaProveedor")).sendKeys("9000000");
			driver.findElement(By.id("observacionesAltaProveedor")).sendKeys("Proveedor Automatizado QA");
			driver.findElement(By.id("nombreContactoAltaProveedor")).sendKeys("Jose QA");
			driver.findElement(By.id("puestoContactoAltaProveedor")).sendKeys("Calidad");
			driver.findElement(By.id("telefonoContactoAltaProveedor")).sendKeys(Keys.SPACE + "1145592233");
			driver.findElement(By.id("telefonoContactoAltaProveedor")).sendKeys("1145592233");
			driver.findElement(By.id("celularContactoAltaProveedor")).sendKeys(Keys.SPACE + "1145592233");
			driver.findElement(By.id("celularContactoAltaProveedor")).sendKeys("1145592233");
			driver.findElement(By.id("emailContactoAltaProveedor")).sendKeys("automatizacionqa@comafi.com");
			Select pais = new Select(driver.findElement(By.id("paisAltaProveedor")));
			waitCuore.repitedCampos(driver, wait, "80", pais, "value");
			Select provincia = new Select(driver.findElement(By.id("provinciaAltaProveedor")));
			waitCuore.repitedCampos(driver, wait, "80000", provincia, "value");
			Select localidad = new Select(driver.findElement(By.id("localidadAltaProveedor")));
			waitCuore.repitedCampos(driver, wait, "1385", localidad, "value");
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			driver.findElement(By.id("calleAltaProveedor")).sendKeys("Reconquista");
			driver.findElement(By.id("numeroAltaProveedor")).sendKeys("823");
			driver.findElement(By.id("pisoAltaProveedor")).sendKeys("3");
			driver.findElement(By.id("departamentoAltaProveedor")).sendKeys("A");
			driver.findElement(By.id("codigoPostalAltaProveedor")).sendKeys("1003");
			driver.findElement(By.id("guardadrSalirAltaProveedor")).click();
		    Thread.sleep(2000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
		    driver.findElement(By.id("focusElement")).click();
	}
}