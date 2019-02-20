package Bienes.SubClase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaSubClase {
	
	public void crearSubClase(WebDriver driver, WebDriverWait wait, String atributo, String clase, String subclase) throws InterruptedException{    
    
		/*             Alta de SubClase         */
    
	    	//espera a que exista y cliquea sobre el boton para generar una SubClase
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("addSubClass")).click();
		    //Esperar a que se acceda correctamente a la pantalla nueva SubClase
			Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("nombreSubClaseAltaSubClase")));
		    Select selectClase = new Select(driver.findElement(By.xpath("//select[contains(@id, 'claseAltaSubClase')]")));
		    waitCuore.repitedCampos(driver, wait, clase, selectClase, "text");
		    driver.findElement(By.id("nombreSubClaseAltaSubClase")).sendKeys(subclase);
		    driver.findElement(By.id("descripcionAltaSubClase")).sendKeys("Descripción" + subclase);
		    Select selectIVA = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_6')]")));
		    waitCuore.repitedCampos(driver, wait, "3", selectIVA, "value");
		    Thread.sleep(300);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[2]/td[6]/label/span")).click();	    
		    Thread.sleep(1000);
		    Select selectTipificacion = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_1')]")));
		    waitCuore.repitedCampos(driver, wait, "23", selectTipificacion, "value");
		    Select selectPoliza = new Select(driver.findElement(By.xpath("//select[contains(@id, 'tabla_cmb_4')]")));
		    waitCuore.repitedCampos(driver, wait, "1", selectPoliza, "value");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//a[contains(@id, 'asociarAtributoAlta')]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/form/div[1]/div/div/input")).sendKeys(atributo);//*[@id="collapseOne"]/div/form/div[2]/div/button[2]
		    driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/form/div[2]/div/button[2]")).click();
		    Thread.sleep(4000);
		    driver.findElement(By.id("checkall")).click();
		    driver.findElement(By.xpath("/html/body/modal-container/div/div/search-attributes/div[3]/div/button[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[5]/label/span")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[7]/label/span")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]/td[8]/select-picker-input/div/button")).click();
		    driver.findElement(By.xpath("/html/body/div/div/ul/li/a")).click();
		    driver.findElement(By.id("guadarSalirAltaSubClase")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    System.out.println("Se creó correctamente la subclase " + subclase);
	}
}