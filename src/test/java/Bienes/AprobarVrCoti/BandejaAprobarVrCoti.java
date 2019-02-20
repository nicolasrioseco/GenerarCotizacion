package Bienes.AprobarVrCoti;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class BandejaAprobarVrCoti {

	public void tareaAprobarVRCoti(WebDriver driver, WebDriverWait wait, String cotizacion) throws InterruptedException{    
		/*             Acceso a la tarea Aprobar VR Cotización         */


		//espera a que exista y cliquea sobre el boton de la sección de Inbox
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuInbox")));
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("mainMenuInbox")).click();
		//espera a que exista y cliquea sobre el boton para posicionarse en el Inbox
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menuInbox")));
		driver.findElement(By.id("menuInbox")).click();
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Aprobar_VR_Cotización")));
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[contains(text(),'Pendientes:')]")).click();
		driver.findElement(By.id("Aprobar_VR_Cotización")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		//WebElement tareaActivo = driver.findElement(By.xpath("//span[contains(text(), '" + version + "')]"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(tareaActivo).click().sendKeys(Keys.TAB, Keys.ENTER).build().perform();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'C" + cotizacion + "')]"));
		WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode.parentNode.parentNode;", element);
		WebElement play = parent.findElement(By.xpath("//a[contains(@data-original-title,'Iniciar')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", play);
	}
}
