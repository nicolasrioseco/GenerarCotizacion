package Cotizador;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AnalizadaPendienteRevision {

	public void analizadaPendienteRevision(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException{

		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, 'Editar')]")));
		driver.findElement(By.xpath("//*[contains(@title, 'Editar')]")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseDatosFinancieros_1\"]/div/div[8]/div/div/div/div/div/div[5]/div/button")));
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
