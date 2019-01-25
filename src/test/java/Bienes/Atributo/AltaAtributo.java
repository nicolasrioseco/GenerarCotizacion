package Bienes.Atributo;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaAtributo {
	
	public void crearAtributo(WebDriver driver, WebDriverWait wait, int cantItems, String atributo) throws InterruptedException{    
    
		/*             Alta de Atributos         */
    
		if (cantItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar un Atributo
		    Thread.sleep(5000);
			driver.findElement(By.id("addAttribute")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo atributo
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("inputDefault")));
		    driver.findElement(By.id("inputDefault")).sendKeys(atributo);
		    driver.findElement(By.xpath("//input[contains(@placeholder, 'Ingresar texto')]")).sendKeys("Descripción" + atributo);
		    Select tipoDato = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tiposDatosAltaAtributos')]")));
		    tipoDato.selectByValue("1");
		    Select tipoFormato = new Select(driver.findElement(By.xpath("//select[contains(@id, 'formatoAltaAtributos')]")));
		    tipoFormato.selectByValue("2");
		    driver.findElement(By.xpath("//*[@id=\"router_container\"]/alta-campo/div[2]/div/form/div/div[2]/div/button[2]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    String atributoCreado = new String (driver.findElement(By.xpath("//div[contains(text(),'Se ha guardado correctamente el atributo')]")).getText());
		    assertEquals("Se ha guardado correctamente el atributo", atributoCreado);
		    System.out.println("Se creó correctamente el atributo " + atributo);
		}else
			System.out.println("Ya existía el atributo " + atributo);
	}
}