package Bienes.SubClase;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaSubClase {
	
	public void crearSubClase(WebDriver driver, WebDriverWait wait, int subclaseItems, String atributo, String clase, String subclase) throws InterruptedException{    
    
		/*             Alta de SubClase         */
    
		if (subclaseItems == 0) {
	    	//espera a que exista y cliquea sobre el boton para generar una SubClase
		    driver.findElement(By.id("addSubClass")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva SubClase
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreSubClaseAltaSubClase")));
		    Select selectClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'claseAltaSubClase')]")));
		    selectClase.selectByVisibleText(clase);
		    driver.findElement(By.id("nombreSubClaseAltaSubClase")).sendKeys(subclase);
		    driver.findElement(By.id("descripcionAltaSubClase")).sendKeys("Descripción" + subclase);
		    Select selectIVA = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_6')]")));
		    selectIVA.selectByValue("3");
		    Thread.sleep(300);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[2]/td[6]/label/span")).click();	    
		    Thread.sleep(300);
		    Select selectTipificacion = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_1')]")));
		    selectTipificacion.selectByValue("23");
		    Thread.sleep(800);
		    Select selectPoliza = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_4')]")));
		    selectPoliza.selectByValue("1");
		    Thread.sleep(300);
		    driver.findElement(By.xpath("//a[contains(@id, 'asociarAtributoAlta')]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/form/div[1]/div/div/input")).sendKeys(atributo);//*[@id="collapseOne"]/div/form/div[2]/div/button[2]
		    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/form/div[2]/div/button[2]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("checkall")).click();
		    driver.findElement(By.xpath("/html/body/modal-container/div/div/search-attributes/div[3]/div/button[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[5]/label/span")).click();
		    Thread.sleep(300);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[7]/label/span")).click();
		    Thread.sleep(300);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[8]/select-picker-input/div/button")).click();
		    driver.findElement(By.xpath("/html/body/div/div/ul/li/a")).click();
		    driver.findElement(By.id("guadarSalirAltaSubClase")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    String subclaseCreada = new String (driver.findElement(By.xpath("//div[contains(text(),'Se ha creado correctamente una SubClase')]")).getText());
		    assertEquals("Se ha creado correctamente una SubClase", subclaseCreada);
		    System.out.println("Se creó correctamente la subclase " + subclase);
		}else
			System.out.println("Ya existía la subclase " + subclase);
	}
}