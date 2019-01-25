package Tasas.ABMTasaTTR;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaTTR {
	
	public void crearTTR(WebDriver driver, WebDriverWait wait, int cantItems, String subtasa) throws InterruptedException{    
    
		/*             Alta de TTR         */
    
		if (cantItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar una nueva Tasa TTR
		    Thread.sleep(5000);
			driver.findElement(By.id("addTransferenceRate")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva tasa TTR
			Thread.sleep(6000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("aceptarAlta")));
		    Select dador = new Select(driver.findElement(By.id("empresaAlta")));
		    dador.selectByValue("2");
		    Select tipoTasa = new Select(driver.findElement(By.id("tipoTasaAlta")));
		    tipoTasa.selectByValue("1");
		    Thread.sleep(6000);
		    Select subTasa = new Select(driver.findElement(By.id("subTipoTasaAlta")));
		    subTasa.selectByVisibleText(subtasa);
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/ttr-search/ttr-modal/div/div/form/div[2]/div/div[2]/field-validator/div/grid-simple-view/div/div/div[1]/div[2]/div/div/span/a")).click();
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/ttr-search/ttr-modal/div/div/form/div[2]/div/div[2]/field-validator/div/grid-simple-view/div/div/div[1]/div[2]/div/div/span/a")).click();
		    driver.findElement(By.id("halfLife0Alta")).sendKeys("1");
		    driver.findElement(By.id("interest0Alta")).sendKeys("1");
		    driver.findElement(By.id("halfLife1Alta")).sendKeys("100");
		    driver.findElement(By.id("interest1Alta")).sendKeys("100");
		    driver.findElement(By.id("aceptarAlta")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(5000);
		}else
			System.out.println("Ya existía la ttr para la subtasa " + subtasa);
	}
}