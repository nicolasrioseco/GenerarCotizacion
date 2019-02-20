package Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitCuore {

	static By element = By.id("spinnerLoader");
	
	public static void repited(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		   
		for (int i = 0; i < 75; i++) {
			Boolean prueba = existsElement(driver, wait);
			if (prueba == false) {
				i = 76;
			}else {
				System.out.println("Esperando a que cargue la pantalla");
				Thread.sleep(1000);
			}
			}
		}
		
	private static boolean existsElement(WebDriver driver, WebDriverWait wait) {
		try {
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	    } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException | java.lang.NullPointerException e) {
	    	return false;
    	}
		return true;
	} 
	
	
	public static void repitedCampos(WebDriver driver, WebDriverWait wait, String opcionBuscada, Select selectCampo, String tipoSeleccion) throws InterruptedException {
		   
		for (int i = 0; i < 75; i++) {
			Boolean prueba = existsOpcion(driver, wait, opcionBuscada, selectCampo, tipoSeleccion);
			if (prueba == false) {
				i = 76;
			}else {
				System.out.println("Esperando a que se carguen las opciones del campo");
				Thread.sleep(1000);
			}
			}
		}
		
	private static boolean existsOpcion(WebDriver driver, WebDriverWait wait, String opcionBuscada, Select selectCampo, String tipoSeleccion) {
		
		try {
			
			if (tipoSeleccion.equals("text")) {
				selectCampo.selectByVisibleText(opcionBuscada);
			}else if (tipoSeleccion.equals("value")) {
				selectCampo.selectByValue(opcionBuscada);
			}else if (tipoSeleccion.equals("index")) {
				selectCampo.selectByIndex(Integer.parseInt(opcionBuscada));
			}
	    } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException | java.lang.NullPointerException e) {
	    	return true;
    	}
		return false;
	} 
}