package Bienes.EvaluarNuevoBien;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class NuevoBienTentativo {
	
	public void nuevoBienTentativo(WebDriver driver, WebDriverWait wait, String fechaDesde, String fechaHasta, String clase,
			 	String subclase, String marcaTentativa, String modeloTentativa, String versionTentativa) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Activos         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("taskClosureCollapse")));
	    waitCuore.repited(driver, wait);
	    driver.findElement(By.xpath("//*[@id=\"assessTentativeGood\"]/div/div[2]/div/button")).click();
	    Thread.sleep(1000);
	    waitCuore.repited(driver, wait);
	    Select selectClase = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_class')]")));
	    waitCuore.repitedCampos(driver, wait, clase, selectClase, "text");
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    Select selectSubClase = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_subclass')]")));
	    waitCuore.repitedCampos(driver, wait, subclase, selectSubClase, "text");
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select selectMarca = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_brand')]")));
		waitCuore.repitedCampos(driver, wait, marcaTentativa, selectMarca, "text");
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select selectModelo = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_mode')]")));
		waitCuore.repitedCampos(driver, wait, modeloTentativa, selectModelo, "text");
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select selectVersion = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_versionName')]")));
		waitCuore.repitedCampos(driver, wait, versionTentativa, selectVersion, "text");
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement((By.xpath("//*[@id=\"collapseGoodNodeGroup\"]/div/div[2]/div/div/button[2]"))).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), '" + versionTentativa + "')]")));
	    driver.findElement((By.xpath("//td[contains(text(), '" + versionTentativa + "')]"))).click();
	    driver.findElement((By.xpath("/html/body/modal-container/div/div/good-search-only/div[3]/div/button[2]"))).click();
	    Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select resolucion = new Select(driver.findElement(By.id("taskAction")));
		waitCuore.repitedCampos(driver, wait, "Normalizar", resolucion, "text");
		driver.findElement(By.id("taskObservacions")).sendKeys("Reemplazo Bien Tentativo Automatizado");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.id("finishTask")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Bandeja de Tareas')]")));
	    System.out.println("El reemplazado correctamente el bien tentativo");
	}
}