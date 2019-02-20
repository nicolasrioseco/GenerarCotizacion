package Bienes.Modelo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaModelo {
	
	public void crearModelo(WebDriver driver, WebDriverWait wait, String clase, String subclase, String marca, String modelo) throws InterruptedException{    
    
		/*             Alta de Clase         */
    
	    	//espera a que exista y cliquea sobre el boton para generar una Clase
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    driver.findElement(By.id("addModel")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva Clase
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("inputName")));
		    Select selectClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'claseAltaModelo')]")));
		    waitCuore.repitedCampos(driver, wait, clase, selectClase, "text");
		    Thread.sleep(2000);
		    Select selectSubClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'subClaseAltaModelo')]")));
		    waitCuore.repitedCampos(driver, wait, subclase, selectSubClase, "text");
		    Thread.sleep(2000);
		    Select selectMarca = new Select(driver.findElement(By.xpath("//select[contains(@id, 'marcaAltaModelo')]")));
		    waitCuore.repitedCampos(driver, wait, marca, selectMarca, "text");
		    driver.findElement(By.id("inputName")).sendKeys(modelo);
		    driver.findElement(By.id("descripcionAltaModelo")).sendKeys("Descripción" + modelo);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[1]/td[6]/label/span")).click();
		    Select selectSeguro = new Select(driver.findElement(By.id("tabla_cmb_5")));
		    waitCuore.repitedCampos(driver, wait, "3", selectSeguro, "value");
		    driver.findElement(By.xpath("//*[@id=\"formAltaModelo\"]/div/div/div[2]/div/div/button[2]")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    System.out.println("Se creó correctamente el modelo " + modelo);
	}
}