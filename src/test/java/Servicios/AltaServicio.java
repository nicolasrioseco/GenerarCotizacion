package Servicios;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaServicio {
	
	public void crearServicio(WebDriver driver, WebDriverWait wait,
			String fechaHasta, String clase, String subclase, String acuerdo, String servicio) throws InterruptedException{    
    
		/*             Alta de Servicio         */
    
		//espera a que exista y cliquea sobre el boton para generar un nuevo Servicio
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addService")));
		driver.findElement(By.id("addService")).click();
		//Esperar a que se acceda correctamente a la pantalla nuevo Servicio
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addServiceSend")));
		driver.findElement(By.id("name")).sendKeys(servicio);
		driver.findElement(By.id("addServiceDateFrom_input")).click();
		driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
		driver.findElement(By.id("addServiceDateUntil_input")).click();
	    driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
	    driver.findElement(By.id("addServiceDateUntil_input")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE + "20");
	    driver.findElement(By.xpath("//td[contains(@class, 'active')]")).click();
		Select dador = new Select(driver.findElement(By.id("addServiceLessorId")));
		waitCuore.repitedCampos(driver, wait, "2", dador, "value");
		Select facturador = new Select(driver.findElement(By.id("addServiceInvoiceBy")));
		waitCuore.repitedCampos(driver, wait, "2", facturador, "value");
		driver.findElement(By.id("tabGoodsThird")).click();
		driver.findElement(By.id("tabGoodComafi")).click();
		driver.findElement(By.id("tabGoodTCC")).click();
		driver.findElement(By.id("tabGoodsNew")).click();
		driver.findElement(By.id("tabGoodsUsed")).click();
		driver.findElement(By.id("tabGoodsStock")).click();
		driver.findElement(By.id("tabGoodsAddGood")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchGoodCancelConfirmation")));
	    driver.findElement(By.id("searchGoodDefineGrouper")).click();
	    Thread.sleep(2000);
	    waitCuore.repited(driver, wait);
	    Thread.sleep(500);
	    waitCuore.repited(driver, wait);
	    Select claseAgrup = new Select(driver.findElement(By.id("searchGoodClass")));
	    waitCuore.repitedCampos(driver, wait, clase, claseAgrup, "text");
	    Select subclaseAgrup = new Select(driver.findElement(By.id("searchGoodSubClass")));
	    waitCuore.repitedCampos(driver, wait, subclase, subclaseAgrup, "text");
	    Thread.sleep(5000);
	    waitCuore.repited(driver, wait);
	    driver.findElement(By.id("searchGoodDefineGroupConfirmation")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    driver.findElement(By.id("focusElement")).click();
	    Thread.sleep(4000);
		waitCuore.repited(driver, wait);
		
//		driver.findElement(By.id("searchGoodAddGood")).click();
//		driver.findElement(By.id("nombreSearch")).sendKeys(version);
//		driver.findElement(By.id("searchGood")).click();
//		Thread.sleep(1000);
//		waitCuore.repited(driver, wait);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
//		driver.findElement(By.id("checkall")).click();
//		driver.findElement(By.id("searchGoodDefineGoodConfirmation")).click();
//	    Thread.sleep(1000);
//		waitCuore.repited(driver, wait);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
//		driver.findElement(By.id("focusElement")).click();
//		Thread.sleep(2000);
		driver.findElement(By.id("tabAgreements")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabAgreementsAddAgreement")));
		driver.findElement(By.id("tabAgreementsAddAgreement")).click();
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchAgreementsAccept")));
		driver.findElement(By.id("agreementName")).sendKeys(acuerdo);
		driver.findElement(By.xpath("//*[@id=\"collapseAgreements\"]/div/div[3]/div/button[2]")).click();////*[@id="collapseAgreements"]/div/div[3]/div/button[2]
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		driver.findElement(By.id("checkall")).click();
		driver.findElement(By.id("searchAgreementsAccept")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
		driver.findElement(By.id("focusElement")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("addServiceSend")).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
		driver.findElement(By.id("focusElement")).click();
	}
}