package Bienes.Modelo;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaModelo {
	
	public void crearModelo(WebDriver driver, WebDriverWait wait, int modeloItems, String clase, String subclase, String marca, String modelo) throws InterruptedException{    
    
		/*             Alta de Clase         */
    
		if (modeloItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar una Clase
		    driver.findElement(By.id("addModel")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva Clase
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("inputName")));
		    Select selectClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'claseAltaModelo')]")));
		    selectClase.selectByVisibleText(clase);
		    Thread.sleep(2000);
		    Select selectSubClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'subClaseAltaModelo')]")));
		    selectSubClase.selectByVisibleText(subclase);
		    Thread.sleep(2000);
		    Select selectMarca = new Select(driver.findElement(By.xpath("//select[contains(@id, 'marcaAltaModelo')]")));
		    selectMarca.selectByVisibleText(marca);
		    driver.findElement(By.id("inputName")).sendKeys(modelo);
		    driver.findElement(By.id("descripcionAltaModelo")).sendKeys("Descripción" + modelo);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[1]/td[6]/label/span")).click();
		    Select selectSeguro = new Select(driver.findElement(By.id("tabla_cmb_5")));
		    selectSeguro.selectByValue("3");
		    driver.findElement(By.xpath("//*[@id=\"formAltaModelo\"]/div/div/div[2]/div/div/button[2]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    String modeloCreado = new String (driver.findElement(By.xpath("//div[contains(text(),'Se ha creado correctamente un Modelo')]")).getText());
		    assertEquals("Se ha creado correctamente un Modelo", modeloCreado);
		    System.out.println("Se creó correctamente el modelo " + modelo);
		}else
			System.out.println("Ya existía el modelo " + modelo);
	}
}