package Bienes.BienXSeguros;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BandejaBienXSeguros {
	
	public void analisisBienSeguros(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException{    
    
		/*             Acceso al Análisis de Bien por Seguros         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuInbox")));
	    driver.findElement(By.id("mainMenuInbox")).click();
	    //espera a que exista y cliquea sobre el boton para posicionarse en el Inbox
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuInbox")));
	    driver.findElement(By.id("menuInbox")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("Analizar_Bien_por_Seguros")));
	    driver.findElement(By.xpath("//*[contains(text(),'Pendientes:')]")).click();
	    driver.findElement(By.id("Analizar_Bien_por_Seguros")).click();
	    Thread.sleep(6000);
	    //WebElement objeto = driver.findElement(By.xpath("//*[contains(text(),'" + version + "')]"));
	    //Actions actions = new Actions(driver);
	    //actions.moveToElement(objeto).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
	    WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + version + "')]"));
	    WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode.parentNode.parentNode;", element);
	    WebElement play = parent.findElement(By.xpath("//a[contains(@data-original-title,'Iniciar')]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", play);
	}
}