package Bienes.Marca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaMarca {
	
	public void crearMarca(WebDriver driver, WebDriverWait wait, String clase, String subclase, String marca) throws InterruptedException{    
    
		/*             Alta de SubClase         */

	    	//espera a que exista y cliquea sobre el boton para generar una SubClase
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    driver.findElement(By.id("addBrand")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva SubClase
		    Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	    	Thread.sleep(3000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete_picker_marcaInput")));
		    Select selectClase = new Select(driver.findElement(By.id("claseAsociarMarca")));
		    waitCuore.repitedCampos(driver, wait, clase, selectClase, "text");
		    Thread.sleep(3000);
		    Select selectSubClase = new Select(driver.findElement(By.id("subClaseAsociarMarca")));
		    waitCuore.repitedCampos(driver, wait, subclase, selectSubClase, "text");
		    driver.findElement(By.id("agregarMarcaAsociarMarca")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("nombreInput")).sendKeys(marca);
		    driver.findElement(By.id("comment")).sendKeys("Descripción" + marca);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/modal-container/div/div/alta-marca/div[3]/div/div/button[2]")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(500);
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/simple-notifications/div/simple-notification/div/div/div/div[2]")));
		    String mensajeMarca = driver.findElement(By.xpath("/html/body/app-root/simple-notifications/div/simple-notification/div/div/div/div[2]")).getText();
		    waitCuore.repited(driver, wait);
		    if (mensajeMarca.equals("Ya existe una Marca con el mismo nombre")) {
				System.out.println("La marca " + marca + " ya existe");
				driver.findElement(By.xpath("/html/body/app-root/simple-notifications/div/simple-notification/div/div/div/div[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.className("close")).click();
			    Thread.sleep(1000);
				waitCuore.repited(driver, wait);
				driver.findElement(By.id("focusElement")).click();
			    Thread.sleep(1000);
				waitCuore.repited(driver, wait);
				driver.findElement(By.id("autocomplete_picker_marcaInput")).sendKeys(marca);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"formAsociarMarca\"]/div[1]/div/div/div[2]/div/div[3]/div[1]/field-validator/autocomplete-picker/ul/li/a")).click();
		    	driver.findElement(By.id("DescriptionAsociarMarca")).sendKeys("Descripción" + marca);
		    	driver.findElement(By.id("gurdadrSalirAsociarMarca")).click();
			    Thread.sleep(1000);
				waitCuore.repited(driver, wait);
		    	driver.findElement(By.id("focusElement")).click();
		    	System.out.println("Se ha asociado correctamente la marca " + marca);
			}else {
			    Thread.sleep(1000);
				waitCuore.repited(driver, wait);
				driver.findElement(By.id("autocomplete_picker_marcaInput")).sendKeys(marca);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"formAsociarMarca\"]/div[1]/div/div/div[2]/div/div[3]/div[1]/field-validator/autocomplete-picker/ul/li/a")).click();
		    	driver.findElement(By.id("DescriptionAsociarMarca")).sendKeys("Descripción" + marca);
		    	Thread.sleep(2000);
		    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("DescriptionAsociarMarca"))));
		    	driver.findElement(By.id("gurdadrSalirAsociarMarca")).click();
			    Thread.sleep(1000);
				waitCuore.repited(driver, wait);
		    	driver.findElement(By.id("focusElement")).click();
		    	System.out.println("Se ha asociado correctamente la marca " + marca);}
	}
}