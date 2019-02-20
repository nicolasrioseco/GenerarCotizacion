package Cotizador;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class RetomarCotiNewBien {
	
	public void aprobarCotiNewBien(WebDriver driver, WebDriverWait wait, String versionTentativa, String version) throws InterruptedException, IOException{   
		
    waitCuore.repited(driver, wait);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, 'Editar')]")));
    driver.findElement(By.xpath("//*[contains(@title, 'Editar')]")).click();
    Thread.sleep(1000);
	waitCuore.repited(driver, wait);
	
	driver.findElement(By.xpath("//*[@id=\"good0\"]/div/div[1]/div[3]/label/input[@id=\"verifyVR\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"good0\"]/div/div[1]/div[3]/div/input")).sendKeys("Solicitud VR Automatizado Bien 1");
	driver.findElement(By.xpath("//*[@id=\"good1\"]/div/div[1]/div[3]/label/input[@id=\"verifyVR\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"good1\"]/div/div[1]/div[3]/div/input")).sendKeys("Solicitud VR Automatizado Bien 2");
	
	String spanVersion = driver.findElement(By.xpath("//div[contains(@id, 'collapseSeguros')]//div[contains(@id,'classundefined')]/div/div/div/div/div/div[1]//span[3]")).getText();
	int divVersion;
	if (spanVersion.equals(version)) {
		divVersion = 1;
	}else{
		divVersion = 2;
		}
	
	Select asegTentativa = new Select (driver.findElement(By.xpath("//div[contains(@id, 'collapseSeguros')]//div[contains(@id,'classundefined')]/div/div/div/div/div/div[" + divVersion + "]//select[contains(@id,'select_picker_carrier')]")));
    //Select asegTentativa = new Select (parent.findElement(By.xpath("select[contains(@id,'select_picker_carrier')]")));
	waitCuore.repitedCampos(driver, wait, "7", asegTentativa, "value");
	Thread.sleep(1000);
	waitCuore.repited(driver, wait);
	Select polizaTentativa = new Select (driver.findElement(By.xpath("//div[contains(@id, 'collapseSeguros')]//div[contains(@id,'classundefined')]/div/div/div/div/div/div[" + divVersion +"]//select[contains(@id,'select_picker_policy')]")));
	waitCuore.repitedCampos(driver, wait, "19", polizaTentativa, "value");
	Thread.sleep(1000);
	waitCuore.repited(driver, wait);
	Select cobertura = new Select (driver.findElement(By.xpath("//div[contains(@id, 'collapseSeguros')]//div[contains(@id,'classundefined')]/div/div/div/div/div/div[" + divVersion +"]//select[contains(@id,'select_picker_coverage')]")));
	waitCuore.repitedCampos(driver, wait, "1", cobertura, "value");
	Thread.sleep(1000);
	waitCuore.repited(driver, wait);
   
	
	driver.findElement(By.xpath("//*[@id=\"collapseDatosFinancieros_1\"]/div/div[8]/div/div/div/div/div/div[5]/div/button")).click();
	Thread.sleep(1000);
	waitCuore.repited(driver, wait);
	driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-cotizacion/form/div[3]/div/div/div/div/button[3]")).click();
	Thread.sleep(2000);
	waitCuore.repited(driver, wait);
	driver.findElement(By.xpath("//*[contains(@id, 'focusElement')]")).click(); 
	Thread.sleep(2000);
	waitCuore.repited(driver, wait);
	}
}
