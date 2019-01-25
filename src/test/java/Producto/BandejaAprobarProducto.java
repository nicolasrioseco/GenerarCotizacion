package Producto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BandejaAprobarProducto {
	
	public void aprobarProducto(WebDriver driver, WebDriverWait wait, String producto) throws InterruptedException{    
    
		/*             Acceso a la tarea Aprobar Producto         */
    
		
	    //espera a que exista y cliquea sobre el boton de la sección de Inbox
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuInbox")));
	    driver.findElement(By.id("mainMenuInbox")).click();
	    //espera a que exista y cliquea sobre el boton para posicionarse en el Inbox
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuInbox")));
	    driver.findElement(By.id("menuInbox")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("Aprobar_Producto")));
	    driver.findElement(By.xpath("//*[contains(text(),'Pendientes:')]")).click();
	    driver.findElement(By.id("Aprobar_Producto")).click();
	    Thread.sleep(5000);
	    //WebElement tareaActivo = driver.findElement(By.xpath("//span[contains(text(), '" + version + "')]"));
	    //Actions actions = new Actions(driver);
	    //actions.moveToElement(tareaActivo).click().sendKeys(Keys.TAB, Keys.ENTER).build().perform();
	    WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + producto + "')]"));
	    WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode.parentNode.parentNode;", element);
	    WebElement play = parent.findElement(By.xpath("//a[contains(@data-original-title,'Iniciar')]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", play);
	    
	}
}