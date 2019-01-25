package Proveedores;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaProveedor {
	
	public void crearProveedor(WebDriver driver, WebDriverWait wait, int cantItems, String nombreProv, String docProv) throws InterruptedException{    
    
		/*             Alta de Proveedor         */
    
		if (cantItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar un nuevo Proveedor
		    Thread.sleep(5000);
			driver.findElement(By.id("addProvider")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Proveedor
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("guardadrSalirAltaProveedor")));
		    driver.findElement(By.id("nombreAltaProveedor")).sendKeys(nombreProv);
		    Select tipoDocProv = new Select(driver.findElement(By.id("tipoDocumentoAltaProveedor")));
		    tipoDocProv.selectByValue("12");
		    driver.findElement(By.id("numeroDocumentoCuilCuitAltaProveedor")).sendKeys(docProv);
		    driver.findElement(By.id("actividadAltaProveedor")).sendKeys("Fabricación de Bienes QA");
		    driver.findElement(By.id("serviciosAltaProveedor")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("bienesAltaProveedor")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("importacionAltaProveedor")).click();
			Select ranking = new Select(driver.findElement(By.id("rankingAltaProveedor")));
			ranking.selectByValue("1");
			driver.findElement(By.id("ingresosAltaProveedor")).sendKeys("9000000");
			driver.findElement(By.id("observacionesAltaProveedor")).sendKeys("Proveedor Automatizado QA");
			driver.findElement(By.id("nombreContactoAltaProveedor")).sendKeys("Jose QA");
			driver.findElement(By.id("puestoContactoAltaProveedor")).sendKeys("Calidad");
			driver.findElement(By.id("telefonoContactoAltaProveedor")).sendKeys("01145592233");
			driver.findElement(By.id("celularContactoAltaProveedor")).sendKeys("0111545592233");
			driver.findElement(By.id("emailContactoAltaProveedor")).sendKeys("automatizacionqa@comafi.com");
			Select pais = new Select(driver.findElement(By.id("paisAltaProveedor")));
			pais.selectByValue("80");
			Thread.sleep(3000);
			Select provincia = new Select(driver.findElement(By.id("provinciaAltaProveedor")));
			provincia.selectByValue("80000");
			Thread.sleep(5000);
			Select localidad = new Select(driver.findElement(By.id("localidadAltaProveedor")));
			localidad.selectByValue("1385");
			Thread.sleep(3000);
			driver.findElement(By.id("calleAltaProveedor")).sendKeys("Reconquista");
			driver.findElement(By.id("numeroAltaProveedor")).sendKeys("823");
			driver.findElement(By.id("pisoAltaProveedor")).sendKeys("3");
			driver.findElement(By.id("departamentoAltaProveedor")).sendKeys("A");
			driver.findElement(By.id("codigoPostalAltaProveedor")).sendKeys("1003");
			driver.findElement(By.id("guardadrSalirAltaProveedor")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(6000);
		}else
			System.out.println("Ya existía el proveedor " + nombreProv);
	}
}