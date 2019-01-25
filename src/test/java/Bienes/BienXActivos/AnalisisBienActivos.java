package Bienes.BienXActivos;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalisisBienActivos {
	
	public void analisisBienActivos(WebDriver driver, WebDriverWait wait, String fechaDesde, String fechaHasta) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Activos         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    Thread.sleep(4000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("searchSupplierDoSearch")));
	    Thread.sleep(6000);
	    driver.findElement(By.id("secondaryMarketAnalysisAssets")).sendKeys("Mercado QA");
	    driver.findElement((By.id("searchSupplierDoSearch"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("spplierSearch")));
	    driver.findElement(By.id("supplierDocNumberSearch")).sendKeys("30678519681");
	    Thread.sleep(1500);
	    driver.findElement((By.id("spplierSearch"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
	    driver.findElement((By.id("checkall"))).click();
	    driver.findElement((By.id("supplierAccept"))).click();
	    Thread.sleep(800);
	    driver.findElement(By.xpath("//input[contains(@id, 'select_picker_depreciationDate')]")).sendKeys("15/01/2019");
	    driver.findElement(By.id("depreciationValue")).sendKeys("700000");
	    driver.findElement(By.id("depreciationFMV")).sendKeys("700000");
	    Select moneda = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_depreciationCurrency')]")));
	    moneda.selectByValue("1000");
	    driver.findElement(By.id("depreciation1Porc")).sendKeys("10");
	    driver.findElement(By.id("depreciation2Porc")).sendKeys("20");
	    driver.findElement(By.id("depreciation3Porc")).sendKeys("30");
	    driver.findElement(By.id("depreciation4Porc")).sendKeys("40");
	    driver.findElement(By.id("depreciation5Porc")).sendKeys("50");
	    driver.findElement(By.id("depreciation6PlusPorc")).sendKeys("60");
	    driver.findElement(By.xpath("//*[@id=\"collapseAnalysisCRRVR\"]/div/div/div/div/div/button")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("ccrTerm0")).sendKeys("12" + Keys.TAB + "11" + Keys.ENTER);
	    driver.findElement(By.id("crrResidualValue0")).sendKeys("80");
	    driver.findElement(By.xpath("//*[@id=\"collapseAnalysisCRRVR\"]/div/div/div/div/div/button")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("ccrTerm1")).sendKeys("24" + Keys.TAB + "11" + Keys.ENTER);
	    driver.findElement(By.id("crrResidualValue1")).sendKeys("50");
	    driver.findElement(By.xpath("//*[@id=\"collapseAnalysisCRRVR\"]/div/div/div/div/div/button")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("ccrTerm2")).sendKeys("36" + Keys.TAB + "11" + Keys.ENTER);
	    driver.findElement(By.id("crrResidualValue2")).sendKeys("30");
	    driver.findElement(By.xpath("//input[contains(@id, 'select_picker_resolutionFrom')]")).sendKeys(fechaDesde);
	    driver.findElement(By.xpath("//input[contains(@id, 'select_picker_resolutionUnti')]")).sendKeys(fechaHasta + "/2020");
	    driver.findElement(By.id("textArea")).sendKeys("Analisis Activos Automatizado QA");
	    driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-analisis-bien/analizar-bien-activo/form/div/div/div/div/button[3]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
	    Thread.sleep(1000);
	    driver.findElement(By.id("focusElement")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).getText());
	    //driver.findElement(By.xpath("//div[contains(text(),'El Análisis se ha finalizado correctamente')]")).click();
	    System.out.println(mensaje);
	    Thread.sleep(7000);
	}
}