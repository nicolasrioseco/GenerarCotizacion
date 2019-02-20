package Bienes.Bien;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaBien {
	
	public void crearBien(WebDriver driver, WebDriverWait wait, String clase, String subclase, String marca, String modelo, String version, String atributo) throws InterruptedException{    
    
		/*             Alta de Bien         */
    
	   	//espera a que exista y cliquea sobre el boton para generar un Bien
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("addGoods")).click();
	    //Esperar a que se acceda correctamente a la pantalla nuevo Bien
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("AnalizarAltaBien")));
	    Thread.sleep(5000);
	    Select selectClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'claseAltaBienes')]")));
	    waitCuore.repitedCampos(driver, wait, clase, selectClase, "text");
	    Thread.sleep(2000);
	    Select selectSubClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'suClaseAltaBienes')]")));
	    waitCuore.repitedCampos(driver, wait, subclase, selectSubClase, "text");
	    Thread.sleep(2000);
	    Select selectMarca = new Select(driver.findElement(By.xpath("//select[contains(@id, 'marcaAltaBienes')]")));
	    waitCuore.repitedCampos(driver, wait, marca, selectMarca, "text");
	    Thread.sleep(2000);
	    Select selectModelo = new Select(driver.findElement(By.xpath("//select[contains(@id, 'modeloAltaBienes')]")));
	    waitCuore.repitedCampos(driver, wait, modelo, selectModelo, "text");
	    WebElement tdAtributo = driver.findElement(By.xpath("//td[contains(text(),'" + atributo + "')]"));
	    WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", tdAtributo);
	    parent.findElement(By.tagName("input")).sendKeys(version);
	    driver.findElement(By.id("AnalizarAltaBien")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    driver.findElement(By.id("focusElement")).click();
	    System.out.println("Se creó correctamente el bien: " + clase + "-" + subclase + "-" + marca + "-" + modelo + "-" + version);
	}
}