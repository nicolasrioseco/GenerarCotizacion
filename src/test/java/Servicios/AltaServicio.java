package Servicios;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaServicio {
	
	public void crearServicio(WebDriver driver, WebDriverWait wait, String fechaDesde, 
			String fechaHasta, String version, String acuerdo, String servicio) throws InterruptedException{    
    
		/*             Alta de Servicio         */
    
		//espera a que exista y cliquea sobre el boton para generar un nuevo Servicio
		Thread.sleep(5000);
		driver.findElement(By.id("addService")).click();
		//Esperar a que se acceda correctamente a la pantalla nuevo Servicio
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addServiceSend")));
		driver.findElement(By.id("name")).sendKeys(servicio);
		driver.findElement(By.id("addServiceDateFrom_input")).sendKeys(fechaDesde);
		driver.findElement(By.id("addServiceDateUntil_input")).sendKeys(fechaHasta + "/2020");
		Select dador = new Select(driver.findElement(By.id("addServiceLessorId")));
		dador.selectByValue("2");
		Select facturador = new Select(driver.findElement(By.id("addServiceInvoiceBy")));
		facturador.selectByValue("2");
		driver.findElement(By.id("tabGoodsThird")).click();
		driver.findElement(By.id("tabGoodComafi")).click();
		driver.findElement(By.id("tabGoodTCC")).click();
		driver.findElement(By.id("tabGoodsNew")).click();
		driver.findElement(By.id("tabGoodsUsed")).click();
		driver.findElement(By.id("tabGoodsStock")).click();
		driver.findElement(By.id("tabGoodsAddGood")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchGoodCancelConfirmation")));
		driver.findElement(By.id("searchGoodAddGood")).click();
		driver.findElement(By.id("nombreSearch")).sendKeys(version);
		driver.findElement(By.id("searchGood")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		driver.findElement(By.id("checkall")).click();
		driver.findElement(By.id("searchGoodDefineGoodConfirmation")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tabAgreements")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabAgreementsAddAgreement")));
		driver.findElement(By.id("tabAgreementsAddAgreement")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchAgreementsAccept")));
		driver.findElement(By.id("agreementName")).sendKeys(acuerdo);
		driver.findElement(By.xpath("//*[@id=\"collapseAgreements\"]/div/div[3]/div/button[2]")).click();////*[@id="collapseAgreements"]/div/div[3]/div/button[2]
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		driver.findElement(By.id("checkall")).click();
		driver.findElement(By.id("searchAgreementsAccept")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("addServiceSend")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("focusElement")).click();
	}
}