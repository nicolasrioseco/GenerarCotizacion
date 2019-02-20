package Bienes.Atributo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaAtributo {
	
	public void crearAtributo(WebDriver driver, WebDriverWait wait, String atributo) throws InterruptedException{    
    
		/*             Alta de Atributos         */
    
	    	//espera a que exista y cliquea sobre el boton para generar un Atributo
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
			driver.findElement(By.id("addAttribute")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo atributo
			Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("inputDefault")));
		    driver.findElement(By.id("inputDefault")).sendKeys(atributo);
		    driver.findElement(By.xpath("//input[contains(@placeholder, 'Ingresar texto')]")).sendKeys("Descripción" + atributo);
		    Select tipoDato = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tiposDatosAltaAtributos')]")));
		    waitCuore.repitedCampos(driver, wait, "1", tipoDato, "value");
		    Select tipoFormato = new Select(driver.findElement(By.xpath("//select[contains(@id, 'formatoAltaAtributos')]")));
		    waitCuore.repitedCampos(driver, wait, "2", tipoFormato, "value");
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/alta-campo/div[2]/div/form/div/div[2]/div/button[2]")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    System.out.println("Se creó correctamente el atributo " + atributo);
	}
}