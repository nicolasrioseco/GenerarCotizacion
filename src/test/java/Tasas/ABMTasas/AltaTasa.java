package Tasas.ABMTasas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaTasa {
	
	public void crearTasa(WebDriver driver, WebDriverWait wait, int cantItems, String subtasa) throws InterruptedException{    
    
		/*             Alta de Tasas         */
    
		if (cantItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar una nueva Tasa
		    Thread.sleep(10000);
			driver.findElement(By.id("addRate")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva tasa
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptar")));
		    Select tipoTasa = new Select(driver.findElement(By.id("tipoTasaAlta")));
		    tipoTasa.selectByValue("Fija");
		    Thread.sleep(1000);
		    Select moneda = new Select(driver.findElement(By.id("monedaAlta")));
		    moneda.selectByValue("1000");
		    Thread.sleep(1000);
		    driver.findElement(By.id("subTasaAlta")).sendKeys(subtasa);
		    Thread.sleep(4000);
		    driver.findElement(By.id("aceptar")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(7000);
		}else
			System.out.println("Ya existía la subtasa " + subtasa);
	}
}